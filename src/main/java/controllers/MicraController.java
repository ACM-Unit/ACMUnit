package controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.HashMap;
        import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
@WebServlet(name = "MicraController", urlPatterns = {"/micra", "admin/micra", "user/micra" , "/micra.jsp", "admin/micra.jsp", "user/micra.jsp" })
public class MicraController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public MicraController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_USER, "/user");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        gotoToJSP("micra.jsp", request, response);
    }
}