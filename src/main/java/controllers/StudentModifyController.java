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
public class StudentModifyController extends AbstractWebtasksServletHandler {
    private final Map<Integer, String> mappings = new HashMap<Integer, String>();
    public StudentModifyController() {
        mappings.put(ROLE_ADMIN, "/admin");
        mappings.put(ROLE_STUDENT, "/student");

    }
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            Integer id = Integer.parseInt(request.getParameter("butMark"));
            StudentDao studentDao = new StudentDaoImpl();
            Student student = studentDao.getStudentById(id);
            request.setAttribute("student", student);
            gotoToJSP("main/student/studentModify.jsp", request, response);
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String surname = request.getParameter("surname");
            String name = request.getParameter("name");
            String group = request.getParameter("group");
            String date = request.getParameter("date");
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setGroup(group);
            student.setId(id);
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            Date docDate= format.parse(date);
            student.setDate(docDate);
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.updateStudentById(student);
            List<Student> students = studentDao.getStudents();
            request.setAttribute("students", students);
            gotoToJSP("main/student/students.jsp", request, response);
        }
    }
}