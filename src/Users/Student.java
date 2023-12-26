package Users ;


import Contents.Course;
import Contents.Journal;
import Contents.Mark;
import Contents.Transcript;
import Enums.Faculty;
import Enums.UserType;
import Users.Researcher;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a student in the system, extending the User class and implementing the Researcher interface.
 *
 * <p>Students have a faculty, year of study, enrolled courses, a journal, a transcript, and can perform actions
 * related to their academic progress.
 */
public class Student extends User implements Researcher, Serializable {


	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The student's faculty.
	 */
	private Faculty faculty;

	/**
	 * The student's journal, containing academic records and notes.
	 */
	private Journal journal;

	/**
	 * A map of courses the student is enrolled in, associated with the teachers for each course.
	 */
	private HashMap<Teacher, Course> teacherCourse;

	/**
	 * The student's current year of study.
	 */
	private int yearOfStudy;

	/**
	 * The student's transcript, containing grades and academic performance.
	 */
	private Transcript transcript;

	/**
	 * Default constructor for creating a Student object.
	 */
	public Student(){
	}

	/**
	 * Constructor for creating a Student object with detailed information.
	 *
	 * @param userType     the student's user type
	 * @param id           the student's ID
	 * @param password     the student's password
	 * @param username     the student's username
	 * @param faculty      the student's faculty
	 * @param yearOfStudy  the student's year of study
	 * @param teacherCourse a map of courses and teachers
	 * @param journal      the student's journal
	 * @param transcript   the student's transcript
	 */
	public Student(UserType userType, String id, String password, String username, Faculty faculty,
				   int yearOfStudy, HashMap<Teacher, Course> teacherCourse, Journal journal, Transcript transcript) {
		super(userType, id, password, username);
		this.faculty = faculty;
		this.teacherCourse = teacherCourse;
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.transcript = transcript;
	}

	/**
	 * Constructor for creating a Student object with basic information.
	 *
	 * @param userType the student's user type
	 * @param id       the student's ID
	 * @param password the student's password
	 * @param username the student's username
	 */
	public Student(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
	}


	/**
	 * Gets the student's journal.
	 *
	 * @return the student's journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * Prints a list of courses the student is enrolled in.
	 */
	public void viewCourses() {
		int i = 0;
		for(Map.Entry<Teacher, Course> entry : teacherCourse.entrySet()){
			i++;
			System.out.println(i + " -> " + entry.getValue());
		}
	}

	/**
	 * Registers the student for a course with a specific teacher.
	 *
	 * @param teacher the teacher for the course
	 * @param course  the course to register for
	 */
	public void registerForCourses(Teacher teacher, Course course) {

	}

	/**
	 * Prints a list of marks for each course, along with the corresponding grades.
	 */
	public void viewMarks() {
		int i = 0;
		for(Map.Entry<Course, Mark> entry : transcript.getMarks().entrySet()){
			i++;
			System.out.println(i + " -> " + entry.getKey() + ": " + entry.getValue());
		}
	}

	/**
	 * Prints the student's transcript, including marks, grades, and overall GPA.
	 */
	public void viewTranscript() {
		viewMarks();
		System.out.println("gpa -> " + transcript.getOverallGpa());
	}

	/**
	 * Displays the contents of the student's journal.
	 *
	 * @throws IOException if an error occurs while accessing the journal
	 */
	public void viewJournal() throws IOException {
		getJournal().showPoints();
	}

	/**
	 * Allows the student to rate their teachers.
	 *
	 * @implSpec Not yet implemented.
	 */
	public void rateTeachers() {
		// TODO implement me
	}

	/**
	 * Returns the student's transcript.
	 *
	 * @return the student's transcript
	 */
	public Transcript getTranscript() {
		return transcript;
	}

	/**
	 * Gets the student's overall GPA.
	 *
	 * @return the student's GPA
	 */
	public double getGpa() {
		return 0.0;
	}

	/**
	 * Records the student's attendance for a specific course or activity.
	 *
	 * @implSpec Not yet implemented.
	 */
	public void putAttendance() {
		// TODO implement me
	}

	/**
	 * Allows the student to conduct research activities.
	 *
	 * @implSpec Not yet implemented.
	 */
	@Override
	public void conductResearch() {

	}

	/**
	 * Calculates the student's h-index, a metric for measuring research impact.
	 *
	 * @return the student's h-index
	 */
	@Override
	public int calculateHIndex() {
		return 0;
	}

	/**
	 * Prints a list of the student's research papers sorted using a specific comparator.
	 *
	 * @param c the comparator to use for sorting
	 */
	@Override
	public void printPapers(Comparator c) {

	}

	/**
	 * Shares a research paper with another researcher.
	 *
	 * @param to the researcher to share the paper with
	 */
	@Override
	public void shareResearchPaper(Researcher to) {

	}

	/**
	 * Gets the student's faculty.
	 *
	 * @return the student's faculty
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	/**
	 * Gets a map of courses and the teachers who teach them for the student.
	 *
	 * @return a map of teachers and courses
	 */
	public HashMap<Teacher, Course> getTeacherCourse() {
		return teacherCourse;
	}

	/**
	 * Gets the student's current year of study.
	 *
	 * @return the student's year of study
	 */
	public int getYearOfStudy() {
		return yearOfStudy;
	}

	/**
	 * Returns a string representation of the student, including their name, ID, and faculty.
	 *
	 * @return a string representation of the student
	 */
	@Override
	public String toString() {
		return "name: " + getUsername() + ", ID: " + getId() + ", faculty: " + getFaculty();
	}
}

