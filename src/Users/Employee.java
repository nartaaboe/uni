package Users ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Enums.UserType;
import Message.Message;
import Message.Request;

/**
 * This abstract class represents an employee within the system, extending the User class with employee-specific properties and functionality.
 */

public abstract class Employee extends User implements Serializable {

	/**
	 * The employee's salary.
	 */
	private double salary;

	/**
	 * The list of messages received by the employee.
	 */
	private List<Message> receivedMessages;


	/**
	 * Creates an employee with default values.
	 */
	public Employee(){
		super();
	}

	/**
	 * Creates an employee with the specified user type, ID, password, username, and salary.
	 *
	 * @param userType     The user type (Employee).
	 * @param id           The employee's unique ID.
	 * @param password     The employee's password.
	 * @param username     The employee's username.
	 * @param salary       The employee's salary.
	 */
	public Employee(UserType userType, String id, String password, String username, double salary) {
		super(userType, id, password, username);
		this.salary = salary;
		this.receivedMessages = new ArrayList<Message>();
	}

	/**
	 * Gets the employee's salary.
	 *
	 * @return The employee's salary.
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Gets the list of messages received by the employee.
	 *
	 * @return The list of received messages.
	 */
	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	/**
	 * Sends a message to another employee.
	 *
	 * @param receiver The employee who will receive the message.
	 * @param message  The message to send.
	 */
	public void sendMessage(Employee receiver, Message message) {
		receiver.getReceivedMessages().add(message);
	}

	/**
	 * Sends a request to a manager.
	 *
	 * @param manager   The manager who will receive the request.
	 * @param request   The request to send.
	 */

	public void sendRequest(Manager manager, Request request) {

		manager.getReceivedRequests().add(request);
	}
	
}

