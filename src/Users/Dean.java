package Users ;

import Enums.Faculty;
import Enums.TeacherType;
import Message.Order;
import Message.Request;

import java.io.Serializable;
import java.util.Queue;

/**
 * A Dean class representing the dean of a faculty within the university.
 */
public class Dean extends Teacher implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The faculty that the dean oversees.
	 */
	private Faculty faculty;

	/**
	 * The dean's title (e.g., "Associate Dean", "Assistant Dean").
	 */
	private TeacherType title;

	/**
	 * A queue of complaints received by the dean.
	 */
	private Queue<Order>receivedComplaints;

	/**
	 * Creates a new Dean object with default values.
	 */
	public Dean(){
		super();
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public TeacherType getTitle() {
		return title;
	}
	public Queue<Order> getReceivedComplaints() {
		return receivedComplaints;
	}

	public void manageReceivedOrder(){
		Order order = receivedComplaints.poll();
		System.out.println("Order -> " + order + '\n' + " closed.");
	}
}

