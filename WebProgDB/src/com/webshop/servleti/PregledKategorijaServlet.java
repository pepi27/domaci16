package com.webshop.servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.ProizvodiDAO;
import com.webshop.obj.Kategorija;


public class PregledKategorijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PregledKategorijaServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// pripremamo odgovor
		
		response.sendRedirect("kategorijeproizvoda.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}