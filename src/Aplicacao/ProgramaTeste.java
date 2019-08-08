package Aplicacao;

import java.sql.Connection;

import db.DB;

public class ProgramaTeste {

	public static void main(String[] args) {
	
		Connection conn = DB.getConnection();
		DB.closeConnection();
		System.out.println("Teste de Conexão bem sucedido");
		System.out.println(conn);
	}

}
