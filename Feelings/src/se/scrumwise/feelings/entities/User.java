package se.scrumwise.feelings.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Event> events;
	
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
	
	public Collection<Event> getEvents() {
		return events;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}
	
	@Transient
	public void addEvent(Event event){
		events.add(event);
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", authorised=" + authorised
				+ ", events=" + events + "]";
	}

}
