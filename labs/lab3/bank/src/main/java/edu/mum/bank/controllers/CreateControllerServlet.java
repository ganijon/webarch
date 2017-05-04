package edu.mum.bank.controllers;

import cs544.exercise5_3.bank.domain.Account;
import edu.mum.bank.AppServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        String customerName = request.getParameter("customerName");

        Account newAccount = AppServices.INSTANCE.AccountService.createAccount(accountNumber, customerName);

        String address;
        if (newAccount == null) {
            request.setAttribute("badId", accountNumber);
            address = "/create-error.jsp";
        } else {
            request.setAttribute("account", newAccount);
            address = "/create-success.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(address);
        rd.forward(request, response);
    }


}
