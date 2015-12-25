package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Наталья on 08.09.2014.
 */
public class ErrorController extends AbstractWebtasksServletHandler{
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String notfound = request.getParameter("notfound");
        request.setAttribute("notfound", notfound);
        gotoToJSP("/error.jsp", request, response);
    }
}
