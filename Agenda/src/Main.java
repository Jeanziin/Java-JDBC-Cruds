import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.factory.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws Exception {
        Contato contato = new Contato();
        contato.setNome("Corinthians da Silva silva");
        contato.setIdade(78);
        contato.setDataCadastro(new Date());

        //Atualizar Contato
        Contato contato1 = new Contato();
        contato1.setNome("Corinthians da Silva Silva");
        contato1.setIdade(37);
        contato1.setDataCadastro(new Date());
        contato1.setId(1);


        ContatoDAO contatoDAO = new ContatoDAO();
       // contatoDAO.insert(contato);
        //contatoDAO.update(contato1);

        for(Contato c : contatoDAO.getContatos()){
            System.out.println("Contato: " + c.getNome());
        }
    }
}