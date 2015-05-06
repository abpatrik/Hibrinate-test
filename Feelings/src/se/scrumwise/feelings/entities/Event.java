package se.scrumwise.feelings.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Event {

	private String name;
	private String category;
	private int motivationDegree;
	private int reactionDegree;
	private int timeStampBefore;
	private int timeStampAfter;



	public Event(String name, String category) {
		this.name = name;
		this.category = category;
		
	}
	public Event() {

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMotivationDegree() {
		return motivationDegree;
	}
	public void setMotivationDegree(int motivationDegree) {
		this.motivationDegree = motivationDegree;
	}
	public int getReactionDegree() {
		return reactionDegree;
	}
	public void setReactionDegree(int reactionDegree) {
		this.reactionDegree = reactionDegree;
	}
	
	public int getTimeStampBefore() {
		return timeStampBefore;
	}

	public void setTimeStampBefore(int timeStampBefore) {
		this.timeStampBefore = timeStampBefore;
	}

	public int getTimeStampAfter() {
		return timeStampAfter;
	}

	public void setTimeStampAfter(int timeStampAfter) {
		this.timeStampAfter = timeStampAfter;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", category=" + category
				+ ", motivationDegree=" + motivationDegree
				+ ", reactionDegree=" + reactionDegree + "]";
	}

}
