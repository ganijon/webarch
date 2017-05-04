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

@WebServlet("/transfer")
public class TransferControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/transfer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        long accountNumberFrom = Long.parseLong(request.getParameter("accountNumberFrom"));
        long accountNumberTo = Long.parseLong(request.getParameter("accountNumberTo"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String description = request.getParameter("description");

        AppServices.INSTANCE.AccountService.transferFunds(accountNumberFrom, accountNumberTo, amount, description);

        Account accountFrom = AppServices.INSTANCE.AccountService.getAccount(accountNumberFrom);
        Account accountTo = AppServices.INSTANCE.AccountService.getAccount(accountNumberTo);

        request.setAttribute("accountFrom", accountFrom);
        request.setAttribute("accountTo", accountTo);
        request.setAttribute("amount", amount);

        RequestDispatcher rd = request.getRequestDispatcher("/transfer-success.jsp");
        rd.forward(request, response);
    }


}
