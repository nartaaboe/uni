package Message ;

import Users.Employee;

import java.io.IOException;
import java.io.Serializable;
import java.nio.CharBuffer;

/**
 * This class represents a request within the system, encapsulating its description and the employee who sent it.
 */
public class Request implements Readable, Serializable {

	/**
	 * The description of the request.
	 */
	private String description;

	/**
	 * The employee who sent the request.
	 */
	private Employee from;

	/**
	 * Creates a request with default values.
	 */
	public Request(){
	}

	/**
	 * Creates a request with the specified description and sender.
	 *
	 * @param description   The description of the request.
	 * @param from          The employee who sent the request.
	 */
	public Request(String description, Employee from) {
		this.description = description;
		this.from = from;
	}

	/**
	 * Returns a formatted string representation of the request, suitable for reading.
	 * Includes the sender's information and the request description.
	 *
	 * @return The formatted request string.
	 */
	public String read() {
		return from.toString() + '\n' + description;
	}

	/**
	 * Gets the description of the request.
	 *
	 * @return The description of the request.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the sender of the request.
	 *
	 * @return The employee who sent the request.
	 */
	public Employee getFrom() {
		return from;
	}

	/**
	 * Returns a concise string representation of the request, including its description and sender.
	 *
	 * @return The concise string representation of the request.
	 */
	@Override
	public String toString() {
		return "Request{" +
				"description='" + description + '\'' +
				", from=" + from +
				'}';
	}
}

