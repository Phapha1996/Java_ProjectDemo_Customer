package bean;

import java.util.Date;

public class Customer {

	private String id;
	private String name;
	private String gender;
	private Date birthday;
	private String cellphone;
	private String email;
	private String preference;
	private String type;
	private String description;
	
	
	
	public Customer() {
		super();
	}


	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	public String getCellphone() {
		return cellphone;
	}
	
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPreference() {
		return preference;
	}
	
	
	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String desciption) {
		this.description = desciption;
	}
	
	
}
/*	id VARCHAR(40) PRIMARY KEY,
 	name VARCHAR(20) NOT NULL,
 	gender VARCHAR(4) NOT NULL,
 	birthday DATE,
	cellphone VARCHAR(15) NOT NULL,
	email VARCHAR(20),
	preference VARCHAR(200),
	type VARCHAR(40),
	description VARCHAR(255)*/