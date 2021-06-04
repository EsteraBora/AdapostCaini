package ro.emanuel.adapost.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.adapost.helpers.DBHelper;
import ro.emanuel.adapost.pojo.Voluntari;

public class VoluntariDAO {
	public static Voluntari getVoluntariByID(int id) throws SQLException{
		String select = "select * from voluntari where id =?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Voluntari result = null;
		
		if(rs.next()) {
			String nume = rs.getString("nume");
			String functie = rs.getString("functie");
			int vechime = rs.getInt("vechime");
			result = new Voluntari(id, nume, functie, vechime);
		}
		
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Voluntari> getVoluntariByName(String nameQuery) throws SQLException{
		String select = "select * from voluntari where nume like '%?%'";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Voluntari> result = new ArrayList<Voluntari>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String functie = rs.getString("functie");
			int vechime = rs.getInt("vechime");

			result.add(new Voluntari(id, nume, functie, vechime));
	        }

		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Voluntari> getVoluntari() throws SQLException {
		String select = "select * from voluntari";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Voluntari> result = new ArrayList<Voluntari>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String functie = rs.getString("functie");
			int vechime = rs.getInt("vechime");


			Voluntari v = new Voluntari(id, nume, functie, vechime);
		result.add(v);
		}
		DBHelper.closeConnection();
		return result;
	}

	public static void createVoluntari(String nume, String functie, int vechime ) throws SQLException {
		String insert = "insert into voluntari (nume, functie, vechime ) Value(?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, functie);
		stmt.setInt(3, vechime);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void createVoluntari(Voluntari v) throws SQLException{
		VoluntariDAO.createVoluntari(v.getNume(), v.getFunctie(), v.getVechime());
	}
	
	public static void updateVoluntari(Voluntari v) throws SQLException{
		String update = "update voluntari set nume=?, functie=?, vechime=? where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);

		stmt.setString(1, v.getNume());
		stmt.setString(2, v.getFunctie());
		stmt.setInt(3, v.getVechime());
		stmt.setInt(4, v.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();	
	}
	
	public static void deleteVoluntari(Voluntari v) throws SQLException{
		VoluntariDAO.deleteVoluntari(v.getId());
	}
	
	public static void deleteVoluntari(int id) throws SQLException{
		String delete = "delete from voluntari where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}
