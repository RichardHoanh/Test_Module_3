package models;



import dao.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static List<Student> students=new ArrayList<>();

    public static List<Student> getSearch(String search){
        return StudentDAO.getSearch(search);
    }
    public static List<Student> getAll() {
        return StudentDAO.getAll();
    }
    public static Student findStudentById(int id) {
        return StudentDAO.findStudentById(id);
    }
    public static boolean create(Student student) {
        return StudentDAO.create(student);
    }


    public static void edit(Student student) {
        StudentDAO.edit(student);
    }

    public static void delete(int id){
        StudentDAO.delete(id);

    }
}
