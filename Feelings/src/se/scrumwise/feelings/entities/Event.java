package se.scrumwise.feelings.entities;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Event {

	private Long eventId;
	private String userIdEmail;
	private Byte motivation;
	private Byte reaction;
	private Byte result;
	private Date timestampBefore;
	private Date timestampAfter;
	private Boolean isDone;

	public Event(String userIdEmail, Byte motivation, Byte reaction,
			Byte result, Date timestampBefore, Date timestampAfter,
			Boolean isDone) {

		this.userIdEmail = userIdEmail;
		this.motivation = motivation;
		this.reaction = reaction;
		this.result = result;
		this.timestampBefore = timestampBefore;
		this.timestampAfter = timestampAfter;
		this.isDone = isDone;
	}
	public Event() {

	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getUserIdEmail() {
		return userIdEmail;
	}
	public void setUserIdEmail(String userIdEmail) {
		this.userIdEmail = userIdEmail;
	}
	public Byte getMotivation() {
		return motivation;
	}
	public void setMotivation(Byte motivation) {
		this.motivation = motivation;
	}
	public Byte getReaction() {
		return reaction;
	}
	public void setReaction(Byte reaction) {
		this.reaction = reaction;
	}
	public Byte getResult() {
		return result;
	}
	public void setResult(Byte result) {
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
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", userIdEmail=" + userIdEmail
				+ ", motivation=" + motivation + ", reaction=" + reaction
				+ ", result=" + result + ", timestampBefore=" + timestampBefore
				+ ", timestampAfter=" + timestampAfter + ", isDone=" + isDone + "]";
	}

}

