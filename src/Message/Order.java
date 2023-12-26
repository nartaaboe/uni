package Message ;

import Enums.UrgencyLevel;
import Users.Employee;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;


public class Order implements Readable, Serializable {
	private String description;
	private UrgencyLevel urgencyLevel;
	private Employee from;
	private Student to;
	private boolean isViewed;
	public Order(){
	}
	public Order(String description, UrgencyLevel urgencyLevel, Employee from, Student to) {
		this.description = description;
		this.urgencyLevel = urgencyLevel;
		this.from = from;
		this.to = to;
		this.isViewed = false;
	}

	public UrgencyLevel getUrgencyLevel() { return urgencyLevel; }

	public boolean getIsViewed() { return isViewed; }

	public String read() {
		isViewed = true;
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}

	public Student getTo() {
		return to;
	}

	public void setTo(Student to) {
		this.to = to;
	}

	public Employee getFrom() {
		return from;
	}

	public void setFrom(Employee from) {
		this.from = from;
	}

	public void setViewed(boolean viewed) {
		isViewed = viewed;
	}

	public String getDescription() {
		return description;
	}
	public boolean isViewed() {
		return isViewed;
	}

	@Override
	public String toString() {
		return "Order{" +
				"description='" + description + '\'' +
				", urgencyLevel=" + urgencyLevel +
				", isViewed=" + isViewed +
				'}';
	}
}

