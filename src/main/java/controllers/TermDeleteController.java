package controllers;

import dao.impl.TermDaoImpl;
import dao1.TermDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manager on 17.12.2015.
 */
public class TermDeleteController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public TermDeleteController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sel=request.getParameter("sel");
        int id=Integer.parseInt(sel);
        TermDao termDao =new TermDaoImpl();
        termDao.delete(id);
        redirectRequest("terms.php?sel=1", request, response);
    }

}