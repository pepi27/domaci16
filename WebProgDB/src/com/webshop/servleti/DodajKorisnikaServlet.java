package com.webshop.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.UserDAO;

public class DodajKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DodajKorisnikaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao = new UserDAO(); 
		userdao.insertUser(request.getParameter("username"), request.getParameter("password"));
		response.sendRedirect("PregledKorisnikaServlet");
	}
}