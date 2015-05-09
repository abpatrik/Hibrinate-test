package se.scrumwise.feelings.entities;

public class EventType {

	public interface EventTypeInterface {
		String getDisplayableType();
	}
	
	public EventType() {

	}

	public static enum Type implements EventTypeInterface {

		GROUP("Group"), INDIVIDUAL("Individual");
		private final String type;

		private Type(final String type) {
			this.type = type;
		}

		public String getDisplayableType() {
			return type;
		}
	}

	public static enum Event implements EventTypeInterface {

		DIGITALLY_MEETING("Digitally meeting", Type.GROUP),
		INDIVIDUAL_MEETING("Individual meeting", Type.GROUP),
		GROUP_MEETING("Group meeting", Type.GROUP),
		PHONE_MEETING("Phone meeting", Type.GROUP),
		CONCENTRATION_WORK("Concentrationwork", Type.INDIVIDUAL),
		PHYSICAL_WORK("Phisicalwork", Type.INDIVIDUAL),
		TRAINING("Training", Type.INDIVIDUAL),
		RELAXATION_REFLECTION("Ralaxation reflection", Type.INDIVIDUAL);

		private final String event;
		private final Type type;

		 private Event(String event, Type type) {
			this.event = event;
			this.type = type;
		}

		public String getEvent() {
			return event;
		}
		
		public String getDisplayableType() {
			return type.getDisplayableType();
		}

		public String getEventType() {
			return getEvent() + ": " + getDisplayableType() ;
		}
	}
}
