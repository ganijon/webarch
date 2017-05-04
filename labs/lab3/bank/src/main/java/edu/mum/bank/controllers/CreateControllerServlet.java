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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int accountNumber = Integer.parseInt(request.getParameter("accNo"));
            String customerName = request.getParameter("cusNm");

            Account newAccount = AppServices.INSTANCE.AccountService.createAccount(accountNumber, customerName);

            request.setAttribute("account", newAccount);

            RequestDispatcher view = request.getRequestDispatcher("/details.jsp");
            view.forward(request, response);

        } catch (Exception ex) {
            response.sendRedirect("/error.jsp");
        }

    }


}
