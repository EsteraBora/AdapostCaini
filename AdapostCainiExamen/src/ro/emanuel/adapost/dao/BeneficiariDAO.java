package ro.emanuel.adapost.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.adapost.helpers.DBHelper;
import ro.emanuel.adapost.pojo.Beneficiari;

public class BeneficiariDAO {
	public static Beneficiari getBeneficiariByID(int id) throws SQLException{
		String select = "select * from beneficiari where id =?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Beneficiari result = null;
		
		if(rs.next()) {
			String nume = rs.getString("nume");
			int varsta = rs.getInt("varsta");
			String adresa = rs.getString("adresa");
			int caineId = rs.getInt("caine_id");
			result = new Beneficiari(id, nume, varsta, adresa, caineId);
		}
		
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Beneficiari> getBeneficiariByName(String nameQuery) throws SQLException{
		String select = "select * from beneficiari where nume like '%?%'";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, nameQuery);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Beneficiari> result = new ArrayList<Beneficiari>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			int varsta = rs.getInt("varsta");
			String adresa = rs.getString("adresa");
			int caineId = rs.getInt("caine_id");

			result.add(new Beneficiari(id, nume, varsta, adresa, caineId));
	        }

		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Beneficiari> getBeneficiari() throws SQLException {
		String select = "select * from beneficiari";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Beneficiari> result = new ArrayList<Beneficiari>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			int varsta = rs.getInt("varsta");
			String adresa = rs.getString("adresa");
			int caineId = rs.getInt("caine_id");


			Beneficiari b = new Beneficiari(id, nume, varsta, adresa, caineId);
		result.add(b);
		}
		DBHelper.closeConnection();
		return result;
	}

	public static void createBeneficiari(String nume, int varsta, String adresa, int caineId ) throws SQLException {
		String insert = "insert into beneficiari (nume, varsta, adresa, caine_id ) Value(?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setInt(2, varsta);
		stmt.setString(3, adresa);
		stmt.setInt(4, caineId); 
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void createBeneficiari(Beneficiari b) throws SQLException{
		BeneficiariDAO.createBeneficiari(b.getNume(), b.getVarsta(), b.getAdresa(), b.getCaineID());
	}
	
	public static void updateBeneficiari(Beneficiari b) throws SQLException{
		String update = "update beneficiari set nume=?, varsta=?, adresa=?, caine_id=? where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);

		stmt.setString(1, b.getNume());
		stmt.setInt(2, b.getVarsta());
		stmt.setString(3, b.getAdresa());
		stmt.setInt(4, b.getCaineID());
		stmt.setInt(5, b.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();	
	}
	
	public static void deleteBeneficiari(Beneficiari b) throws SQLException{
		BeneficiariDAO.deleteBeneficiari(b.getId());
	}
	
	public static void deleteBeneficiari(int id) throws SQLException{
		String delete = "delete from beneficiari where id=?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}

}
