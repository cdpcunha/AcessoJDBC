package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import java.sql.Statement;

import db.DB;
import db.DbIntegrityException;

public class TesteDelete {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			ps = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			System.out.println("Informe os dados a serem deletados : ");
			System.out.print("Código (Id) do Vendedor a ser removido : ");
			int auxInt = sc.nextInt();
			ps.setDouble(1, auxInt);
						
			int rowsAffected = ps.executeUpdate();
			System.out.println("Delete completo com " + rowsAffected + " linha(s) afetada(s).");
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeConnection();
			sc.close();
		}
	}
}
