package data_access;

import logic.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class ExternalVisitManage {
    private ConnecctionDataBase connection;

    public ExternalVisitManage(ConnecctionDataBase connection){
        this.connection = connection;
    }

    public ExternalVisitManage(){
        this.connection = new ConnecctionDataBase();
    }

    public void addVisit(Visit visit){
        String sql = "INSERT INTO visitaexternos (numerovisita, asuntovisita, fechaentrada, fechasalida, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, 0);
            statement.setString(2, visit.getVisitSubject());
            statement.setTimestamp(3, visit.getEntryDate());
            statement.setTimestamp(4, visit.getExitDate());
            statement.setString(5, visit.getEmail());
            statement.executeUpdate();
            System.out.println("External visit added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding external visit to the database");
            e.printStackTrace();
        }
    }

    public void editVisitByVisitNumber(Visit visit) {
        String sql = "UPDATE visitaexternos SET asuntovisita = ?, fechaentrada = ?, fechasalida = ? WHERE numerovisita = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, visit.getVisitSubject());
            statement.setTimestamp(2, visit.getEntryDate());
            statement.setTimestamp(3, visit.getExitDate());
            statement.setInt(4, visit.getVisitNumber());
            statement.executeUpdate();
            System.out.println("External visit edited successfully!");
        } catch (SQLException e) {
            System.out.println("Error editing external visit in the database");
            e.printStackTrace();
        }
    }

    public List<Visit> listAllVisits() {
        List<Visit> visits = new ArrayList<>();
        String sql = "SELECT * FROM visitaexternos";
        try (Connection connection = this.connection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int visitNumber = resultSet.getInt("numerovisita");
                String visitSubject = resultSet.getString("asuntovisita");
                Timestamp entryDate = resultSet.getTimestamp("fechaentrada");
                Timestamp exitDate = resultSet.getTimestamp("fechasalida");
                String email = resultSet.getString("correo");
                Visit visit = new Visit(visitNumber, visitSubject, entryDate, exitDate, email);
                visits.add(visit);
            }
            System.out.println("External visits selected successfully!");
        } catch (SQLException e) {
            System.out.println("Error selecting external visits from the database");
            e.printStackTrace();
        }
        return visits;
    }
}