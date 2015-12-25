package services;

import java.util.List;

import entity.Student;

public interface StudentService {

	boolean studentModifing(int idStudent);

	boolean studentDelete(int idStudent);

	boolean studentAdd(int idStudent);

	List<Student> getStudents();

	Student getStudentById(int id);

}
