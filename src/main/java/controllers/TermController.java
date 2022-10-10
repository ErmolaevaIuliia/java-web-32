package controllers;

import db.DBServices;
import entity.Subject;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TermController", urlPatterns = "/terms")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 - все активные семестры, и передать на отображение
        // 2 - понять какой семестр выбран, и его передать на отображение
        // 3 - вытянуть все дисциплины по выбранному семестру

        DBServices services = new DBServices();
        List <Term> terms = services.getAllActiveTerms();
        req.setAttribute("terms", terms);

        String idSelectedTerm = req.getParameter("idSelectedTerm");
        if(idSelectedTerm == null){
            if(terms.size() !=0){
                Term selectedTerm = terms.get(0);
                req.setAttribute("selectedTerm", selectedTerm);
                List<Subject> subjects = services.getSubjectsByTerm(selectedTerm.getId() + "");
                req.setAttribute("subjects", subjects);
        }
        }else{
            Term selectedTerm = services.getTermById(idSelectedTerm);
            req.setAttribute("selectedTerm", selectedTerm);
            List<Subject> subjects = services.getSubjectsByTerm(selectedTerm.getId() + "");
            req.setAttribute("subjects", subjects);
        }
        req.getRequestDispatcher("WEB-INF/terms.jsp").forward(req, resp);

    }
}
