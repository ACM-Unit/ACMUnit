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
 * Created by Admin on 13.12.2015.
 */
public class DisciplineController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public DisciplineController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DisciplineDao discDao = new DisciplineDaoImpl();
        List<Discipline> disc = discDao.getDisciplines();
        request.setAttribute("disc", disc);
        gotoToJSP("main/discipline/disciplines.jsp", request, response);
    }
}
