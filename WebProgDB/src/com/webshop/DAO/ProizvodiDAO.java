package com.webshop.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public boolean dodajProizvod (String naziv, double cena, long idKategorije) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "INSERT INTO Proizvod (naziv, cena, kategorija_id) values(?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setString(1, naziv);
			preparedStatement.setDouble(2, cena);
			preparedStatement.setLong(3, idKategorije);
			
			if (preparedStatement.executeUpdate() == 1)
				retVal = true;
			preparedStatement.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal; 
	}

	public boolean obrisiProizvod(long proizvodID) {

		boolean retVal = false; 
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "DELETE FROM proizvod WHERE id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setLong(1, proizvodID);
			
			if (preparedStatement.executeUpdate() == 1)
				retVal = true;
			preparedStatement.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal; 
		
		
	}
}
