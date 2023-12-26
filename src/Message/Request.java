package Message ;

import Users.Employee;

import java.io.IOException;
import java.io.Serializable;
import java.nio.CharBuffer;


public class Request implements Readable, Serializable {
	private String description;
	private Employee from;
	public Request(){
	}
	public Request(String description, Employee from) {
		this.description = description;
		this.from = from;
	}
	public String read() {
		return from.toString() + '\n' + description;
	}

	public String getDescription() {
		return description;
	}

	public Employee getFrom() {
		return from;
	}

	@Override
	public String toString() {
		return "Request{" +
				"description='" + description + '\'' +
				", from=" + from +
				'}';
	}
}

