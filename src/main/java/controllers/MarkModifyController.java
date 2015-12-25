package controllers;

import dao.impl.StudentDaoImpl;
import dao.impl.TermDaoImpl;
import dao1.StudentDao;
import dao1.TermDao;
import entity.Discipline;
import entity.Marks;
import entity.Student;
import entity.Term;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Admin on 13.12.2015.
 */
public class MarkModifyController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public MarkModifyController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.parseInt(request.getParameter("butMark"));
        String s=request.getParameter("sel");
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.getStudentById(id);
        TermDao termDao = new TermDaoImpl();
        List<Term> term = termDao.loadTerms();
        request.setAttribute("sel", s);
        request.setAttribute("term", term);
        Map<Integer,List<Discipline>> disc=new LinkedHashMap<Integer, List<Discipline>>();
        Map<Integer,Map<Discipline, Marks>> mark=new LinkedHashMap<Integer, Map<Discipline, Marks>>();
        Map<Integer, Double> averageMark=new LinkedHashMap<Integer, Double>();
        for(Term terms: termDao.loadTerms()){
            disc.put(terms.getId(), termDao.getTerms(terms.getId()));
            mark.put(terms.getId(), studentDao.mark(id, terms.getId()));
            averageMark.put(terms.getId(), studentDao.average(id, terms.getId()));
        }
        request.setAttribute("butMark", id);
        request.setAttribute("disc", disc);
        request.setAttribute("sel", s);
        request.setAttribute("student", student);
        request.setAttribute("mark", mark);
        request.setAttribute("averageMark", averageMark);
        gotoToJSP("main/mark/markModify.jsp", request, response);
    }
}
