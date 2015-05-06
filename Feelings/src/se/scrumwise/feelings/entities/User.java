package se.scrumwise.feelings.entities;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class User {
	 
	@Id
	@Column
	private String email;
	@Column
	private String password;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="events", joinColumns = @JoinColumn(name="user_id"))
	private Collection<Event> eventList = new ArrayList<Event>();
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Event> getEventList() {
		return eventList;
	}
	public void setEventList(Collection<Event> eventList) {
		this.eventList = eventList;
	}
	@Transient
	public void addEvent(Event event){
		eventList.add(event);
	}
	
	@Override
	public String toString() {
		return "User [password=secret, email=" + email
				+ ", eventList=" + eventList + "]";
	}
	
}
