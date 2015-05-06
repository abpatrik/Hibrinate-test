package se.scrumwise.feelings.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.scrumwise.feelings.entities.Event;
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
		userHandler.add(user);
		user = userHandler.find("j10patriks@gmail.com");
		System.out.println(user);

		Event even1 = new Event(user, (byte)2, (byte)3, (byte)5, new Date(), new Date(), false);
		
		
		DatabaseHandler db = new DatabaseHandler();
		db.addEvent(even1);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
