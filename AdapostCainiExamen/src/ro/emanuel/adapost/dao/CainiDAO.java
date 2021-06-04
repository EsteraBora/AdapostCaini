package ro.emanuel.adapost.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.adapost.helpers.DBHelper;
import ro.emanuel.adapost.pojo.Caini;


public class CainiDAO {
	
	public static Caini getCainiByID(int id) throws SQLException{
		String select = "select * from caini where id =?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Caini result = null;
		
		if(rs.next()) {
			String nume = rs.getString("nume");
			String rasa = rs.getString("rasa");
			int varsta = rs.getInt("varsta");
			result = new Caini(id, nume, rasa, varsta);
		}
		
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Caini> getCainiByName(String nameQuery) throws SQLException{
		String select = "select * from caini where nume like '%?%'";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Caini> result = new ArrayList<Caini>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String rasa = rs.getString("rasa");
			int varsta = rs.getInt("varsta");
			result.add(new Caini(id, nume, rasa, varsta));
	        }

		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Caini> getCaini() throws SQLException {
		String select = "select * from caini";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Caini> result = new ArrayList<Caini>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String rasa = rs.getString("rasa");
			int varsta = rs.getInt("varsta");
		Caini cn = new Caini(id, nume, rasa, varsta);
		result.add(cn);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createCaini(Caini cn) throws SQLException{
		CainiDAO.createCaini(cn.getNume(), cn.getRasa(), cn.getVarsta());
	}
	
	public static void createCaini(String nume, String rasa, int varsta) throws SQLException {
		String insert = "insert into caini (nume, rasa, varsta) Value(?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, rasa);
		stmt.setInt(3, varsta);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	
	public static void updateCaini(Caini cn) throws SQLException{
		String update = "update caini set nume=?, rasa=?, varsta=? where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);

		stmt.setString(1, cn.getNume());
		stmt.setString(2, cn.getRasa());
		stmt.setInt(3, cn.getVarsta());
		stmt.setInt(4, cn.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();	
	}
	
	public static void deleteCaini(Caini cn) throws SQLException{
		CainiDAO.deleteCaini(cn.getId());
	}
	
	public static void deleteCaini(int id) throws SQLException{
		String delete = "delete from caini where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}

}
