package se.scrumwise.feelings.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.scrumwise.feelings.entities.Event;
import se.scrumwise.feelings.entities.User;
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
		System.out.println(userHandler.find("Patrik"));
		
		Event even1 = new Event(user, (byte)2, (byte)3, (byte)5, new Date(), new Date(), false);
		Event even2 = new Event(user, (byte)2, (byte)3, (byte)5, new Date(), new Date(), false);
		Event even3 = new Event(user, (byte)2, (byte)3, (byte)5, new Date(), new Date(), false);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
