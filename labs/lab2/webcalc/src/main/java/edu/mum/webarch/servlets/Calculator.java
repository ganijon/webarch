package edu.mum.webarch.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/calc")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = "Simple Calc";
		String docType = "<!DOCTYPE html>";

		out.println(docType + "<html><head><title>" + title + "</title></head>"

				+ "<ul><h3>" + title + "</h3>" + "<body>" + "<form action=\"/myNewWebApp/calc\" method=\"post\">"

				+ "<input type=\"text\" name=\"add_param1\" size=\"10\" />" + " + "
				+ "<input type=\"text\" name=\"add_param2\" size=\"10\" />" + " = "
				+ "<input type=\"text\" name=\"add_result\" size=\"10\" />" + "</br>" + "</br>"
				+ "<input type=\"text\" name=\"mul_param1\" size=\"10\" />" + " * "
				+ "<input type=\"text\" name=\"mul_param2\" size=\"10\" />" + " = "
				+ "<input type=\"text\" name=\"mul_result\" size=\"10\" />" + "</br>" + "</br>"
				+ "<input type=\"submit\" value=\"Calculate\" />" + "</form>" + "</body>" + "</html>");
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMsg = "";
		
		int add_param1 = 0, 
			add_param2 = 0, 
			mul_param1 = 0, 
			mul_param2 = 0;

		try {
			add_param1 = Integer.parseInt(request.getParameter("add_param1"));
			add_param2 = Integer.parseInt(request.getParameter("add_param2"));

			mul_param1 = Integer.parseInt(request.getParameter("mul_param1"));
			mul_param2 = Integer.parseInt(request.getParameter("mul_param2"));

		} catch (NumberFormatException ex) {
			errorMsg = "Bad input";
		}

		int add_result = add_param1 + add_param2;
		int mul_result = mul_param1 * mul_param2;

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = "Simple Calc";
		String docType = "<!DOCTYPE html>";

		out.println(docType + "<html><head><title>" + title + "</title></head>"

				+ "<ul><h3>" + title + "</h3><body>" + "<form action=\"/myNewWebApp/calc\" method=\"get\">"

				+ "<input type=\"text\" name=\"add_param1\" size=\"10\" value='" + add_param1 + "'/>" + " + "
				+ "<input type=\"text\" name=\"add_param2\" size=\"10\" value='" + add_param2 + "'/>" + " = "
				+ "<input type=\"text\" name=\"add_result\" size=\"10\" value='" + add_result + "'/>" + "</br>"
				+ "</br>" 
				+ "<input type=\"text\" name=\"mul_param1\" size=\"10\" value='" + mul_param1 + "'/>" + " * "
				+ "<input type=\"text\" name=\"mul_param2\" size=\"10\" value='" + mul_param2 + "'/>" + " = "
				+ "<input type=\"text\" name=\"mul_result\" size=\"10\" value='" + mul_result + "'/>"
				+ "</br>"+ "</br>" 
				+ "<input type=\"submit\" value=\"Try again\" />" + "</form>" 
				+ "<p style='color:red'>" + errorMsg +"</p>"
				+ "</body>" + "</html>");
		;

	}

}
