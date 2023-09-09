package br.com.agenda.factory;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private static final String URL_DO_BANCO = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQl() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL_DO_BANCO, USUARIO, SENHA);
    }

    public static void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public static void closeJdbcPreparedStatement(JdbcPreparedStatement stm) {

        if(stm != null){
        try {
            stm.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            }
        }
    }
}
