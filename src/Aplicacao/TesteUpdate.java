package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import java.sql.Statement;

import db.DB;

public class TesteUpdate {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			ps = conn.prepareStatement("UPDATE SELLER SET BaseSalary = ? WHERE Id = ?");
			System.out.println("Informe os dados da alteração : ");
			System.out.print("Código (Id) do Vendedor a ser atualizado : ");
			double auxDouble = sc.nextDouble();
			ps.setDouble(2, auxDouble);
			System.out.print("Novo Salário : ");
			auxDouble = sc.nextDouble();
			ps.setDouble(1, auxDouble);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Update completo com " + rowsAffected + " coluna(s) afetada(s).");
			
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			DB.closeConnection();
		}
		sc.close();
	}
}
