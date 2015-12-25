package entity;

public class Marks extends AbstractModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136003827305681145L;
	
	private Integer id;
	private Integer id_pair_term_dicsipline;
	private Integer mark;
	private Integer id_student;
	
	public Marks(){
		super();
	}
	
	public Marks(Integer id, Integer id_pair_term_dicsipline, Integer mark, Integer id_student){
		super();
		this.id = id;
		this.id_pair_term_dicsipline = id_pair_term_dicsipline;
		this.mark = mark;
		this.id_student = id_student;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_pair_term_dicsipline() {
		return id_pair_term_dicsipline;
	}

	public void setId_pair_term_dicsipline(Integer id_pair_term_dicsipline) {
		this.id_pair_term_dicsipline = id_pair_term_dicsipline;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getId_student() {
		return id_student;
	}

	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}
	

}
