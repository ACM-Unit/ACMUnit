package controllers;

import dao.impl.StudentDaoImpl;
import dao1.StudentDao;
import entity.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manager on 17.12.2015.
 */
public class StudentCreateController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public StudentCreateController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            gotoToJSP("main/student/studentCreate.jsp", request, response);
        } else {
            String surname = request.getParameter("surname");
            String name = request.getParameter("name");
            String group = request.getParameter("group");
            String date = request.getParameter("date");
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setGroup(group);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            Date docDate= format.parse(date);
            student.setDate(docDate);
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.createStudent(student);
            List<Student> students = studentDao.getStudents();
            request.setAttribute("students", students);
            gotoToJSP("main/student/students.jsp", request, response);
        }

    }

}