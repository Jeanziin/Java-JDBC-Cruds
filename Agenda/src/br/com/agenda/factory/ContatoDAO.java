package br.com.agenda.factory;

import br.com.agenda.model.Contato;
import com.mysql.cj.jdbc.JdbcPreparedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public List<Contato> getContatos(){
        String sql = "SELECT * FROM contatos";
        List<Contato> contatos = new ArrayList<>();

        Connection conn = null;
        JdbcPreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQl();
            preparedStatement = (JdbcPreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                Contato contato = new Contato();
                 contato.setId(resultSet.getInt("id"));
                 contato.setNome(resultSet.getString("nome"));
                 contato.setIdade(resultSet.getInt("idade"));
                 contato.setDataCadastro(resultSet.getDate("datacadastro"));


                 contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeJdbcPreparedStatement(preparedStatement);
            ConnectionFactory.closeResultSet(resultSet);
            ConnectionFactory.closeConnection(conn);
        }
        return contatos;
    }

    public void update(Contato contato){
        String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? " +
                "WHERE id = ?";
        Connection conn = null;
        JdbcPreparedStatement preparedStatement = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQl();
            preparedStatement = (JdbcPreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setInt(2, contato.getIdade());
            preparedStatement.setDate(3, new Date(contato.getDataCadastro().getTime()));

            preparedStatement.setInt(4, contato.getId());
            preparedStatement.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            ConnectionFactory.closeJdbcPreparedStatement(preparedStatement);
            ConnectionFactory.closeConnection(conn);
        }
    }

    public void delete()
}
