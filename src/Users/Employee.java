package Users ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Enums.UserType;
import Message.Message;
import Message.Request;

public abstract class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private double salary;
	private List<Message> receivedMessages;
	public Employee(){
		super();
	}
	public Employee(UserType userType, String id, String password, String username, double salary) {
		super(userType, id, password, username);
		this.salary = salary;
		this.receivedMessages = new ArrayList<Message>();
	}

	public double getSalary() {
		return salary;
	}
	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}
	public void sendMessage(Employee receiver, Message message) {
		receiver.getReceivedMessages().add(message);
	}
	public void sendRequest(Manager manager, Request request) {

		manager.getReceivedRequests().add(request);
	}
	
}

