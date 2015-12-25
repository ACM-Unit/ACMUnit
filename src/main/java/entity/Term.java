package entity;

import java.util.LinkedList;
import java.util.List;

public class Term extends AbstractModelBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7252416991018625450L;
	
	private Integer id;
	private Integer duration;
	private List<Discipline> discipline = new LinkedList<Discipline>();
	
	public Term(){
		super();
	}
	
	public Term(Integer id, Integer duration, List<Discipline> discipline){
		super();
		this.id = id;
		this.duration = duration;
		this.discipline = discipline;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<Discipline> getDiscipline() {
		return discipline;
	}

	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}
	

}
