package se.scrumwise.feelings.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.scrumwise.feelings.tools.Mailer;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* sendAuthorisationLink ska köras på doPost, 
		 * doGet kommer köras när användaren klickar på Länken, och då plockar vi ut parametrar
		 Nu testkör vi bara*/
		
		String to  = "j10patriks@gmail.com";
		String name = "Patrik";
		Mailer mail = new Mailer();
		mail.sendAuthorisationLink(to, name);
		System.out.println("Sent");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
