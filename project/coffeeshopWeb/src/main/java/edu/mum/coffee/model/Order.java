package edu.mum.coffee.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private Long id;
    @DateTimeFormat(style = "yy-mm-dd")
    private Date orderDate;
    private Person person;
    @JsonManagedReference
    private Set<Orderline> orderLines = new HashSet<Orderline>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Orderline> getOrderLines() {
        return orderLines;
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
