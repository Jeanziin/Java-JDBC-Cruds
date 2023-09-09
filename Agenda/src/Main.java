import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.factory.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws Exception {
        Contato contato = new Contato();
        contato.setNome("Corinthians da Silva");
        contato.setIdade(78);
        contato.setDataCadastro(new Date());

        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.insert(contato);

        for(Contato c : contatoDAO.getContatos()){
            System.out.println("Contato: " + c.getNome());
        }
    }
}