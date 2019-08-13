package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DB;

public class TesteInsert {

	public static void main(String[] args)  {
	Connection conn = null;
	PreparedStatement ps = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	
	try {
		conn = DB.getConnection();
		ps = conn.prepareStatement("INSERT INTO SELLER (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?,?,?,?,?)");
		
		System.out.println("Entre com os dados do Vendedor");
		System.out.print("Nome :");
		String strAux = sc.nextLine();
		ps.setString(1, strAux);
		System.out.print("Email :");
		strAux = sc.nextLine();
		ps.setString(2, strAux);
		System.out.println("Data de Nascimento : ");
		java.sql.Date sqlDate =  new java.sql.Date(sdf.parse(sc.nextLine()).getTime());
		ps.setDate(3, sqlDate);//Datas em SQL devem ser neste formato
		System.out.print("Salário :");
		Double dblAux = sc.nextDouble();
		ps.setDouble(4, dblAux);
		System.out.print("Departamento : ");
		Integer intAux = sc.nextInt();
		ps.setDouble(5, intAux);
		sc.nextLine();
		
		int rowsAffected = ps.executeUpdate();
		
		System.out.println("Insert completo com " + rowsAffected + " coluna(s) afetada(s).");
	}
	catch(SQLException e) {
		System.out.println(e.getLocalizedMessage());
	}
	catch(ParseException e) {
		System.out.println(e.getLocalizedMessage());
	}
	finally {
		DB.closeStatement(ps);
		DB.closeConnection();
		sc.close();
	}
	
	}
}
