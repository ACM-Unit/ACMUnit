package dao1;

import entity.Discipline;
import entity.Term;

import java.util.List;

public interface TermDao {
	boolean update(int id, int dur, List<Integer> disc);

	boolean delete(int id);

	boolean add(int idS, List<Integer> idDisc);

	List<Discipline> getTerms(int id);

	Term getById(int id);
	List<Term> loadTerms();
}
