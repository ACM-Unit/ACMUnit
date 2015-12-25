package dao.impl;

import dao1.TermDao;
import database.DataService;
import entity.Discipline;
import entity.Term;

import java.util.List;

/**
 * Created by Admin on 16.12.2015.
 */
public class TermDaoImpl implements TermDao{

    @Override
    public boolean update(int id, int dur, List<Integer> disc) {
        DataService conn = new DataService();
        return conn.updateTerm(id, dur, disc);
    }

    @Override
    public boolean delete(int id) {
        DataService conn = new DataService();
        return conn.deleteTermById(id);
    }

    @Override
    public boolean add(int idS, List<Integer> idDisc) {
        DataService conn = new DataService();
        return conn.addTerm(idS, idDisc);
    }

    @Override
    public List<Discipline> getTerms(int id) {
        DataService conn = new DataService();
        return conn.getAllTerms(id);
    }
    @Override
    public List<Term> loadTerms() {
        DataService conn = new DataService();
        return conn.loadAllTerms();

    }
    @Override
    public Term getById(int id) {
        DataService conn = new DataService();
        return conn.getTermById(id);
    }
}
