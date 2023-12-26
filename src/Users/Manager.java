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
 * A Manager class representing a manager with responsibilities within a specific faculty or area of the university.
 */
public class Manager extends Employee implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The manager's type (e.g., "Academic Affairs Manager", "Student Affairs Manager").
	 */
	private ManagerType managerType;

	/**
	 * The faculty that the manager oversees (if applicable).
	 */
	private Faculty faculty;

	/**
	 * A list of requests received by the manager.
	 */
	private List<Request> receivedRequests;

	/**
	 * Creates a new Manager object with default values.
	 */
	public Manager(){
		receivedRequests = new ArrayList<>();
	}

	/**
	 * Creates a new Manager object with the specified manager type and faculty.
	 *
	 * @param managerType The manager's type.
	 * @param faculty     The faculty that the manager oversees (if applicable).
	 */
	public Manager(ManagerType managerType, Faculty faculty){
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = new ArrayList<>();
	}

	/**
	 * Creates a new Manager object with the specified manager type, faculty, and list of received requests.
	 *
	 * @param managerType  The manager's type.
	 * @param faculty      The faculty that the manager oversees (if applicable).
	 * @param receivedRequests A list of requests received by the manager.
	 */
	public Manager(ManagerType managerType, Faculty faculty, List<Request> receivedRequests){
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = receivedRequests;
	}

	/**
	 * Returns the manager's type.
	 *
	 * @return The ManagerType enum value representing the manager's type.
	 */
	public ManagerType getManagerType() {
		return managerType;
	}

	/**
	 * Returns the faculty that the manager oversees (if applicable).
	 *
	 * @return The Faculty enum value representing the faculty, or null if the manager is not associated with a specific faculty.
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	/**
	 * Returns a list of requests received by the manager.
	 *
	 * @return A List of Request objects representing the received requests.
	 */
	public List<Request> getReceivedRequests() {
		return receivedRequests;
	}

	/**
	 * Approves a student's registration for a course.
	 *
	 * @param student The Student object representing the student whose registration is to be approved.
	 */
	public void approveRegistration(Student student) {

	}

	/**
	 * Adds a course to the list of available courses for registration.
	 *
	 * @param course The Course object representing the course to be added.
	 */
	public void addCourseForRegistration(Course course){

	}

	/**
	 * Assigns a teacher to teach a specific course.
	 */
	public void assignCourse(){

	}

	/**
	 * Removes a student from a course.
	 */
	public void writeOutCourse(){

	}

	/**
	 * Displays information about the teachers within the manager's area of responsibility.
	 */
	public void viewInfoAboutTeachers() {
	}

	/**
	 * Displays information about the students within the manager's area of responsibility.
	 */
	public void viewInfoAboutStudents() {
	}

	/**
	 * Generates a statistical report about various aspects of the manager's area of responsibility (e.g., student enrollment, course completion rates).
	 */
	public void statisticalReport() {
	}

	/**
	 * Adds a news item to the university news feed.
	 */
	public void addNews() {

	}

	/**
	 * Removes a news item from the university news feed.
	 */
	public void removeNews(){

	}
}

