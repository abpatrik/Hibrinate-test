package se.scrumwise.feelings.handler;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import se.scrumwise.feelings.entities.User;

public class UserHandler {

	private DatabaseHandler db = DatabaseHandler.getInstance();

	public User find(String email) {

		return db.findUser(email);
	}

	public boolean add(User user) {

		return db.addUser(user);
	}
	public void remove(User user) {

		db.removeUser(user);
	}

	public void update(User user) {

		db.updateUser(user);
	}
	public boolean sendAuthorisationLink(String to, String name){

		String messageText = "Hi "+ name + "\nTo activate your account, follow this link:\n\n"
				+ "http://localhost:8080/Feelings/register?auth=true&name="+ name +"&email=" + to
				+ "\n\nWelcome to Feelings, we hope you will enjoy using the tool!\nBest regards, The Feelings Team";

		final String username = "p10tomcat@gmail.com";
		final String password = "warszawa81";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Welcome to Feelings");
			message.setText(messageText);
			Transport.send(message);

		} catch (MessagingException e) {
			return false;
		}

		return true;
	}
}


