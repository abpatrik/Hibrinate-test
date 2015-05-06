package se.scrumwise.feelings.handler;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.scrumwise.feelings.entities.Event;
import se.scrumwise.feelings.entities.User;

public class DatabaseHandler {

	private EntityManager manager;


	public DatabaseHandler() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("feelings");
		manager = factory.createEntityManager();

	}

	public User findUser(String email) {

		manager.getTransaction().begin();
		User user = manager.find(User.class, email);
		manager.getTransaction().commit();
		return user;
	}

	public boolean addUser(User user) {

		try{
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
		}

		catch(EntityExistsException e){
			return false;
		}
		return true;
	}

	public void removeUser(User user) {

		manager.getTransaction().begin();
		User managedUser = manager.find(User.class, user.getEmail());

		if (managedUser != null) {
			manager.remove(managedUser);
			manager.getTransaction().commit();
		}
	}

	public void updateUser(User user) {

		manager.getTransaction().begin();
		User managedUser = manager.find(User.class, user.getEmail());

		if (managedUser != null) {

			managedUser.setAuthorised(user.getAuthorised());
			managedUser.setFirstname(user.getFirstname());
			managedUser.setLastname(user.getLastname());
			managedUser.setPassword(user.getPassword());
			manager.getTransaction().commit();
		}
	}
	public boolean addEvent(Event event) {

		manager.getTransaction().begin();
		manager.persist(event);
		manager.getTransaction().commit();
		return true;
	}

	public boolean completeEvent(Event event){
		return true;
		
	}

	public ArrayList <Event> getEventList(String userId, Date from, Date to){

		return null;
	}

}
