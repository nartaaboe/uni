package Contents;

import Enums.CourseType;
import Enums.Faculty;
import Users.User;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;

public class Course implements Serializable {
	private String code;
	private String name;
	private HashSet<Course> prerequisites;
	private CourseType courseType;
	private int credits;
	private Faculty faculty;
	private Mark mark;

	public static HashSet<Course> courses;

	static {
		courses = loadCourses();
	}

	public Course() {

	}
	public Course(String code, String name, CourseType courseType, int credits, Faculty faculty) {
		this.code = code;
		this.name = name;
		this.prerequisites = new HashSet<>();
		this.courseType = courseType;
		this.credits = credits;
		this.faculty = faculty;
		this.mark = new Mark();
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public int getCredits() {
		return credits;
	}

	public Faculty getFaculty() {
		return faculty;
	}
	public Mark getMark(){
		return mark;
	}

	private static HashSet<Course> loadCourses() {
		File file = new File("db/courses.ser");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				return (HashSet<Course>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<>();
	}

	public static void saveCourses() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/courses.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		fos.close();
		oos.close();
	}


	@Override
	public String toString(){
		return code + name + ", " + courseType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Course course = (Course) o;
		return getCredits() == course.getCredits() && Objects.equals(getCode(), course.getCode()) && Objects.equals(getName(), course.getName()) && Objects.equals(getPrerequisites(), course.getPrerequisites()) && getCourseType() == course.getCourseType() && getFaculty() == course.getFaculty() && Objects.equals(getMark(), course.getMark());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCode(), getName(), getPrerequisites(), getCourseType(), getCredits(), getFaculty(), getMark());
	}
}

