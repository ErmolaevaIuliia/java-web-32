package db;

import constants.Constants;
import entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBServices implements IDBServices{
    @Override
    public List<Subject> getAllActiveSubjects() {
        ArrayList<Subject> subjects = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from subject where status = '1'");

            while (rs.next()){
               Subject subject = new Subject();
               subject.setId(rs.getInt("id"));
               subject.setSubject(rs.getString("subject"));
               subjects.add(subject);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public void createSubject(String subject) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("insert into `subject` (`subject`) VALUES ('" + subject + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subject getSubjectById(String id) {
        return null;
    }

    @Override
    public void modifySubject(String id, String newSubject) {

    }

    @Override
    public void deleteSubject(String id) {

    }

    @Override
    public List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = '1'");

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("insert into `student` (`surname`,`name`,`group`,`date`) VALUES ('" + surname + "','" + name + "','" + group + "','" + date + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(String id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = '1' and id = " + id);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void modifyStudent(String id, String newSurname, String newName, String newGroup, String newDate) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '"+newSurname+"', `name` = '"+newName+"', `group` = '"+newGroup+"', `date` = '"+newDate+"', WHERE (`id` = '"+id+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Term> getAllActiveTerms() {
        return null;
    }

    @Override
    public List<Subject> getSubjectsByTerm(String idTerm) {
        return null;
    }

    @Override
    public void createTerm(String duration, String idsSubject) {

    }

    @Override
    public Term getTermById(String id) {
        return null;
    }

    @Override
    public void modifyTerm(String id, String newDuration, String newIdsSubject) {

    }

    @Override
    public void deleteTerm(String id) {

    }

    @Override
    public List<Mark> getMarks(String idStud, String idTerm) {
        return null;
    }

    @Override
    public List<Role> getAllActiveRoles() {
        return null;
    }

    @Override
    public boolean canLogin(String login, String password, String idRole) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_role as ur\n" +
                    "LEFT JOIN user as u on ur.id_user = u.id\n" +
                    "where u.login = '"+login+"' and u.password = '"+password+"' and ur.id_role = "+idRole);

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
