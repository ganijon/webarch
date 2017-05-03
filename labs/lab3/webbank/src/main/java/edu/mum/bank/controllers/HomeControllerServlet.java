package edu.mum.bank.controllers;

import edu.mum.bank.Operation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String choice = request.getParameter("operation").toUpperCase();
        Operation operation = Enum.valueOf(Operation.class, choice);

        switch (operation) {
            case CREATE:
                response.sendRedirect("/create.jsp");
                break;
            case LIST:
                response.sendRedirect("/list.jsp");
                break;
            case VIEW:
                response.sendRedirect("/details.jsp");
                break;
            case DEPOSIT:
                response.sendRedirect("/deposit.jsp");
                break;
            case WITHDRAW:
                response.sendRedirect("/withdraw.jsp");
                break;
        }
    }
}
