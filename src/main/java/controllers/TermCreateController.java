package controllers;

import dao.impl.DisciplineDaoImpl;
import dao1.DisciplineDao;
import entity.Discipline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manager on 17.12.2015.
 */
public class TermCreateController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public TermCreateController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String val=request.getParameter("sel");
        System.out.println("привет это sel "+val);
             DisciplineDao discDao = new DisciplineDaoImpl();
             List<Discipline> disc = discDao.getDisciplines();
             request.setAttribute("disc", disc);
             gotoToJSP("main/term/termCreate.jsp", request, response);

    }
}