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

	public void registerForCourses(Teacher teacher, Course course) {

	}

	public void viewMarks() {
		int i = 0;
		for(Map.Entry<Course, Mark> entry : transcript.getMarks().entrySet()){
			i++;
			System.out.println(i + " -> " + entry.getKey() + ": " + entry.getValue());
		}
	}

	public void viewTranscript() {
		viewMarks();
		System.out.println("gpa -> " + transcript.getOverallGpa());
	}

	public void viewJournal() throws IOException {
		getJournal().showPoints();
	}

	public void rateTeachers() {
		// TODO implement me
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public double getGpa() {
		return 0.0;
	}

	public void putAttendance() {
		// TODO implement me
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

