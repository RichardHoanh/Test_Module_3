package dao;

import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    static Connection connection = ConnectionMySql.getConnection();


    public static List<Student> getAll() {
        List<Student> students = new ArrayList<>();

        String sql = "Select * from student";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("dateofbirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                students.add(new Student(id, name, date, address, phone, email, classroom));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> getSearch(String search) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE  upper(student.name) like  '%" + search.toUpperCase() + "%'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("dateofbirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                students.add(new Student(id, name, date, address, phone, email, classroom));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static boolean create(Student student) {
        String sql = "insert into student(name,dateofbirth, address, phonenumber, email,classroom) value (?,?,?,?,?,?)";
        Connection connection = ConnectionMySql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDate());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassroom());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean edit(Student student) {
        String sql = "update student set name=?, dateofbirth=?, address=?,phonenumber=?,email=?,classroom=?  where id=?";
        Connection connection = ConnectionMySql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDate());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassroom());

            preparedStatement.setInt(7, student.getId());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }

    public static Student findStudentById(int id) {
        String sql = "select * from student where id = " + id;
        Connection connection = ConnectionMySql.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            int idStudent = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String date = resultSet.getString("dateofbirth");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phonenumber");
            String email = resultSet.getString("email");
            String classroom = resultSet.getString("classroom");
            return new Student(idStudent, name, date, address, phone, email, classroom);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(int id) {
        String sql = "delete FROM student where id = " + id;
        Connection connection = ConnectionMySql.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
