package com.webshop.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.UserDAO;

public class ObrisiKorisnikaSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ObrisiKorisnikaSerlvet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao = new UserDAO(); 
		userdao.deleteUser(Integer.parseInt(request.getParameter("id"))); 
		response.sendRedirect("PregledKorisnikaServlet");
	}
}
