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
public class DisciplineDeleteController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public DisciplineDeleteController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("ids");
        DisciplineDao discDao = new DisciplineDaoImpl();
        System.out.println(id);
        String[] s = id.split(",");
        for (int i=0; i<s.length; i++){
            discDao.deletee(Integer.parseInt(s[i]));
        }
        List<Discipline> disc = discDao.getDisciplines();
        request.setAttribute("disc", disc);
        gotoToJSP("main/discipline/disciplines.jsp", request, response);
    }
}