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
import java.util.Collection;

@WebServlet("/list")
public class ListControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Account> list = AppServices.INSTANCE.AccountService.getAllAccounts();
        RequestDispatcher view = request.getRequestDispatcher("/list.jsp");
        request.setAttribute("list", list);
        view.forward(request, response);
    }

}
