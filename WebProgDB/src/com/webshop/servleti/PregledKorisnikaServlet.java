package com.webshop.servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.UserDAO;
import com.webshop.obj.User;

public class PregledKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PregledKorisnikaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null ) { //&& request.getSession().getAttribute("user").toString().equals("steva stevic")) {
			response.sendRedirect("listakorisnika.jsp");

		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}