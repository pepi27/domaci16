package com.webshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webshop.obj.User;
import com.webshop.utils.ConnectionManager;

public class UserDAO {

	public List<User> getAllUsers() {
		String query = "SELECT id, username, password FROM user";
		Statement st; 
		List<User> retVal = new ArrayList<>(); 
		try {
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1); 
				String username = rs.getString(2);
				String password = rs.getString(3); 
				User user = new User(id, username, password); 
				retVal.add(user); 
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return retVal; 
	}
	
	public User getUserByUserAndPass(String user, String pass) {
		String query = "SELECT id FROM user WHERE username = ? AND password = ?";
		User retVal = null; 
		try {
			PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rset = pst.executeQuery();
			if(rset.next()) {
				int id = rset.getInt(1); 
				retVal = new User(id, user, pass); 
			}
			rset.close();
			pst.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return retVal; 
	}
	
	public boolean deleteUser(int id) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "DELETE FROM User WHERE id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() == 1)
				retVal = true;
			preparedStatement.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
	
	public boolean insertUser(String user, String pass) {
		boolean retVal = false; 
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "INSERT INTO User (username, password) values (?, ?)"; 
			PreparedStatement pst = conn.prepareStatement(update); 
			pst.setString(1, user);
			pst.setString(2, pass);
			if(pst.executeUpdate() == 1) {
				retVal = true; 
			}
			pst.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal; 
	}
}