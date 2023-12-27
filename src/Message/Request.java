package Message ;

import Contents.Course;
import Users.Student;
import Users.Teacher;
import Users.User;

import java.io.Serializable;

/**
 * This class represents a request within the system, encapsulating its description and the employee who sent it.
 */
public class Request implements Readable, Serializable {
	private String title;
	/**
	 * The description of the request.
	 *
	 */
	private String description;
	private Course course;
	/**
	 * The employee who sent the request.
	 */
	private User from;

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
	public Request(String title, String description, User from) {
		this.title = title;
		this.description = description;
		this.from = from;
	}
	public Request(String title, Course course, User from){
		this.title =title;
		this.course = course;
		this.from = from;
	}
	/**
	 * Returns a formatted string representation of the request, suitable for reading.
	 * Includes the sender's information and the request description.
	 *
	 * @return The formatted request string.
	 */
	public String read() {
		return from.toString() + ": " + title + '\n' + description;
	}
	public String getTitle() {
		return title;
	}

	public Course getCourse() {
		return course;
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
	public User getFrom() {
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

