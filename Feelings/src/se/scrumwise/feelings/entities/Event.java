package se.scrumwise.feelings.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventId;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	private String meetingType;
	private byte motivation;
	private byte reaction;
	private byte result;
	private Date timestampBefore;
	private Date timestampAfter;
	private Boolean isDone;

	public Event(User user, byte motivation, byte reaction,
			byte result, Date timestampBefore, Date timestampAfter,
			Boolean isDone, String meetingType) {

		this.user = user;
		this.motivation = motivation;
		this.reaction = reaction;
		this.result = result;
		this.timestampBefore = timestampBefore;
		this.timestampAfter = timestampAfter;
		this.isDone = isDone;
		this.meetingType = meetingType;
	}
	public Event() {

	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public byte getMotivation() {
		return motivation;
	}
	public void setMotivation(byte motivation) {
		this.motivation = motivation;
	}
	public byte getReaction() {
		return reaction;
	}
	public void setReaction(byte reaction) {
		this.reaction = reaction;
	}
	public byte getResult() {
		return result;
	}
	public void setResult(byte result) {
		this.result = result;
	}
	public Date getTimestampBefore() {
		return timestampBefore;
	}
	public void setTimestampBefore(Date timestampBefore) {
		this.timestampBefore = timestampBefore;
	}
	public Date getTimestampAfter() {
		return timestampAfter;
	}
	public void setTimestampAfter(Date timestampAfter) {
		this.timestampAfter = timestampAfter;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMeetingType() {
		return meetingType;
	}
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId 
				+ ", motivation=" + motivation + ", reaction=" + reaction
				+ ", result=" + result + ", timestampBefore=" + timestampBefore
				+ ", timestampAfter=" + timestampAfter + ", isDone=" + isDone +  ", userId " + user.getUserId() +  "]";
	}
}
