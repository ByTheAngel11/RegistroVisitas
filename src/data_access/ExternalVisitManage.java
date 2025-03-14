// src/data_access/ExternalVisitManage.java
package data_access;

import logic.ExternalVisit;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class ExternalVisitManage {
    private ConnecctionDataBase connection;

    public ExternalVisitManage(ConnecctionDataBase connection){
        this.connection = connection;
    }

    public ExternalVisitManage(){
        this.connection = new ConnecctionDataBase();
    }

    public void addExternalVisit(ExternalVisit externalVisit){
        String sql = "INSERT INTO visitaexternos (numerovisita, asuntovisita, fechaentrada, fechasalida, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, 0);
            statement.setString(2, externalVisit.getVisitSubject());
            statement.setTimestamp(3, externalVisit.getEntryDate());
            statement.setTimestamp(4, externalVisit.getExitDate());
            statement.setString(5, externalVisit.getEmail());
            statement.executeUpdate();
            System.out.println("External visit added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding external visit to the database");
            e.printStackTrace();
        }
    }

    public void editVisitByVisitNumber(ExternalVisit visit) {
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

    public List<ExternalVisit> listAllVisits() {
        List<ExternalVisit> visits = new ArrayList<>();
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
                ExternalVisit visit = new ExternalVisit(visitNumber, visitSubject, entryDate, exitDate, email);
                visits.add(visit);
            }
            System.out.println("External visits selected successfully!");
        } catch (SQLException e) {
            System.out.println("Error selecting external visits from the database");
            e.printStackTrace();
        }
        return visits;
    }

    public ExternalVisit getVisitByVisitNumber(int visitNumber) {
        String sql = "SELECT * FROM visitaexternos WHERE numerovisita = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, visitNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String visitSubject = resultSet.getString("asuntovisita");
                    Timestamp entryDate = resultSet.getTimestamp("fechaentrada");
                    Timestamp exitDate = resultSet.getTimestamp("fechasalida");
                    String email = resultSet.getString("correo");
                    return new ExternalVisit(visitNumber, visitSubject, entryDate, exitDate, email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving external visit from the database");
            e.printStackTrace();
        }
        return null;
    }
}