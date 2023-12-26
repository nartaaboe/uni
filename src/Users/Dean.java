package Users ;

import Enums.Faculty;
import Enums.TeacherType;
import Message.Order;
import Message.Request;

import java.io.Serializable;
import java.util.Queue;


/**
 * This class represents a dean within the system, who is a teacher with additional administrative responsibilities.
 */
public class Dean extends Teacher implements Serializable {

	/**
	 * The faculty that the dean is responsible for.
	 */
	private Faculty faculty;

	/**
	 * The dean's title (e.g., "Dean of Engineering").
	 */
	private TeacherType title;

	/**
	 * A queue of received complaints that the dean needs to address.
	 */
	private Queue<Order>receivedComplaints;

	/**
	 * Creates a new dean with default values.
	 */
	public Dean(){
		super();
	}


	/**
	 * Views a request from an employee.
	 *
	 * @param request The request to view.
	 */
	public void viewEmployeeRequest(Request request) {
		// TODO implement me	
	}

	/**
	 * Approves the registration of a student.
	 *
	 * @param student The student to approve registration for.
	 */
	public void approveStudentRegistration(Student student) {
		// TODO implement me	
	}

	/**
	 * Approves a request from an employee.
	 *
	 * @param request The request to approve.
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

