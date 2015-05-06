package se.scrumwise.feelings.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class User {

	@Id
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Boolean authorised;

	public User() {

	}

	public User(String email, String password, String firstname, String lastname, Boolean authorised) {

		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.authorised = authorised;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Boolean getAuthorised() {
		return authorised;
	}

	public void setAuthorised(Boolean authorised) {
		this.authorised = authorised;
	}

	@Override
	@Transient
	public String toString() {
		return "User [email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", authorised=" + authorised + "]";
	}

}
