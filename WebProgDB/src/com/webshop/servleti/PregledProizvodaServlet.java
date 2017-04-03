package com.webshop.servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.ProizvodiDAO;
import com.webshop.obj.Proizvod;

public class PregledProizvodaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PregledProizvodaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String vrednostIDK = "";
		PrintWriter pout = response.getWriter();

		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<h3>Web shop</h3>");
		pout.println("<h4>Raspolozivi proizvodi:</h4>");

		pout.println("<form method=\"GET\" action=\"KupiProizvodServlet\">");
		pout.println("<table border=\"1\"><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Cena</th><th>&nbsp;</th></tr>");

		if (request.getParameter("id_k") != null) {
			vrednostIDK = "WHERE kategorija_id=" + request.getParameter("id_k");
		}

		for (Proizvod p : new ProizvodiDAO().getById(vrednostIDK)) {
			// pokupimo podatke za taj red
			long id = p.getId();
			String ime = p.getNaziv();
			double cena = p.getCena();
			// i ispisujemo ih u redu

			pout.println("<tr>");
			pout.println("<td>" + ime + "</td>");
			pout.println("<td>" + cena + "</td>");
			pout.println("<td>");
			// forma za ubacivanje proizvoda u korpu

			pout.println("<input type=\"text\" name=\"kolicina" + id + "\" />");

			pout.println("</td>");
			// kraj ispisa reda
			pout.println("</tr>");
		}

		pout.println("<tr>");
		pout.println("<td colspan=\"3\" align=\"center\">");
		pout.println("<input type=\"submit\" value=\"kupi\" />");
		pout.println("</td>");
		pout.println("</tr>");
		pout.println("</table>");
		pout.println("</form>");
		pout.println("</body>");
		pout.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}