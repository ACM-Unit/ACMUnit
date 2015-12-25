package controllers;

import dao.impl.StudentDaoImpl;
import dao1.StudentDao;
import entity.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
public class MarkUpdate extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public MarkUpdate() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
            String[] markId = request.getParameter("markId").split(",");
            String[] markVal = request.getParameter("markVal").split(",");
        for(int i=0; i<markId.length; i++) {
                studentDao.updateMark(Integer.parseInt(markId[i]), Integer.parseInt(markVal[i]));
        }
            List<Student> students = studentDao.getStudents();
            request.setAttribute("students", students);
            String sel="1";
            request.setAttribute("sel", sel);
            gotoToJSP("main/mark/mark.jsp", request, response);

    }
}
