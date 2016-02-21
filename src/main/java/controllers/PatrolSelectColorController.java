package controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
@WebServlet(name = "PatrolSelectColorController", urlPatterns = {"/patrolSelectColor", "admin/patrolSelectColor", "user/patrolSelectColor" })
public class PatrolSelectColorController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public PatrolSelectColorController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_USER, "/user");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        gotoToJSP("patrolSelectColor.jsp", request, response);
    }
}