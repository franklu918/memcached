package entity;

/**
 * Admi entity.
 * @author
 */

public class Admi implements java.io.Serializable {

	private int id;
	private String username;
	private String password;

	public Admi() {
	}

	public Admi(String username) {
		this.username = username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
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
}