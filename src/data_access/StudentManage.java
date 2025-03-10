// src/data_access/StudentManage.java
package data_access;

import logic.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManage {

    private ConnecctionDataBase connection;

    public StudentManage() {
        this.connection = new ConnecctionDataBase();
    }

    public StudentManage(ConnecctionDataBase connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO Estudiante (correo, nombres, apellidos, matricula) VALUES (?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getEmail());
            statement.setString(2, student.getNames());
            statement.setString(3, student.getSurnames());
            statement.setString(4, student.getEnrollment());
            statement.executeUpdate();
            System.out.println("Estudiante agregado exitosamente!");
        } catch (SQLException e) {
            System.out.println("Error al agregar estudiante a la base de datos");
            e.printStackTrace();
        }
    }

    public void editStudentByEmail(Student student) {
        String sql = "UPDATE Estudiante SET nombres = ?, apellidos = ?, matricula = ? WHERE correo = ?";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getNames());
            statement.setString(2, student.getSurnames());
            statement.setString(3, student.getEnrollment());
            statement.setString(4, student.getEmail());
            statement.executeUpdate();
            System.out.println("Estudiante editado exitosamente!");
        } catch (SQLException e) {
            System.out.println("Error al editar estudiante en la base de datos");
            e.printStackTrace();
        }
    }

    public List<Student> listAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Estudiante";
        try (Connection connection = this.connection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String email = resultSet.getString("correo");
                String names = resultSet.getString("nombres");
                String surname = resultSet.getString("apellidos");
                String enrollment = resultSet.getString("matricula");
                Student student = new Student(email, names, surname, enrollment);
                students.add(student);
            }
            System.out.println("Students selected successfully!");
        } catch (SQLException e) {
            System.out.println("Error selecting students from the database");
            e.printStackTrace();
        }
        return students;
    }
}