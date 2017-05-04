package edu.mum.bank.controllers;

import cs544.exercise5_3.bank.domain.Account;
import edu.mum.bank.AppServices;
import edu.mum.bank.Operation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String choice = request.getParameter("operation").toUpperCase();
        Operation operation = Enum.valueOf(Operation.class, choice);

        switch (operation) {
            case CREATE:
                response.sendRedirect("/create");
                break;
            case LIST:
                response.sendRedirect("/list");
                break;
            case DETAILS:
                response.sendRedirect("/details");
                break;
            case DEPOSIT:
                response.sendRedirect("/deposit");
                break;
            case WITHDRAW:
                response.sendRedirect("/withdraw");
                break;
            case TRANSFER:
                response.sendRedirect("/transfer");
                break;
        }
    }
}
