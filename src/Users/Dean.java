package Users ;

import Enums.Faculty;
import Enums.TeacherType;
import Message.Order;
import Message.Request;

import java.io.Serializable;
import java.util.Queue;

public class Dean extends Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private TeacherType title;
	private Queue<Order>receivedComplaints;
	public Dean(){
		super();
	}

	public void viewEmployeeRequest(Request request) {
		// TODO implement me	
	}
	public void approveStudentRegistration(Student student) {
		// TODO implement me	
	}
	public void approveEmployeeRequest(Request request) {
		// TODO implement me	
	}
	public void assignTeachersToCourses() {
		// TODO implement me	
	}
	
}

