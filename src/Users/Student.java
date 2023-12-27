package Users ;


import Contents.*;
import Database.Data;
import Enums.Attendance;
import Enums.Faculty;
import Enums.LessonType;
import Enums.UserType;
import Users.Researcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Student extends User implements Researcher, Serializable {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	private Journal journal;
	private HashMap<Teacher, Course> teacherCourse;
	private int yearOfStudy;
	private Transcript transcript;

	public Student(){
	}

	public Student(UserType userType, String id, String password, String username, Faculty faculty,
				   int yearOfStudy, HashMap<Teacher, Course> teacherCourse, Journal journal, Transcript transcript) {
		super(userType, id, password, username);
		this.faculty = faculty;
		this.teacherCourse = teacherCourse;
		this.yearOfStudy = yearOfStudy;
		this.journal = journal;
		this.transcript = transcript;
	}

	public Student(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
	}

	public Journal getJournal() {
		return journal;
	}

	public void viewCourses() {
		int i = 0;
		for(Map.Entry<Teacher, Course> entry : teacherCourse.entrySet()){
			i++;
			System.out.println(i + " -> " + entry.getValue());
		}
	}

	public void viewMarks() {
		int i = 0;
		for(Mark mark : getTranscript().getMarks()){
			i++;
			System.out.println(i + " -> " + mark);
		}
	}

	public void viewTranscript() {
		viewMarks();
		System.out.println("gpa -> " + transcript.getOverallGpa());
	}

	public void viewJournal() throws IOException {
		getJournal().showPoints();
	}

	public void registerForCourses() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose course to register in: ");
		ListIterator<Course> iterator = (ListIterator<Course>) Data.getInstance().getCourses().iterator();
		Course course = iterator.next();
		while(true){
			System.out.println("1 -> Register");
			System.out.println("2 -> Next");
			System.out.println("3 -> Previous");
			System.out.println("4 -> Leave");
			int n = Integer.parseInt(bf.readLine());
			if(n == 1){
				
			}
		}
	}

	public void rateTeachers() {

	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void getGpa() {
		System.out.println(getTranscript().getOverallGpa());
	}

	/**
	 * Allows the user to record attendance for a specific course and lesson type.
	 * The user is prompted to enter the course name and then choose the lesson type (Lecture, Practice, or Laboratory).
	 * Based on the chosen type, a new Lesson object is added to the corresponding lesson set in the user's journal.
	 * The attendance status is set to ATTENDED for Practice and Laboratory lessons.
	 *
	 * @throws IOException If an I/O error occurs while reading input.
	 */
	public void putAttendance() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		for(Map.Entry<Course, LinkedHashSet<Lesson>> entry : getJournal().getPoints().entrySet()){
			if(entry.getKey().getName().equals(name)){
				LinkedHashSet<Lesson> lst = entry.getValue();
				System.out.println("Choose one: ");
				System.out.println("1 -> Lecture");
				System.out.println("2 -> Practice");
				System.out.println("3 -> Laboratory");
				int n = Integer.parseInt(bf.readLine());
				if(n == 1)
					lst.add(new Lesson());
				else if(n == 2)
					lst.add(new Lesson(LessonType.PRACTICE, Attendance.ATTENDED));
				else if(n == 3)
					lst.add(new Lesson(LessonType.LABORATORY, Attendance.ATTENDED));
				getJournal().getPoints().put(entry.getKey(), lst);
				break;
			}
		}
	}

	@Override
	public void conductResearch() {

	}

	@Override
	public int calculateHIndex() {
		return 0;
	}

	@Override
	public void printPapers(Comparator c) {

	}

	@Override
	public void shareResearchPaper(Researcher to) {

	}

	public Faculty getFaculty() {
		return faculty;
	}

	public HashMap<Teacher, Course> getTeacherCourse() {
		return teacherCourse;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	@Override
	public String toString() {
		return "name: " + getUsername() + ", ID: " + getId() + ", faculty: " + getFaculty();
	}
}

