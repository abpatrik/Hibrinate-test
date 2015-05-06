package se.scrumwise.feelings.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.scrumwise.feelings.handler.UserHandler;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserHandler userHandler;

	public void init() throws ServletException {
		userHandler = new UserHandler();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* sendAuthorisationLink ska k�ras p� doPost, 
		 * doGet kommer k�ras n�r anv�ndaren klickar p� L�nken, och d� plockar vi ut parametrar
		 Nu testk�r vi bara*/

		String to  = "j10patriks@gmail.com";
		String name = "Patrik";
		userHandler.sendAuthorisationLink(to, name);
		System.out.println("Sent");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
