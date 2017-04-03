package com.webshop.servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

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
		response.setContentType("text/html");

		PrintWriter pout = response.getWriter();
		ProizvodiDAO pdao = new ProizvodiDAO();
		List<Kategorija> naziviKategorija = pdao.getKategorija();

		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<h3>Web shop</h3>");
		pout.println("<h4>Kategorije proizvoda:</h4>");

		pout.println("<table border=\"1\"><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Pregled proizvoda</th></tr>");

		for(int i = 0; i < naziviKategorija.size(); i++) {
			pout.println("<tr><td><h4>" + naziviKategorija.get(i).getNaziv() + "</h4></td>" + "<td><a href=\"PregledProizvodaServlet?id_k=" + naziviKategorija.get(i).getId() + "\">detaljnije</a></td></tr>");
		}
		
		pout.println("</table>");
		pout.println("</body>");
		pout.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}