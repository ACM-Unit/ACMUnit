package dao.impl;

import dao1.DisciplineDao;
import database.DataService;
import entity.Discipline;

import java.util.List;

public class DisciplineDaoImpl implements DisciplineDao {

	@Override
	public List<Discipline> getDisciplines() {
		DataService conn = new DataService();
		return conn.getDisciplines();
	}

	@Override
	public Discipline getById(int id) {
		DataService conn = new DataService();
		return conn.getDisciplineById(id);
	}

	@Override
	public boolean update(Discipline disc) {
		DataService conn = new DataService();
		boolean bool =conn.updateDisciplineById(disc);
		return bool;
	}
	@Override
	public boolean create(Discipline disc) {
		DataService conn = new DataService();
		boolean bool =conn.createDiscipline(disc);
		return bool;
	}

	@Override
	public boolean deletee(int id) {
		DataService conn = new DataService();
		boolean bool =conn.deleteDisciplineById(id);
		return bool;
	}

}
