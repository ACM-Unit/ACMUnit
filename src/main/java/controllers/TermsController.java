package controllers;

import dao.impl.TermDaoImpl;
import dao1.TermDao;
import entity.Discipline;
import entity.Term;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 17.12.2015.
 */
public class TermsController extends AbstractWebtasksServletHandler {
        private final Map<Integer, String> mappings = new HashMap<Integer, String>();
        public TermsController() {
            mappings.put(ROLE_ADMIN, "/admin");
            mappings.put(ROLE_STUDENT, "/student");

        }
        @Override
        protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String s=request.getParameter("sel");
            System.out.println(s);
            TermDao termDao = new TermDaoImpl();
            List<Term> term = termDao.loadTerms();
            request.setAttribute("sel", s);
            System.out.println("размер массива -"+term.size());
            request.setAttribute("term", term);
            Map<Integer,List<Discipline>> disc=new LinkedHashMap<Integer, List<Discipline>>();
            for(Term terms: termDao.loadTerms()){
                disc.put(terms.getId(), termDao.getTerms(terms.getId()));
            }
            request.setAttribute("disc", disc);
            gotoToJSP("main/term/terms.jsp", request, response);
        }
    }
