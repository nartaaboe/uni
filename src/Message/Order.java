package Message ;

import Enums.UrgencyLevel;
import Users.Employee;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;

/**
 * This class represents an order within the system, encapsulating its description, urgency level, sender (employee), recipient (student), and viewed status.
 */
public class Order implements Readable, Serializable {

	/**
	 * The description of the order.
	 */
	private String description;

	/**
	 * The urgency level of the order (HIGH, MEDIUM, or LOW).
	 */
	private UrgencyLevel urgencyLevel;

	/**
	 * The employee who sent the order.
	 */
	private Employee from;

	/**
	 * The student who is the recipient of the order.
	 */
	private Student to;

	/**
	 * Indicates whether the order has been viewed by the recipient or not.
	 */
	private boolean isViewed;

	/**
	 * Creates an order with default values.
	 */
	public Order(){
	}

	/**
	 * Creates an order with the specified description, urgency level, sender, recipient, and viewed status.
	 *
	 * @param description   The description of the order.
	 * @param urgencyLevel  The urgency level of the order.
	 * @param from          The employee who sent the order.
	 * @param to            The student who is the recipient of the order.
	 */
	public Order(String description, UrgencyLevel urgencyLevel, Employee from, Student to) {
		this.description = description;
		this.urgencyLevel = urgencyLevel;
		this.from = from;
		this.to = to;
		this.isViewed = false;
	}

	/**
	 * Gets the urgency level of the order.
	 *
	 * @return The urgency level of the order (HIGH, MEDIUM, or LOW).
	 */
	public UrgencyLevel getUrgencyLevel() { return urgencyLevel; }

	/**
	 * Gets the viewed status of the order.
	 *
	 * @return True if the order has been viewed, false otherwise.
	 */
	public boolean getIsViewed() { return isViewed; }

	/**
	 * Returns a formatted string representation of the order, suitable for reading.
	 * Marks the order as viewed when read.
	 *
	 * @return The formatted order string.
	 */
	public String read() {
		isViewed = true;
		return description;
	}

	/**
	 * Sets the description of the order.
	 *
	 * @param description The new description of the order.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the urgency level of the order.
	 *
	 * @param urgencyLevel The new urgency level of the order (HIGH, MEDIUM, or LOW).
	 */
	public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}

	/**
	 * Gets the recipient of the order.
	 *
	 * @return The student who is the recipient of the order.
	 */
	public Student getTo() {
		return to;
	}

	/**
	 * Sets the recipient of the order.
	 *
	 * @param to The student who will be the new recipient of the order.
	 */
	public void setTo(Student to) {
		this.to = to;
	}

	/**
	 * Gets the sender of the order.
	 *
	 * @return The employee who sent the order.
	 */
	public Employee getFrom() {
		return from;
	}

	/**
	 * Sets the sender of the order.
	 *
	 * @param from The employee who will be the new sender of the order.
	 */
	public void setFrom(Employee from) {
		this.from = from;
	}

	/**
	 * Sets the viewed status of the order.
	 *
	 * @param viewed True if the order has been viewed, false otherwise.
	 */
	public void setViewed(boolean viewed) {
		isViewed = viewed;
	}

	/**
	 * Gets the description of the order.
	 *
	 * @return The description of the order.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Checks if the order has been viewed.
	 *
	 * @return True if the order has been viewed, false otherwise.
	 */
	public boolean isViewed() {
		return isViewed;
	}

	/**
	 * Returns a concise string representation of the order, including its description, urgency level, and viewed status.
	 *
	 * @return The concise string representation of the order.
	 */
	@Override
	public String toString() {
		return "Order{" +
				"description='" + description + '\'' +
				", urgencyLevel=" + urgencyLevel +
				", isViewed=" + isViewed +
				'}';
	}
}

