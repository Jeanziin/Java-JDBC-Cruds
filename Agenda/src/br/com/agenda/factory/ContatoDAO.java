package br.com.agenda.factory;

import br.com.agenda.model.Contato;
import com.mysql.cj.jdbc.JdbcPreparedStatement;

import java.sql.Connection;
import java.sql.Date;


public class ContatoDAO {

    public void insert(Contato contato){
        String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?)";
        Connection conn = null;
        JdbcPreparedStatement stm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQl();

            stm = (JdbcPreparedStatement) conn.prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setInt(2, contato.getIdade());
            stm.setDate(3, new Date(contato.getDataCadastro().getTime()));

        stm.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            ConnectionFactory.closeJdbcPreparedStatement(stm);
            ConnectionFactory.closeConnection(conn);
        }
    }

}
