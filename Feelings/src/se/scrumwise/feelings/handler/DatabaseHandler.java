package se.scrumwise.feelings.handler;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.hibernate.exception.ConstraintViolationException;
import se.scrumwise.feelings.entities.Event;
import se.scrumwise.feelings.entities.User;

public class DatabaseHandler {

	private EntityManager manager;
	static DatabaseHandler dbhandler;

	private DatabaseHandler() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("feelings");
		manager = factory.createEntityManager();
	}

	public static DatabaseHandler getInstance(){

		if (dbhandler == null)
			dbhandler = new DatabaseHandler();
		return dbhandler;
	}

	public User findUserById(long id) {

		manager.getTransaction().begin();
		User user = manager.find(User.class, id);
		manager.getTransaction().commit();

		return user;

	}
	public User findUserByEmail(String email) {

		return (User)manager.createQuery("FROM User e WHERE e.email = ?1", User.class)
				.setParameter(1, email).getSingleResult();

	}

	public boolean addUser(User user) {

		try{
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();

		}

		catch(PersistenceException e){
			Throwable t = e.getCause();
			
			if (t instanceof ConstraintViolationException) {	
				manager.getTransaction().rollback();
			}
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

	public boolean updateUser(User user) {

		manager.getTransaction().begin();
		User managedUser = manager.find(User.class, user.getUserId());

		if (managedUser != null) {

			managedUser.setAuthorised(user.getAuthorised());
			managedUser.setFirstname(user.getFirstname());
			managedUser.setLastname(user.getLastname());
			managedUser.setPassword(user.getPassword());
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean addEvent(Event event) {

		manager.getTransaction().begin();
		manager.persist(event);
		manager.getTransaction().commit();

		return true;
	}

	public boolean completeEvent(Event event){

		manager.getTransaction().begin();
		Event managedEvent = manager.find(Event.class, event.getEventId());

		if (managedEvent != null) {
			managedEvent.setIsDone(event.getIsDone());
			managedEvent.setMotivation(event.getMotivation());
			managedEvent.setReaction(event.getReaction());
			managedEvent.setResult(event.getResult());
			managedEvent.setTimestampAfter(event.getTimestampAfter());
			managedEvent.setTimestampBefore(event.getTimestampBefore());
			manager.getTransaction().commit();

			return true;
		}
		return false;
	}

	public ArrayList<Event> getEventList(String userId){
		return (ArrayList<Event>)manager.createQuery("FROM Event e WHERE e.user.email = ?1", Event.class)
				.setParameter(1, userId).getResultList();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Event> getEventListByDate(String userId, Date from, Date to){

		Query query = manager.createQuery("FROM Event e WHERE e.user.email = ?1 AND e.timestampAfter >= ?2 AND e.timestampAfter <= ?3", Event.class);
		query.setParameter(1, userId);
		query.setParameter(2, from);
		query.setParameter(3, to);

		return  (ArrayList<Event>)query.getResultList();
	}
}
