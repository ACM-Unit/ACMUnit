package database;

import constants.Constants;
import entity.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataService{
	private static final Logger LOGGER = Logger
			.getLogger(DataService.class);
	private static List<DBConnection> conPool = new ArrayList<DBConnection>();
	private static Object monitor = new Object();

	public boolean init() {
		try{
			LOGGER.info("init database");
			for (int i = 0; i < Constants.CONNECTING_POOL_SIZE; i++){
				newConnection();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public DBConnection getDBConnection() {
		synchronized (monitor) {
			if (conPool.isEmpty()){
				newConnection();
			}
			DBConnection conn = conPool.remove(0);
			return conn;
		}
	}
	
	public void putDBConnection(DBConnection conn) {
		synchronized (monitor){
			conPool.add(conn);
		}
	}

	private void newConnection() {
		DBConnection conn = new DBConnection(Constants.CONNECTING_URL);
		synchronized (monitor) {
			conPool.add(conn);
		}
	}
	
	public List<Role> getAllRoles(){
		DBConnection conn = getDBConnection();
		List <Role> result = conn.getAllRoles();
		this.putDBConnection(conn);
		return result;
		
	}
	public List<Student> getAllStudents(){
		DBConnection conn = getDBConnection();
		List <Student> result = conn.getAllStudents();
		this.putDBConnection(conn);
		return result;

	}
	
	public List<Account> getAllLogins() {
		DBConnection conn = getDBConnection();
		List<Account> result = conn.getAllLogins();
		this.putDBConnection(conn);		
		return result;
	}
	
	public Account getAccountByLogin(String login){
		DBConnection conn = getDBConnection();
		Account result = conn.getAccountByLogin(login);
		this.putDBConnection(conn);
		return result;
	}
	
	public List<Role> getRolesById(int id){
		DBConnection conn = getDBConnection();
		List<Role> result = conn.getRolesById(id);
		this.putDBConnection(conn);
		return result;
		
	}
	public Student getStudentsById(int id){
		DBConnection conn = getDBConnection();
		Student result = conn.getStudentById(id);
		this.putDBConnection(conn);
		return result;

	}
	
	public List<Integer> getIdAccountRoles(int idAccount){
		DBConnection conn = getDBConnection();
		List<Integer> idAccountRoles = conn.getIdAccountRoles(idAccount);
		this.putDBConnection(conn);
		return idAccountRoles;
	}
	
	public List<Discipline> getDisciplines(){
		DBConnection conn = getDBConnection();
		List<Discipline> disciplinesList = conn.getDisciplines();
		this.putDBConnection(conn);
		return disciplinesList;
	}
	
	public Discipline getDisciplineById(int id){
		DBConnection conn = getDBConnection();
		Discipline discipline = conn.getDisciplineById(id);
		this.putDBConnection(conn);
		return discipline;		
	}
	public boolean deleteStudentById(int id){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.deleteStudentById(id);
		this.putDBConnection(conn);
		return bool;
	}
	public boolean updateStudentById(Student student){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.updateStudentById(student);
		this.putDBConnection(conn);
		return bool;
	}
	public boolean updateMark(int id, int mark){
		DBConnection conn = getDBConnection();
		this.putDBConnection(conn);
		return conn.updateMark(id, mark);
	}
	public boolean createStudent(Student student){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.createStudent(student);
		this.putDBConnection(conn);
		return bool;
	}
	public boolean deleteDisciplineById(int id){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.deleteDisciplineById(id);
		this.putDBConnection(conn);
		return bool;
	}
	public boolean updateDisciplineById(Discipline disc){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.updateDiscipline(disc);
		this.putDBConnection(conn);
		return bool;
	}
	public boolean createDiscipline(Discipline disc){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.createDiscipline(disc);
		this.putDBConnection(conn);
		return bool;
	}
	public Term getTermById(int id){
		DBConnection conn = getDBConnection();
		return conn.getTermById(id);
	}
	public boolean addTerm(int dur, List<Integer> idDisc){
		DBConnection conn = getDBConnection();
		return conn.addTerm(dur, idDisc);
	}
	public boolean updateTerm(int id, int dur, List<Integer> disc){
		DBConnection conn = getDBConnection();
		Boolean bool = conn.updateTerm(id, dur, disc);
		return bool;
	}
	public boolean deleteTermById(int id){
		DBConnection conn = getDBConnection();
		return conn.deleteTermById(id);
	}
	public Double averageMarks(int studId, int termsId){
		DBConnection conn = getDBConnection();
		return conn.averageMarks(studId, termsId);
	}
	public Map<Discipline, Marks> loadMarksById(int studId, int termsId){
		DBConnection conn = getDBConnection();
		Map<Discipline,Marks> marks = conn.loadMarksById(studId,termsId);
		this.putDBConnection(conn);
		return marks;
	}
	
	public List<Discipline> getAllTerms(int id){
		DBConnection conn = getDBConnection();
		return conn.getAllTerms(id);
	}
	public List<Term> loadAllTerms(){
		DBConnection conn = getDBConnection();
		return conn.loadAllTerms();
	}
	public void close() {
	}	
}
