package services;

import java.util.List;

import entity.Discipline;

public interface DisciplineServise {

	boolean modifing(int id);

	boolean delete(int id);

	boolean add(int idS);

	List<Discipline> getDisciplines();

	Discipline getById(int id);

}
