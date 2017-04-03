package com.webshop.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webshop.obj.Kategorija;
import com.webshop.obj.Proizvod;
import com.webshop.utils.ConnectionManager;

public class ProizvodiDAO {
	
	public List<Proizvod> getAllProducts() {
		String query = "SELECT id, naziv, cena FROM proizvod";
		Statement st; 
		List<Proizvod> retVal = new ArrayList<Proizvod>(); 
		try {
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query); 
			while(rs.next()) {
				String naziv = rs.getString("naziv");
				Double cena = rs.getDouble("cena"); 
				long id = rs.getLong("id"); 
				Proizvod proizvod = new Proizvod(id, naziv, cena);
				retVal.add(proizvod); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retVal; 
	}
	
	public List<Kategorija> getKategorija() {
		List<Kategorija> retVal = new ArrayList<Kategorija>();
		String query = "SELECT * FROM kategorija";
		Statement st; 
		try {
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query); 
			while(rs.next()) {
				String naziv = rs.getString("naziv");
				long id = rs.getLong("id");
				retVal.add(new Kategorija(id, naziv)); 
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal; 
	}
	
	public List<Proizvod> getById(String vrednostParametraKID) {
		List<Proizvod> retVal = new ArrayList<Proizvod>(); 
		Statement st; 
		String query = "SELECT id, naziv, cena FROM proizvod " + vrednostParametraKID; 
		
		try {
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query); 
			while(rs.next()) {
				String naziv = rs.getString("naziv");
				Double cena = rs.getDouble("cena"); 
				long id = rs.getLong("id"); 
				Proizvod proizvod = new Proizvod(id, naziv, cena);
				retVal.add(proizvod); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retVal; 
	}
}
