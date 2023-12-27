package Users ;

import Contents.Lesson;
import Contents.Mark;
import Contents.Pair;
import Database.Data;
import Enums.*;
import Message.Order;
import Message.Request;
import Users.Researcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Contents.Course;
import Message.Message;
import Utils.CustomExceptions.CourseNotFound;
import Utils.CustomExceptions.UserNotFound;

/**
 * Represents a teacher in the system, extending the Employee class and implementing the Researcher interface.
 *
 * <p>Teachers have a teacher title, assigned courses with enrolled students, a rating, and can perform actions
 * related to teaching and research.
 */
public class Teacher extends Employee implements Researcher, Serializable {

	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The teacher's title (e.g., Assistant Professor, Professor).
	 */
	private TeacherType teacherTitle;

	/**
	 * A map of courses taught by the teacher, with lists of students enrolled in each course.
	 */
	private HashMap<Course, List<Student>> courseWithStudents;

	/**
	 * The teacher's rating (e.g., based on student feedback).
	 */
	private double rate;

	/**
	 * Default constructor.
	 */
	public Teacher(){
		super();
	}

	/**
	 * Creates a new Teacher object with the specified details.
	 *
	 * @param userType the user type (always UserType.TEACHER)
	 * @param id the teacher's unique ID
	 * @param password the teacher's password
	 * @param username the teacher's username
	 * @param salary the teacher's salary
	 * @param teacherTitle the teacher's title
	 */
	public Teacher(UserType userType, String id, String password, String username, double salary, TeacherType teacherTitle) {
		super(userType, id, password, username, salary);
		this.teacherTitle = teacherTitle;
		this.courseWithStudents = new HashMap<>();
		this.rate = 0.0;

	}

	/**
	 * Creates a new Teacher object with the specified details.
	 *
	 * @param userType the user type (always UserType.TEACHER)
	 * @param id the teacher's unique ID
	 * @param password the teacher's password
	 * @param username the teacher's username

	 */
	public Teacher(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
		this.courseWithStudents = new HashMap<>();
		this.rate = 0.0;

	}

	/**
	 * Prints a list of students enrolled in each course taught by the teacher.
	 */
	public void viewStudents() {
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			System.out.println("students for " + entry.getKey());
			for(Student s : entry.getValue()){
				System.out.println(s);
			}
		}
	}

	/**
	 * Assigns courses and students to the teacher.
	 *
	 * @param courseWithStudents a map of courses and their associated students
	 */
	public void setCourseWithStudents(HashMap<Course, List<Student>> courseWithStudents) {
		this.courseWithStudents = courseWithStudents;
	}

	/**
	 * Allows the teacher to view a student's journal for a specific course.
	 *
	 * @return a Pair object containing the student and course
	 * @throws IOException if an error occurs while reading input
	 * @throws UserNotFound if the specified student or course is not found
	 */
	public Pair viewJournal() throws IOException, UserNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		Student s = null;
		Course c = null;
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)){
				c = entry.getKey();
				System.out.println("Enter student name: ");
				String studentName = bf.readLine();
				for(Student student : entry.getValue()){
					if(student.getUsername().equals(studentName)){
						student.getJournal().showPoints(c);
						s = student;
					}
				}
			} else
				throw new UserNotFound();
		}

		return new Pair(s, c);
	}

	/**
	 * Allows the teacher to add a point to a student's journal for a specific course.
	 *
	 * @throws IOException if an error occurs while reading input
	 * @throws CourseNotFound if the specified course is not found
	 * @throws UserNotFound if the specified student is not found
	 */
	public void putPoint() throws IOException, CourseNotFound, UserNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("What is id of student?");
		String id = bf.readLine();

		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)) {
				Course course = entry.getKey();
				for(Student student : entry.getValue()){
					if(student.getId().equals(id)){
						Double p = Double.parseDouble(bf.readLine());
						student.getJournal().getPoints().get(course).add(new Lesson(p));
						break;
					} else
						throw new UserNotFound();
				}
			} else
				throw  new CourseNotFound();
		}
	}

	/**
	 * Allows the teacher to add a point to a student's journal for a specific course,
	 * directly using the student and course objects.
	 *
	 * @param student the student to add the point for
	 * @param course the course for which to add the point
	 * @throws IOException if an error occurs while reading input
	 */
	public void putPoint(Student student, Course course) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter point: ");
		double p = Double.parseDouble(bf.readLine());
		student.getJournal().getPoints().get(course).add(new Lesson(p));

	}

	/**
	 * Allows the teacher to change a point in a student's journal for a specific course.
	 *
	 * @throws IOException if an error occurs while reading input
	 * @throws ParseException if an error occurs while parsing a date
	 */
	public void changePoint() throws IOException, ParseException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("What is id of student?");
		String id = bf.readLine();
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)) {
				Course course = entry.getKey();
				for(Student student : entry.getValue()){
					if(student.getId().equals(id)){
						break;
					}
				}
			}
		}

	}

	/**
	 * Allows the teacher to change a point in a student's journal for a specific course,
	 * directly using the student and course objects.
	 *
	 * @param student the student whose point to change
	 * @param course the course for which to change the point
	 */
	public void changePoint(Student student, Course course){
	}

	/**
	 * Allows the teacher to record a student's attendance for a specific lesson in a course.
	 *
	 * @throws IOException if an error occurs while reading input
	 * @throws CourseNotFound if the specified course is not found
	 * @throws UserNotFound if the specified student is not found
	 */
	public void putAttendance() throws IOException, CourseNotFound, UserNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("What is id of student?");
		String id = bf.readLine();
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)) {
				Course course = entry.getKey();
				for(Student student : entry.getValue()){
					if(student.getId().equals(id)){
						System.out.println("Choose lesson type: ");
						System.out.println("1 -> LECTURE");
						System.out.println("2 -> PRACTICE");
						System.out.println("3 -> LABORATORY");
						int n = Integer.parseInt(bf.readLine());
						LessonType lessonType;
						if(n == 1)
							lessonType = LessonType.LECTURE;
						else if(n == 2)
							lessonType = LessonType.PRACTICE;
						else if(n == 3)
							lessonType = LessonType.LABORATORY;
						else
							throw new IOException();
						System.out.println("Choose attendance: ");
						System.out.println("1 -> ATTENDED");
						System.out.println("2 -> ABSENT");
						System.out.println("3 -> LATE");
						n = Integer.parseInt(bf.readLine());
						Attendance attendance;
						if(n == 1)
							attendance = Attendance.ATTENDED;
						else if(n == 2)
							attendance = Attendance.ABSENT;
						else if(n == 3)
							attendance = Attendance.LATE;
						else
							throw new IOException();
						student.getJournal().getPoints().get(course).add(new Lesson(lessonType, attendance, 0.0));
					} else
						throw new UserNotFound();
				}
			} else
				throw new CourseNotFound();
		}

	}

	/**
	 * Records a student's attendance for a specific lesson in a course.
	 *
	 * @param student the student to record attendance for
	 * @param course the course for which to record attendance
	 * @throws IOException if an error occurs while reading input
	 * @throws CourseNotFound if the specified course is not found in the student's journal
	 */
	public void putAttendance(Student student, Course course) throws IOException, CourseNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		if(student.getJournal().getPoints().containsKey(course)){
			System.out.println("Choose lesson type: ");
			System.out.println("1 -> LECTURE");
			System.out.println("2 -> PRACTICE");
			System.out.println("3 -> LABORATORY");
			int n = Integer.parseInt(bf.readLine());
			LessonType lessonType;
			if(n == 1)
				lessonType = LessonType.LECTURE;
			else if(n == 2)
				lessonType = LessonType.PRACTICE;
			else if(n == 3)
				lessonType = LessonType.LABORATORY;
			else
				throw new IOException();
			System.out.println("Choose attendance: ");
			System.out.println("1 -> ATTENDED");
			System.out.println("2 -> ABSENT");
			System.out.println("3 -> LATE");
			n = Integer.parseInt(bf.readLine());
			Attendance attendance;
			if(n == 1)
				attendance = Attendance.ATTENDED;
			else if(n == 2)
				attendance = Attendance.ABSENT;
			else if(n == 3)
				attendance = Attendance.LATE;
			else
				throw new IOException();
			student.getJournal().getPoints().get(course).add(new Lesson(lessonType, attendance, 0.0));
		} else
			throw new CourseNotFound();

	}

	/**
	 * Changes a student's attendance record for a specific lesson in a course.
	 *
	 * @param student the student whose attendance to change
	 * @param course the course for which to change attendance
	 * @throws IOException if an error occurs while reading input
	 */
	public void changeAttendance(Student student, Course course) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a date (format: dd/MM/yyyy): ");
		String input = bf.readLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try{
			date = dateFormat.parse(input);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
//		student.getJournal().getPoints().put(course, )


	}

	/**
	 * Gets a map of courses with their associated lists of students.
	 *
	 * @return a map of courses and student lists
	 */
	public HashMap<Course, List<Student>> getCourseWithStudents() {
		return courseWithStudents;
	}

	/**
	 * Records attestation points for a student in a course.
	 *
	 * @throws IOException if an error occurs while reading input
	 */
	public void putAttestationPoints() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("Enter id of student: ");
		String id = bf.readLine();
		System.out.println("Which attestation?");
		System.out.println("1st or 2nd?");
		int n = Integer.parseInt(bf.readLine());
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)){
				for(Student student : entry.getValue()){
					if(student.getId().equals(id)){
						System.out.println("points from journal: " + student.getJournal().getAllPoints(entry.getKey()));
						if(n == 1){
							System.out.println("Enter first attestation point: ");
							double p = Double.parseDouble(bf.readLine());
							for(Mark mark : student.getTranscript().getMarks()){
								if(mark.getCourse().equals(entry.getKey())){
									mark.setAttestationFirst(p);
								}
							}
						} else if(n == 2){
							System.out.println("Enter second attestation point: ");
							double p = Double.parseDouble(bf.readLine());
							for(Mark mark : student.getTranscript().getMarks()){
								if(mark.getCourse().equals(entry.getKey())){
									mark.setAttestationSecond(p);
								}
							}
						} else
							throw new IOException();
					}
				}
			}
		}

	}

	/**
	 * Records the final exam mark for a student in a course.
	 *
	 * @throws IOException if an error occurs while reading input
	 */
	public void putFinalExamMark() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("Enter id of student: ");
		String id = bf.readLine();
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()) {
			if (entry.getKey().getName().equals(name)) {
				for (Student student : entry.getValue()) {
					if (student.getId().equals(id)) {
						double p = Double.parseDouble(bf.readLine());
						for(Mark mark : student.getTranscript().getMarks()){
							if(mark.getCourse().equals(entry.getKey())){
								mark.setFinalExam(p);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Prints a list of courses taught by the teacher.
	 */
	public void viewCourses() {
		int i = 0;
		for(Course course : courseWithStudents.keySet()){
			i++;
			System.out.println(i + " -> "  + course);
		}
	}

	/**
	 * Creates a new order for a student.
	 *
	 * @param student the student for whom the order is being created
	 * @return the new Order object
	 * @throws IOException if an error occurs while reading input
	 */
	private Order createOrder(Student student) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type description: ");
		String description = bf.readLine();
		System.out.println("Choose urgency level: ");
		System.out.println("1 -> LOW 2 -> MEDIUM 3 -> HIGH");
		int n = Integer.parseInt(bf.readLine());
		UrgencyLevel urgencyLevel;
		if (n == 1) {
			urgencyLevel = UrgencyLevel.LOW;
		} else if (n == 2) {
			urgencyLevel = UrgencyLevel.MEDIUM;
		} else {
			urgencyLevel = UrgencyLevel.HIGH;
		}

		return new Order(description, urgencyLevel, this, student);

	}

	/**
	 * Sends a complaint about a student.
	 *
	 * @throws IOException if an error occurs while reading input
	 */
	public void sendComplaint() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter student's name: ");
		String name = bf.readLine();
		for(List<Student> lst : courseWithStudents.values()){
			for(Student student : lst){
				if(student.getUsername().equals(name)){
					for(User user : Data.getInstance().getUsers()){
						if(user instanceof Dean && ((Dean) user).getFaculty().equals(student.getFaculty())){
							((Dean) user).getReceivedComplaints().add(createOrder(student));
							break;
						}
					}
					break;
				}
			}
		}

	}


	/**
	 * Sends a request to another employee.
	 *
	 * @param to the employee to whom the request is being sent
	 * @param request the Request object
	 */
	/**
	 * Implements the research-related methods from the Researcher interface.
	 */
	@Override
	public void conductResearch() {

	}

	/**
	 * Implements the research-related methods from the Researcher interface.
	 */
	@Override
	public int calculateHIndex() {
		return 0;
	}

	/**
	 * Implements the research-related methods from the Researcher interface.
	 */
	@Override
	public void printPapers(Comparator c) {

	}

	/**
	 * Implements the research-related methods from the Researcher interface.
	 */
	@Override
	public void shareResearchPaper(Researcher to) {

	}
}

