
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
 * Created by Manager on 17.12.2015.
 */
public class StudentDeleteController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public StudentDeleteController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String id = request.getParameter("ids");
        StudentDao studentDao = new StudentDaoImpl();
        String[] s = id.split(",");
        for (int i=0; i<s.length; i++){
            studentDao.deleteStudentById(Integer.parseInt(s[i]));
        }
        List<Student> students = studentDao.getStudents();
        request.setAttribute("students", students);
        gotoToJSP("main/student/students.jsp", request, response);
    }
}