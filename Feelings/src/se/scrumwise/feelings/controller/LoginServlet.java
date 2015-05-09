package se.scrumwise.feelings.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.scrumwise.feelings.entities.Event;
import se.scrumwise.feelings.entities.EventType;
import se.scrumwise.feelings.entities.User;
import se.scrumwise.feelings.handler.DatabaseHandler;
import se.scrumwise.feelings.handler.UserHandler;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserHandler userHandler;


	public void init() throws ServletException {
		userHandler = new UserHandler();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User("j10patriks@gmail.com", "xxxxxx", "Patrik", "Svensson", false);
		User user1 = new User("j10patriks@gmail.co", "xxxxxx", "Patrik", "Svensson", false);
		userHandler.add(user);
		userHandler.add(user1);
		user = userHandler.findByEmail("j10patriks@gmail.com");
		System.out.println(user);

		Event even1 = new Event(user, (byte)2, (byte)3, (byte)5, new Date(), new Date(), false, EventType.Event.GROUP_MEETING.getEventType());
		
		DatabaseHandler db = DatabaseHandler.getInstance();
		Date date1;
		Date date2;
		
	
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.HOUR,13);
        cal.set(Calendar.MINUTE,45);
        cal.set(Calendar.SECOND,52);
        date1 = cal.getTime();
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 9);
        cal1.set(Calendar.DATE, 24);
        cal1.set(Calendar.YEAR, 2016);
        cal1.set(Calendar.HOUR,13);
        cal1.set(Calendar.MINUTE,45);
        cal1.set(Calendar.SECOND,52);
        date2 = cal1.getTime();
        System.out.println(date1);
        System.out.println(date2);
		ArrayList<Event> list = db.getEventListByDate("j10patriks@gmail.com", date1, date2);
		for(Event e: list)
			System.out.println(e);
		
				db.addEvent(even1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
