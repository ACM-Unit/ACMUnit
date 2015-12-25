package services;

import java.util.List;

import entity.Term;

public interface TermService {
	boolean modifing(int id);

	boolean delete(int id);

	boolean add(int idS);

	List<Term> getTerms();

	Term getById(int id);
}
