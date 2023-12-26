package Users ;

import Contents.Lesson;
import Contents.Pair;
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

public class Teacher extends Employee implements Researcher, Serializable {
	private static final long serialVersionUID = 1L;
	private TeacherType teacherTitle;
	private HashMap<Course, List<Student>> courseWithStudents;

	private double rate;

	public Teacher(){
		super();
	}

	public Teacher(UserType userType, String id, String password, String username, double salary, TeacherType teacherTitle) {
		super(userType, id, password, username, salary);
		this.teacherTitle = teacherTitle;
		this.courseWithStudents = new HashMap<>();
		this.rate = 0.0;

	}

	public void viewStudents() {
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			System.out.println("students for " + entry.getKey());
			for(Student s : entry.getValue()){
				System.out.println(s);
			}
		}
	}

	public void setCourseWithStudents(HashMap<Course, List<Student>> courseWithStudents) {
		this.courseWithStudents = courseWithStudents;
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			for(Student s : entry.getValue()){
				s.registerForCourses(this, entry.getKey());
			}
		}
	}

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

	public void putPoint(Student student, Course course) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter point: ");
		double p = Double.parseDouble(bf.readLine());
		student.getJournal().getPoints().get(course).add(new Lesson(p));
		
	}

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

	public void changePoint(Student student, Course course){
	}

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

	public HashMap<Course, List<Student>> getCourseWithStudents() {
		return courseWithStudents;
	}

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
							student.getTranscript().getMarks().get(entry.getKey()).setAttestationFirst(p);
						} else if(n == 2){
							System.out.println("Enter second attestation point: ");
							double p = Double.parseDouble(bf.readLine());
							student.getTranscript().getMarks().get(entry.getKey()).setAttestationSecond(p);
						} else
							throw new IOException();
					}
				}
			}
		}
		
	}

	public void putFinalExamMark() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		System.out.println("Enter id of student: ");
		String id = bf.readLine();
		for(Map.Entry<Course, List<Student>> entry : courseWithStudents.entrySet()){
			if(entry.getKey().getName().equals(name)){
				for(Student student : entry.getValue()){
					if(student.getId().equals(id)){
						double p = Double.parseDouble(bf.readLine());
						student.getTranscript().getMarks().get(entry.getKey()).setFinalExam(p);
					}
				}
			}
		}
		
	}

	public void viewCourses() {
		int i = 0;
		for(Course course : courseWithStudents.keySet()){
			i++;
			System.out.println(i + " -> "  + course);
		}
	}

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

	public void sendComplaint() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String name = bf.readLine();
		for(List<Student> lst : courseWithStudents.values()){
			for(Student student : lst){
				if(student.getUsername().equals(name)){

				}
			}
		}
		
	}

	public void sendRequest(Employee to, Request request) {
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
}

