package entity;

import java.io.Serializable;

public class Userinfo implements Serializable {
	
	private String username;
	private String password; 
	private String name;
	private String idnumber;
	private String email;
	private String sex;
	private String tel;
	private String mac;
	private String campus;
	private String build;
	private String room;
	private String department;
	private String type;
	private String typeid;	
	private String isverify;
	
	public Userinfo() {
	}

	public Userinfo(String build, String campus, String department,
			String email, String idnumber, String isverify, String mac,
			String name, String password, String room, String sex, String tel,
			String type, String typeid, String username) {
		super();
		this.build = build;
		this.campus = campus;
		this.department = department;
		this.email = email;
		this.idnumber = idnumber;
		this.isverify = isverify;
		this.mac = mac;
		this.name = name;
		this.password = password;
		this.room = room;
		this.sex = sex;
		this.tel = tel;
		this.type = type;
		this.typeid = typeid;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getIsverify() {
		return isverify;
	}

	public void setIsverify(String isverify) {
		this.isverify = isverify;
	}

}
