package Users ;


import Contents.Course;
import Enums.Faculty;
import Enums.ManagerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Contents.News;
import Message.Request;

/**
 * This class represents a manager within the system, who is an employee with additional responsibilities for managing courses, students, and teachers.
 */
public class Manager extends Employee implements Serializable {

	/**
	 * The type of manager (e.g., "Academic Manager", "Finance Manager").
	 */
	private ManagerType managerType;

	/**
	 * The faculty that the manager is responsible for.
	 */
	private Faculty faculty;

	/**
	 * A buffered reader used for input.
	 */
	private BufferedReader bf;

	/**
	 * A list of received requests from employees.
	 */
	private List<Request> receivedRequests;

	/**
	 * Creates a new manager with default values.
	 */
	public Manager(){
		bf = new BufferedReader(new InputStreamReader(System.in));
		receivedRequests = new ArrayList<>();
	}

	/**
	 * Creates a new manager with the specified manager type and faculty.
	 *
	 * @param managerType The type of manager.
	 * @param faculty     The faculty that the manager is responsible for.
	 */
	public Manager(ManagerType managerType, Faculty faculty){
		this.managerType = managerType;
		this.faculty = faculty;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
		this.receivedRequests = new ArrayList<>();
	}

	/**
	 * Creates a new manager with the specified manager type, faculty, and received requests.
	 *
	 * @param managerType     The type of manager.
	 * @param faculty         The faculty that the manager is responsible for.
	 * @param receivedRequests A list of received requests.
	 */
	public Manager(ManagerType managerType, Faculty faculty, List<Request> receivedRequests){
		this.managerType = managerType;
		this.faculty = faculty;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
		this.receivedRequests = receivedRequests;
	}

	/**
	 * Returns the type of manager.
	 *
	 * @return The type of manager.
	 */
	public ManagerType getManagerType() {
		return managerType;
	}

	/**
	 * Returns the faculty that the manager is responsible for.
	 *
	 * @return The faculty that the manager is responsible for.
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	/**
	 * Returns a list of received requests from employees.
	 *
	 * @return A list of received requests from employees.
	 */
	public List<Request> getReceivedRequests() {
		return receivedRequests;
	}

	/**
	 * Approves the registration of a student.
	 *
	 * @param student The student to approve registration for.
	 */
	public void approveRegistration(Student student) {

	}

	/**
	 * Adds a course for registration.
	 *
	 * @param course The course to add.
	 */
	public void addCourseForRegistration(Course course){

	}

	/**
	 * Assigns a course to a teacher.
	 */
	public void assignCourse(){

	}

	/**
	 * Writes out a course from the system.
	 */
	public void writeOutCourse(){

	}

	/**
	 * Views information about teachers within the faculty.
	 */
	public void viewInfoAboutTeachers() {
	}

	/**
	 * Views information about students within the faculty.
	 */
	public void viewInfoAboutStudents() {
	}

	/**
	 * Generates a statistical report for the faculty.
	 */
	public void statisticalReport() {
	}

	/**
	 * Adds a news item to the system.
	 */
	public void addNews() {

	}

	/**
	 * Removes a news item from the system.
	 */
	public void removeNews(){

	}
}

