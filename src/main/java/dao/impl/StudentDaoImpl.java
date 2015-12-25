package dao.impl;

import dao1.StudentDao;
import database.DataService;
import entity.Discipline;
import entity.Marks;
import entity.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 13.12.2015.
 */
public class StudentDaoImpl implements StudentDao {
    private DataService DataService = new DataService();
    @Override
    public List<Student> getStudents() {
        return DataService.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return DataService.getStudentsById(id);
    }
    @Override
    public Map<Discipline, Marks> mark(int studId, int termsId){
        return DataService.loadMarksById(studId, termsId);
    }
    @Override
    public boolean updateStudentById(Student student) {
        boolean bool =DataService.updateStudentById(student);
        return bool;
    }
    @Override
    public boolean createStudent(Student student) {
        boolean bool =DataService.createStudent(student);
        return bool;
    }

    @Override
    public boolean deleteStudentById(int idSudent) {
        return DataService.deleteStudentById(idSudent);
    }
    @Override
    public boolean updateMark(int id, int mark){
        return DataService.updateMark(id, mark);
    }
    @Override
    public Double average(int studId, int termsId) {
        return DataService.averageMarks(studId, termsId);
    }
}
