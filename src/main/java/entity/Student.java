package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends AbstractModelIdName{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5638726927853322152L;
	
	private String surname;
	private	String group;
	private Date date;
	private String dateString;
	
	public Student(){
		super();
	}
	
	public Student(Integer id, String name, String first_name, String group, Date date){
		super(id, name);
		this.surname = first_name;
		this.group = group;
		this.date = date;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String first_name) {
		this.surname = first_name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date getDate() {
			return date;
	}
	public String getDateString() {
		SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = myDateFormat.format(date);
		return strDate;
	}
	public void setDate(Date date) {
		this.date = date;
		SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.dateString = myDateFormat.format(date);

	}


}
