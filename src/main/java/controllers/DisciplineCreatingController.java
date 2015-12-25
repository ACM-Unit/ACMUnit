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
public class DisciplineCreatingController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public DisciplineCreatingController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
        gotoToJSP("main/discipline/disciplineCreating.jsp", request, response);
        } else {
            String name = request.getParameter("name");
            Discipline discs = new Discipline();
            discs.setName(name);
            DisciplineDao discDao = new DisciplineDaoImpl();
            discDao.create(discs);
            List<Discipline> disc = discDao.getDisciplines();
            request.setAttribute("disc", disc);
            gotoToJSP("main/discipline/disciplines.jsp", request, response);
        }

    }
}