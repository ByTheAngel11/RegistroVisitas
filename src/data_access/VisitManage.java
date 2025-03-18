package data_access;

import logic.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VisitManage {
    private ConnecctionDataBase connection;

    public VisitManage(ConnecctionDataBase connection){
        this.connection = connection;
    }

    public VisitManage(){
        this.connection = new ConnecctionDataBase();
    }

    public void addVisit(Visit visit){
        String sql = "INSERT INTO Visita (numerovisita, asuntovisita, fechaentrada, fechasalida, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, 0);
            statement.setString(2, visit.getVisitSubject());
            statement.setTimestamp(3, visit.getEntryDate());
            statement.setTimestamp(4, visit.getExitDate());
            statement.setString(5, visit.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editVisitByNumeroVisita(Visit visit) {
        String sql = "UPDATE Visita SET asuntovisita = ?, fechaentrada = ?, fechasalida = ? WHERE numerovisita = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, visit.getVisitSubject());
            statement.setTimestamp(2, visit.getEntryDate());
            statement.setTimestamp(3, visit.getExitDate());
            statement.setInt(4, visit.getVisitNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVisitWithDefaultExitDate(Visit visit){
        String sql = "INSERT INTO Visita (numerovisita, asuntovisita, fechaentrada, fechasalida, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, 0);
            statement.setString(2, visit.getVisitSubject());
            statement.setTimestamp(3, visit.getEntryDate());
            statement.setTimestamp(4, null); // Default exit date set to null
            statement.setString(5, visit.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Visit getVisitByNumeroVisita(int visitNumber) {
        String sql = "SELECT * FROM Visita WHERE numerovisita = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, visitNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String visitSubject = resultSet.getString("asuntovisita");
                Timestamp entryDate = resultSet.getTimestamp("fechaentrada");
                Timestamp exitDate = resultSet.getTimestamp("fechasalida");
                String email = resultSet.getString("correo");
                return new Visit(visitNumber, visitSubject, entryDate, exitDate, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Visit> listAllVisits() {
        List<Visit> visits = new ArrayList<>();
        String sql = "SELECT * FROM Visita";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visits;
    }
}