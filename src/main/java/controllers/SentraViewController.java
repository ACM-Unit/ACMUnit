package controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
@WebServlet(name = "SentraViewController", urlPatterns = {"/sentraView", "admin/sentraView", "user/sentraView" })
public class SentraViewController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public SentraViewController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_USER, "/user");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        gotoToJSP("sentraView.jsp", request, response);
    }
}