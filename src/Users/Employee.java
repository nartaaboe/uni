package Users ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Database.Data;
import Enums.UserType;
import Message.Message;
import Message.Request;

/**
 * An abstract Employee class representing an employee of the university.
 */
public abstract class Employee extends User implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The employee's salary.
	 */
	private double salary;

	/**
	 * A list of messages received by the employee.
	 */
	private List<Message> receivedMessages;

	/**
	 * Creates a new Employee object with default values.
	 */
	public Employee(){
		super();
	}

	/**
	 * Creates a new Employee object with the specified details.
	 *
	 * @param userType    The employee's user type.
	 * @param id          The employee's ID.
	 * @param password    The employee's password.
	 * @param username    The employee's username.
	 * @param salary      The employee's salary.
	 */
	public Employee(UserType userType, String id, String password, String username, double salary) {
		super(userType, id, password, username);
		this.salary = salary;
		this.receivedMessages = new ArrayList<Message>();
	}

	/**
	 * Creates a new Employee object with the specified details.
	 *
	 * @param userType    The employee's user type.
	 * @param id          The employee's ID.
	 * @param password    The employee's password.
	 * @param username    The employee's username.
	 */
	public Employee(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
		this.receivedMessages = new ArrayList<Message>();
	}

	/**
	 * Returns the employee's salary.
	 *
	 * @return The employee's salary.
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Returns a list of messages received by the employee.
	 *
	 * @return A list of Message objects representing the received messages.
	 */
	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	/**
	 * Sends a message to another employee.
	 *
	 * @param receiver    The employee to whom the message is being sent.
	 * @param message     The message to be sent.
	 */
	public void sendMessage(Employee receiver, Message message) {
		receiver.getReceivedMessages().add(message);
	}

	/**
	 * Sends a request to a manager.
	 *
	 * @param manager     The manager to whom the request is being sent.
	 * @param request     The request to be sent.
	 */
	private Request createRequest() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter title: ");
		String title = bf.readLine();
		System.out.println("Enter description: ");
		String description = bf.readLine();
		return new Request(title, description, this);
	}


	public void sendRequest() throws IOException {
		for(User user : Data.getInstance().getUsers()){
			if(user instanceof Manager){
				((Manager) user).getReceivedRequests().add(createRequest());
			}
		}
	}

}

