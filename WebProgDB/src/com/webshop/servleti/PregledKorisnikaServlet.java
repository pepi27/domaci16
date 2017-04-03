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
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			UserDAO userdao = new UserDAO();
			List<User> korisnici = userdao.getAllUsers();
			out.println("<h3> Svi korisnici </h3>");
			for (User u : korisnici) {
				out.println("<p style=\"margin: 4px;\">" + u.getUsername() + " " + u.getPassword() + "</p>");
				out.println("<a href=\"ObrisiKorisnikaSerlvet?id=" + u.getId() + "\"><p style=\"margin: 4px;\">delete</p></a>");
				
			}
			out.println("<br>");
			out.println("<a href=\"register.html\"><p style=\"margin: 4px;\">add korisnika</p></a>");
			out.println("</body>");
			out.println("</html>");
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}