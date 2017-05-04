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

@WebServlet("/withdraw")
public class WithdrawControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/withdraw.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        double withdrawAmount = Double.parseDouble(request.getParameter("withdrawAmount"));

        AppServices.INSTANCE.AccountService.withdraw(accountNumber, withdrawAmount);
        Account account = AppServices.INSTANCE.AccountService.getAccount(accountNumber);

        request.setAttribute("account", account);
        request.setAttribute("withdrawAmount", withdrawAmount);

        RequestDispatcher rd = request.getRequestDispatcher("/withdraw-success.jsp");
        rd.forward(request, response);
    }


}
