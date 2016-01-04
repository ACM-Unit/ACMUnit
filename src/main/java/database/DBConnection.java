package database;

import constants.Constants;
import entity.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class DBConnection {
	private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
	private Connection conn = null;
	private ResultSet rs = null;
	
	private static PreparedStatement loadAllRoles;
	private static PreparedStatement loadAllTerms;
	private static PreparedStatement getAllDisciplineTerms;
	private static PreparedStatement lastInsertID;
	private static PreparedStatement getAllTerms;
	private static PreparedStatement deleteAllDisciplineTerms;
	private static PreparedStatement putAllDisciplineTerms;
	private static PreparedStatement loadAllLogins;
	private static PreparedStatement loadAccountByLogin;
	private static PreparedStatement loadRolesById;
	private static PreparedStatement getIdAccountRoles;
	private static PreparedStatement getDisciplines;
	private static PreparedStatement getDisciplineById;
	private static PreparedStatement loadAllStudents;
	private static PreparedStatement loadStudentById;
	private static PreparedStatement createStudent;
	private static PreparedStatement updateStudentById;
	private static PreparedStatement deleteStudentById;
	private static PreparedStatement loadMarksById;
	private static PreparedStatement createDiscipline;
	private static PreparedStatement updateDisciplineById;
	private static PreparedStatement deleteDisciplineById;
	private static PreparedStatement averageMarks;
	private static PreparedStatement getTermById;
	private static PreparedStatement addTerm;
	private static PreparedStatement updateTermById;
	private static PreparedStatement deleteTermById;
	private static PreparedStatement putDisceplineMark;
	private static PreparedStatement updateMark;
	public DBConnection(String url) {
		try {
			String dbUrl = Constants.CONNECTING_URL;
			if (System.getenv("jbossews-acmunit.rhcloud.com") != null) {
				dbUrl = String.format("jdbc:mysql://%s/%s?user=%s&password=%s",
						System.getenv("127.13.153.130:3306"),
						System.getenv("jbossews"),
						System.getenv("adminyGBDPY3"),
						System.getenv("n5t4mmdF8VHU"));
			}

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl);
			loadPreparedStatements();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//public DBConnection(String url) {
		//try {
		//	Class.forName("com.mysql.jdbc.Driver");
		//	conn = DriverManager.getConnection(Constants.CONNECTING_URL);
		//	loadPreparedStatements();
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}

	//}

	private void loadPreparedStatements() {
		try {
			loadAllRoles = conn.prepareStatement("SELECT * FROM roles");
			loadAllTerms = conn.prepareStatement("SELECT * FROM disciplines LEFT join terms_disceplines on disciplines.id=terms_disceplines.id_disceplines WHERE terms_disceplines.id_terms=?");
			lastInsertID=conn.prepareStatement("SELECT LAST_INSERT_ID()");
			getAllTerms = conn.prepareStatement("SELECT id, duration  FROM `terms`");
			getAllDisciplineTerms = conn.prepareStatement("SELECT ID FROM terms_disceplines");
			deleteAllDisciplineTerms= conn.prepareStatement("DELETE FROM `terms_disceplines` WHERE `id_terms`=?");
			putAllDisciplineTerms= conn.prepareStatement("INSERT INTO `terms_disceplines` (`id_terms`, `id_disceplines`) VALUES (?, ?)");
			putDisceplineMark=conn.prepareStatement("INSERT INTO `marks` (`id_student`, `id_terms_disceplines`) VALUES (?, ?)");
			updateMark=conn.prepareStatement("UPDATE `marks` SET `mark`=? WHERE `id`=?");
			loadAllLogins = conn.prepareStatement("SELECT login, id FROM accounts ");
			loadAccountByLogin = conn.prepareStatement("SELECT * FROM accounts WHERE login = ?");
			loadRolesById = conn.prepareStatement("SELECT * FROM roles WHERE id =?");
			getIdAccountRoles = conn.prepareStatement("SELECT id_role FROM accaunts_roles WHERE id_accaunt = ?");
			getDisciplines = conn.prepareStatement("SELECT * FROM disciplines");
			getDisciplineById = conn.prepareStatement("SELECT * FROM disciplines WHERE id = ?");
			getTermById = conn.prepareStatement("SELECT * FROM terms WHERE id = ?");
			addTerm = conn.prepareStatement("INSERT INTO terms (duration) VALUES (?)");
			updateTermById = conn.prepareStatement("UPDATE terms SET duration=? WHERE id=?");
			deleteTermById = conn.prepareStatement("DELETE FROM terms WHERE id=?");
			loadAllStudents = conn.prepareStatement("SELECT * FROM students");
			loadStudentById = conn.prepareStatement("SELECT * FROM students WHERE id =?");
			updateStudentById = conn.prepareStatement("UPDATE `students` SET `name`=?, `surname`=?, `date`=?, `group`=? WHERE `id`=?");
			createStudent = conn.prepareStatement("INSERT INTO `students` (`name`, `surname`, `date`, `group`) VALUES (?, ?, ?, ?)");
			createDiscipline = conn.prepareStatement("INSERT INTO `disciplines` (`disciplines`) VALUES (?)");
			updateDisciplineById = conn.prepareStatement("UPDATE disciplines SET disciplines=? WHERE id=?");
			deleteDisciplineById = conn.prepareStatement("DELETE FROM disciplines WHERE id=?");
			deleteStudentById = conn.prepareStatement("DELETE FROM students WHERE id=?");
			loadMarksById=conn.prepareStatement("SELECT * FROM marks LEFT join terms_disceplines on marks.id_terms_disceplines=terms_disceplines.id join disciplines on terms_disceplines.id_disceplines=disciplines.id join terms on terms_disceplines.id_terms=terms.id where id_student=? and terms.id=?");
			averageMarks=conn.prepareStatement("SELECT avg(mark) FROM marks LEFT join terms_disceplines on marks.id_terms_disceplines=terms_disceplines.id join disciplines on terms_disceplines.id_disceplines=disciplines.id join terms on terms_disceplines.id_terms=terms.id where id_student=? and terms.id=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closePreparedStatements() {
		try {
			loadAllRoles.close();
			loadAllTerms.close();
			getAllTerms.close();
			loadAllLogins.close();
			loadAccountByLogin.close();
			loadRolesById.close();
			getIdAccountRoles.close();
			getDisciplines.close();
			getDisciplineById.close();
			loadAllStudents.close();
			loadStudentById.close();
			createStudent.close();
			updateStudentById.close();
			deleteStudentById.close();
			loadMarksById.close();
			createDiscipline.close();
			updateDisciplineById.close();
			deleteDisciplineById.close();
			averageMarks.close();
			getTermById.close();
			addTerm.close();
			updateTermById.close();
			deleteTermById.close();
			putAllDisciplineTerms.close();
			putDisceplineMark.close();
			updateMark.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Role> getAllRoles(){
		rs = null;
		List<Role> result = new LinkedList<Role>();
		try {
			rs = loadAllRoles.executeQuery();
			while (rs.next()){
				Role r = new Role();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("role"));
				result.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	public Term getTermById(int id){
		rs = null;
		Term r = new Term();
		try {
			getTermById.setInt(1, id);
			rs = getTermById.executeQuery();
			while (rs.next()){
				r.setId(rs.getInt("id"));
				r.setDuration(rs.getInt("duration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	public boolean addTerm(int dur, List<Integer> disc){
		rs = null;
		int id=0;
		try {
			addTerm.setInt(1,dur);
			addTerm.executeUpdate();
			rs = lastInsertID.executeQuery();
			while (rs.next()){
				id=rs.getInt("LAST_INSERT_ID()");
			}
			rs=null;
			for(int i=0; i<disc.size(); i++) {
				putAllDisciplineTerms.setInt(1, id);
				putAllDisciplineTerms.setInt(2, disc.get(i));
				putAllDisciplineTerms.executeUpdate();
				rs = lastInsertID.executeQuery();
				int lastId=0;
				while (rs.next()){
					lastId=rs.getInt("LAST_INSERT_ID()");
				}
				List<Student> stud=getAllStudents();
				for(int j=0; j<stud.size(); j++ ) {
					putDisceplineMark.setInt(1, stud.get(j).getId());
					putDisceplineMark.setInt(2, lastId);
					putDisceplineMark.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateTerm(int id, int dur, List<Integer> disc){
		try {
			updateTermById.setInt(1,dur);
			updateTermById.setInt(2,id);
			updateTermById.executeUpdate();
			deleteAllDisciplineTerms.setInt(1, id);
			deleteAllDisciplineTerms.execute();
			for(int i=0; i<disc.size(); i++) {
				putAllDisciplineTerms.setInt(1, id);
				putAllDisciplineTerms.setInt(2, disc.get(i));
				putAllDisciplineTerms.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateMark(int id, int mark){
		try {
			updateMark.setInt(1,mark);
			updateMark.setInt(2,id);
			updateMark.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteTermById(int id){
		try {
			deleteAllDisciplineTerms.setInt(1, id);
			deleteAllDisciplineTerms.execute();
			deleteTermById.setInt(1,id);
			deleteTermById.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<Discipline> getAllTerms(Integer id){
		rs = null;
		List<Discipline> result = new LinkedList<Discipline>();
		try {
			loadAllTerms.setInt(1,id);
			rs = loadAllTerms.executeQuery();
			while (rs.next()){
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id"));
				discipline.setName(rs.getString("disciplines"));
				result.add(discipline);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Student> getAllStudents(){
		rs = null;
		List<Student> result = new LinkedList<Student>();
		try {
			rs = loadAllStudents.executeQuery();
			while (rs.next()){
				Student r = new Student();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setSurname(rs.getString("surname"));
				r.setDate(rs.getDate("date"));
				r.setGroup(rs.getString("group"));
				result.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
	public List<Term> loadAllTerms(){
		rs = null;
		List<Term> result = new LinkedList<Term>();
		try {
			rs = getAllTerms.executeQuery();
			while (rs.next()){
				Term term = new Term();
				term.setId(rs.getInt("id"));
				term.setDuration(rs.getInt("duration"));
				result.add(term);
				System.out.println("id-"+term.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Account> getAllLogins(){
		rs = null;
		List<Account> result = new LinkedList<Account>();
		try {
			rs = loadAllLogins.executeQuery();
			
			while (rs.next()){
				Account account = new Account();
				account.setUsername(rs.getString("login"));
				account.setId(rs.getInt("id"));
				//account.setPassword(rs.getString("password"));
				result.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
		
	}
	
	public Account getAccountByLogin(String login){
		rs = null;
        // SELECT * FROM account WHERE login = ?
        Account result = new Account();
		try {
			loadAccountByLogin.setNString(1, login);
			rs = loadAccountByLogin.executeQuery();
			
			while (rs.next()){
			result.setId(rs.getInt("id"));
			result.setUsername(rs.getString("login"));
			result.setPassword(rs.getString("password"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public Double averageMarks(int studId, int termsId){
		Double avr=null;
		rs=null;
		try {
			averageMarks.setInt(1, studId);
			averageMarks.setInt(2, termsId);
			rs=averageMarks.executeQuery();
			while(rs.next()){
				avr=rs.getDouble("avg(mark)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
return avr;
	}
	public Map<Discipline,Marks> loadMarksById(int studId, int termsId){
		rs=null;
		Map<Discipline,Marks> mark = new LinkedHashMap<Discipline,Marks>();
		try {
			loadMarksById.setInt(1, studId);
			loadMarksById.setInt(2, termsId);
			rs=loadMarksById.executeQuery();
			while(rs.next()){
				Marks m =new Marks();
				m.setId(rs.getInt("id"));
				m.setId_pair_term_dicsipline(rs.getInt("id_terms_disceplines"));
				m.setId_student(rs.getInt("id_student"));
				m.setMark(rs.getInt("mark"));
				Discipline d = new Discipline();
				d.setId(rs.getInt("id_disceplines"));
				d.setName(rs.getString("disciplines"));
				mark.put(d,m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mark;
	}
	public List<Role> getRolesById(int id){
		rs = null;
		List<Role> result = new LinkedList<Role>();
		try {
			loadRolesById.setInt(1, id);
			rs = loadRolesById.executeQuery();
			
			while (rs.next()){
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("role"));
				result.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	public Student getStudentById(int id){
		rs = null;
		Student result = new Student();
		try {
			loadStudentById.setInt(1, id);
			rs = loadStudentById.executeQuery();
			while (rs.next()){
				Date date=null;
				Student r = new Student();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setSurname(rs.getString("surname"));
				r.setDate(rs.getDate("date"));
				r.setGroup(rs.getString("group"));
				result=r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean updateStudentById(Student student){
		try {
			updateStudentById.setString(1,student.getName());
			updateStudentById.setString(2,student.getSurname());
			updateStudentById.setDate(3, new java.sql.Date(student.getDate().getTime()));
			updateStudentById.setString(4,student.getGroup());
			updateStudentById.setInt(5,student.getId());
			updateStudentById.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteStudentById(int id){
		try {
			deleteStudentById.setInt(1,id);
			deleteStudentById.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createDiscipline(Discipline disc){
		try {
			createDiscipline.setString(1,disc.getName());
			createDiscipline.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateDiscipline(Discipline disc){
		try {
			updateDisciplineById.setString(1,disc.getName());
			updateDisciplineById.setInt(2,disc.getId());
			updateDisciplineById.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteDisciplineById(int id){
		try {
			deleteDisciplineById.setInt(1,id);
			deleteDisciplineById.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createStudent(Student student){
		try {
			createStudent.setString(1,student.getName());
			createStudent.setString(2,student.getSurname());
			createStudent.setDate(3, new java.sql.Date(student.getDate().getTime()));
			createStudent.setString(4,student.getGroup());
			createStudent.executeUpdate();
			rs = lastInsertID.executeQuery();
			int id=0;
			while (rs.next()){
				id=rs.getInt("LAST_INSERT_ID()");
			}
			List<Integer> disc=new LinkedList<Integer>();
			rs=getAllDisciplineTerms.executeQuery();
			while (rs.next()){
				disc.add(rs.getInt("ID"));
			}
			for(int i=0; i<disc.size(); i++) {
				putDisceplineMark.setInt(1, id);
				putDisceplineMark.setInt(2, disc.get(i));
				putDisceplineMark.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void close() {
		closePreparedStatements();
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			LOGGER.info("close() exeption " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Integer> getIdAccountRoles(int idAccount) {
		rs = null;
		List<Integer> idAccountRoles = new ArrayList<Integer>();
		try {
			getIdAccountRoles.setInt(1, idAccount);
			rs = getIdAccountRoles.executeQuery();
			
			while (rs.next()){
				idAccountRoles.add(rs.getInt("id_role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return idAccountRoles;
	}
	
	public List<Discipline> getDisciplines(){
		rs = null;
		List<Discipline> disciplinesList = new LinkedList<Discipline>();
		try{
			rs = getDisciplines.executeQuery();
			while (rs.next()){
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id"));
				discipline.setName(rs.getString("disciplines"));
				disciplinesList.add(discipline);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return disciplinesList;
	}
	
	public Discipline getDisciplineById(int id){
		rs = null;
		Discipline discipline = new Discipline();
		try {
			getDisciplineById.setInt(1, id);
			rs = getDisciplineById.executeQuery();
			rs.next();
			discipline.setId(id);
			discipline.setName(rs.getString("disciplines"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discipline;
		
	}
}
