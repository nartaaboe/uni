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

	/**
	 * Views an employee request.
	 *
	 * @param request The request to be viewed.
	 */
	public void viewEmployeeRequest(Request request) {
		// TODO implement me	
	}

	/**
	 * Approves a student's registration.
	 *
	 * @param student The student whose registration is to be approved.
	 */
	public void approveStudentRegistration(Student student) {
		// TODO implement me	
	}

	/**
	 * Approves an employee request.
	 *
	 * @param request The request to be approved.
	 */
	public void approveEmployeeRequest(Request request) {
		// TODO implement me	
	}

	/**
	 * Assigns teachers to courses within the faculty.
	 */
	public void assignTeachersToCourses() {
		// TODO implement me	
	}
	
}

