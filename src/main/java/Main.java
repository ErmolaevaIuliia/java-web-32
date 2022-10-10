import db.DBServices;
import entity.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBServices services = new DBServices();
        services.createSubject("Java программирование");

//        List<Subject> subjects = services.getAllActiveSubjects();
//        System.out.println();


//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_32", "root", "Ermolaeva.1");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM subject where status = '1'");
//
//            while (rs.next()){
//                System.out.println(rs.getString("subject"));
//            }
//
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

}

