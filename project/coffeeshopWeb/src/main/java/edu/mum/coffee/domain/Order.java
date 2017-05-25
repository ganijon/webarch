package edu.mum.coffee.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {


    private Long id;
    private Date orderDate;
    private List<Orderline> orderLines = new ArrayList<Orderline>();
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Orderline> getOrderLines() {
        return Collections.unmodifiableList(orderLines);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        int quantity = 0;
        for (Orderline ol : this.orderLines) {
            quantity += ol.getQuantity();
        }
        return quantity;
    }

    public double getTotalAmount() {
        double totalAmount = 0;

        for (Orderline ol : this.orderLines) {
            totalAmount += ol.getSubtotal();
        }
        return totalAmount;
    }

    public void addOrderLine(Orderline orderLine) {
        orderLine.setOrder(this);
        this.orderLines.add(orderLine);
    }

    public void removeOrderLine(Orderline orderLine) {
        this.orderLines.remove(orderLine);
        orderLine.setOrder(null);
    }

    public void clearOrderLines() {
        for (Orderline orderline : orderLines) {
            orderline.setOrder(null);
        }
        orderLines.clear();
    }

}
