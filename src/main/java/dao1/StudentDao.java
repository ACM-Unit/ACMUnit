package dao1;

import entity.Discipline;
import entity.Marks;
import entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

	List<Student> getStudents();
	
    Student getStudentById(int idSudent);
    
    boolean updateStudentById(Student student);

    boolean createStudent(Student student);
    
    boolean deleteStudentById(int idSudent);

    Map<Discipline, Marks> mark(int studId, int termsId);

    Double average(int studId, int termsId);
    public boolean updateMark(int id, int mark);
}
