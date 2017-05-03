package edu.mum.bank.controllers;

import cs544.exercise5_3.bank.domain.Account;
import cs544.exercise5_3.bank.service.AccountService;
import cs544.exercise5_3.bank.service.IAccountService;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int accountNumber = Integer.parseInt(request.getParameter("accNo"));
        String customerName = request.getParameter("cusNm");

        Account result = AppServices.INSTANCE.AccountService.createAccount(accountNumber, customerName);

        if(result != null) {
            Account newAccount = AppServices.INSTANCE.AccountService.getAccount(accountNumber);
            request.setAttribute("account", newAccount);

            RequestDispatcher view = request.getRequestDispatcher("/details.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect("/error.jsp");
        }


    }
}
