package se.scrumwise.feelings.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.scrumwise.feelings.entities.User;
import se.scrumwise.feelings.handler.DatabaseHandler;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseHandler service;
       
   
	public void init() throws ServletException {
		service = new DatabaseHandler();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User a = new User("Patrik", "xxxx");
		
		service.add(a);
		
		System.out.println(service.find("Patrik"));

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
