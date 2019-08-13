package Aplicacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Statement;

import db.DB;

public class TesteSelect {

	public static void main(String[] args)  {
	
		Connection conn = null;
		//Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			rs = conn.createStatement().executeQuery("SELECT * FROM DEPARTMENT");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id")+" - "+rs.getString("Name"));
			}
		}
		catch(SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		finally {
			DB.closeResultSet(rs);
			//DB.closeStatement(st);
			DB.closeConnection();
		}
	
		}
	}

