package se.scrumwise.feelings.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
