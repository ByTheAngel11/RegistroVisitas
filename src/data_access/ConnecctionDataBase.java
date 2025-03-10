package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecctionDataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/registrovisitas";
    private static final String USER = "vigilante";
    private static final String PASSWORD = "pidocredenciales";


    public static Connection getConnection() {
        Connection connection = createConnection();
        printMessaggeConnection(connection);
        return connection;
    }

    private static Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            manageException(e);
            return null;
        }
    }

    private static void manageException(SQLException e){
        System.out.println("Error al conectar con la base de datos");
        e.printStackTrace();
    }

    private static void printMessaggeConnection(Connection connection) {
        if (connection != null) {
            System.out.println("Conectado con exito!");
        }
    }

    public static void main(String args[]) {
        ConnecctionDataBase obj = new ConnecctionDataBase();
        obj.getConnection();
    }
}


