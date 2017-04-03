package com.webshop.servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.UserDAO;
import com.webshop.obj.User;

public class LoginKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginKorisnikaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		UserDAO userdao = new UserDAO(); 
		User user = userdao.getUserByUserAndPass(username, password);
		
		if(user != null) {
			request.getSession(true).setAttribute("user", user);
			response.sendRedirect("index.html");
			return; 
		} else {
			response.sendRedirect("login.html");
		}
	}
}