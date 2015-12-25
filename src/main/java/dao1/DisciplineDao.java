package dao1;

import entity.Discipline;

import java.util.List;

public interface DisciplineDao {

	List<Discipline> getDisciplines();

	Discipline getById(int id);

	boolean update(Discipline disc);

	boolean create(Discipline disc);

	boolean deletee(int id);

}
