package controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
@WebServlet(name = "QashqaiSelectColorController", urlPatterns = {"/qashqaiSelectColor", "admin/qashqaiSelectColor", "user/qashqaiSelectColor" })
public class QashqaiSelectColorController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public QashqaiSelectColorController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_USER, "/user");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        gotoToJSP("qashqaiSelectColor.jsp", request, response);
    }
}