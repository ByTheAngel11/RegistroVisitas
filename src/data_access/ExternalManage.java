package data_access;

import logic.External;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExternalManage {

    private ConnecctionDataBase connection;

    public ExternalManage() {
        this.connection = new ConnecctionDataBase();
    }

    public ExternalManage(ConnecctionDataBase connection) {
        this.connection = connection;
    }

    public void addExternal(External external) {
        String sql = "INSERT INTO Externo (correo, nombres, apellidos, identificacionoficial) VALUES (?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, external.getEmail());
            statement.setString(2, external.getNames());
            statement.setString(3, external.getSurnames());
            statement.setString(4, external.getOfficialIdentification());
            statement.executeUpdate();
            System.out.println("Externo agregado exitosamente!");
        } catch (SQLException e) {
            System.out.println("Error al agregar externo a la base de datos");
            e.printStackTrace();
        }
    }

    public void editExternalByCorreo(External external) {
        String sql = "UPDATE Externo SET nombres = ?, apellidos = ?, identificacionoficial = ? WHERE correo = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, external.getNames());
            statement.setString(2, external.getSurnames());
            statement.setString(3, external.getOfficialIdentification());
            statement.setString(4, external.getEmail());
            statement.executeUpdate();
            System.out.println("Externo editado exitosamente!");
        } catch (SQLException e) {
            System.out.println("Error al editar externo en la base de datos");
            e.printStackTrace();
        }
    }

    public List<External> listAllExternals() {
        List<External> externals = new ArrayList<>();
        String sql = "SELECT * FROM Externo";
        try (Connection connection = this.connection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String email = resultSet.getString("correo");
                String names = resultSet.getString("nombres");
                String surname = resultSet.getString("apellidos");
                String officialIdentification = resultSet.getString("identificacionoficial");
                External external = new External(email, names, surname, officialIdentification);
                externals.add(external);
            }
            System.out.println("Externos seleccionados exitosamente!");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar externos de la base de datos");
            e.printStackTrace();
        }
        return externals;
    }
}