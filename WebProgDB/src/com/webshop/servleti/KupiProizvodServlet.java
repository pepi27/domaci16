package com.webshop.servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshop.DAO.ProizvodiDAO;
import com.webshop.obj.Proizvod;

public class KupiProizvodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public KupiProizvodServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// preuzimanje parametra
		
		
		// pripremamo odgovor
		response.setContentType("text/html");

		PrintWriter pout = response.getWriter();

		ProizvodiDAO proizvodDAO = new ProizvodiDAO();
		
		List<Proizvod> proizvodi = proizvodDAO.getAllProducts();
		
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<h3>Web shop</h3>");
		pout.println("<h4>Rezultat kupovine:</h4>");
        double ukupno = 0; 
		for(Proizvod p : proizvodi) {
			String novaKolicina = "kolicina" + p.getId();
			if(request.getParameter(novaKolicina) != null && !request.getParameter(novaKolicina).equals("")) {
				long kolicina = Long.parseLong(request.getParameter(novaKolicina));
				pout.println("<h4> Cena je " + p.getCena() * kolicina + " naziv je " + p.getNaziv() + "</h4>");
				ukupno += p.getCena() * kolicina; 
			}
		}
		pout.println("<h3>Ukupna cena je : " + ukupno + " din </h3>"); 
		pout.println("</body>");
		pout.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
