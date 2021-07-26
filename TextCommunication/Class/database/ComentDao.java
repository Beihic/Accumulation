package TextCommunication.database;

import java.sql.*;
import java.util.*;
import TextCommunication.property.Coment;

public class ComentDao{
	private final String JDBC_URL = "";
	private final String DB_USER = "";
	private final String DB_PASS = "";

	public boolean loginJudgement(int id, String pass){
		boolean login = false;
		try(Connection con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ID WHERE ID = ? AND PASS = ?");	
			pstmt.setInt(1, id);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){login = true;}
			rs.close();
			pstmt.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return login;
	}

	public String searchName(int id){
		String name = null;
		try(Connection con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ID WHERE ID = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				name = rs.getString("name");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return name;
	}

	public List<Coment> getComent(){
		List<Coment> comentList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM TEXT ORDER BY TIMESTAMP DESC LIMIT 100");
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("coment");
				Timestamp timestamp = rs.getTimestamp("timestamp");
				Coment coment = new Coment();
				coment.setComent(id, name, text, timestamp);
				comentList.add(coment);
			}	
			rs.close();
			pstmt.close();
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return comentList;
	}

	public void addComent(int id, String name, String coment, Timestamp timestamp){
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO TEXT (ID, NAME, COMENT, TIMESTAMP) VALUES (?, ?, ?, ?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, coment);
			pstmt.setTimestamp(4, timestamp);
			int r = pstmt.executeUpdate();
			pstmt.close();
			con.close();	
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public boolean registerUser(int id, String name, String pass){
		boolean flag = false;
		try(Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO ID (ID, NAME, PASS, LOGIN) VALUES(?, ?, ?, FALSE)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			int r = pstmt.executeUpdate();
			if(r==1)flag=true;
			pstmt.close();
			con.close();
		} catch(SQLEception e){
			e.printStackTrace();
		}
		return flag;
	}
}
