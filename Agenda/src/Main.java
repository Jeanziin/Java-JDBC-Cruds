import br.com.agenda.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionFactory.createConnectionToMySQl();
        ConnectionFactory.closeConnection(conn);
    }
}