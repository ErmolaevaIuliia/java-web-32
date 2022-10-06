package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBServices services = new DBServices();
        String id = req.getParameter("hiddenModify");
        Student student = services.getStudentById(id);

        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req,resp);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    String surname = req.getParameter("surname");
    String name = req.getParameter("name");
    String group = req.getParameter("group");
    String dateFromUser = req.getParameter("id");

    DBServices services = new DBServices();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(dateFromUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Date to String
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDataBase = formatter.format(date);

        services.modifyStudent(id, surname, name, group, dateToDataBase);
        resp.sendRedirect("/students");
    }
    }

