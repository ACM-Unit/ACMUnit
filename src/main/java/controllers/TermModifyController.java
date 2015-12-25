package controllers;

import dao.impl.DisciplineDaoImpl;
import dao.impl.TermDaoImpl;
import dao1.DisciplineDao;
import dao1.TermDao;
import entity.Discipline;
import entity.Term;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Manager on 17.12.2015.
 */
public class TermModifyController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public TermModifyController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
        String sel=request.getParameter("sel");
        int id=Integer.parseInt(sel);
        TermDao termDao =new TermDaoImpl();
        List<Discipline> term=termDao.getTerms(id);
        DisciplineDao discDao = new DisciplineDaoImpl();
        List<Discipline> disc = discDao.getDisciplines();
        List<Discipline> disc1 = new LinkedList<Discipline>();
            Term termDur = termDao.getById(id);
        for(Discipline i : disc) {
            if (!term.contains(i)) {
                disc1.add(i);
            }
        }
            request.setAttribute("dur", termDur.getDuration());
            request.setAttribute("sel", id);
            request.setAttribute("term", term);
            request.setAttribute("disc", disc1);
        gotoToJSP("main/term/termModify.jsp", request, response);
        } else {
            String sel=request.getParameter("sel");
            int id=Integer.parseInt(sel);
            String mass=request.getParameter("mass");
            String b=request.getParameter("nameDisc");
            Integer nameDisc=Integer.parseInt(b);
            List<Integer> discTerms=new LinkedList<Integer>();
            String[] a=mass.split(",");
            TermDao termDao = new TermDaoImpl();
            for(String i:a){
                discTerms.add(Integer.parseInt(i));
                System.out.println(Integer.parseInt(i));
            }
            termDao.update(id, nameDisc, discTerms);
            Map<Integer,List<Discipline>> disc=new LinkedHashMap<Integer, List<Discipline>>();
            for(Term term: termDao.loadTerms()){
                disc.put(term.getId(), termDao.getTerms(term.getId()));
            }
            request.setAttribute("disc", disc);
            List<Term> terms = termDao.loadTerms();
            request.setAttribute("term", terms);
            redirectRequest("terms.php?sel=1", request, response);
        }
    }
}