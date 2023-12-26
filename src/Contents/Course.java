package Contents;

import Enums.CourseType;
import Enums.Faculty;
import Users.User;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;

/**
 * A Course class representing a course within the system, containing details like code, name, prerequisites, type, credits, faculty, and mark.
 */
public class Course implements Serializable {

	/**
	 * The course code (e.g., "CS101").
	 */
	private String code;

	/**
	 * The course name (e.g., "Introduction to Programming").
	 */
	private String name;

	/**
	 * A set of Course objects representing the prerequisites for this course.
	 */
	private HashSet<Course> prerequisites;

	/**
	 * The type of the course (e.g., "Mandatory", "Elective").
	 */
	private CourseType courseType;

	/**
	 * The number of credits the course is worth.
	 */
	private int credits;

	/**
	 * The faculty to which the course belongs.
	 */
	private Faculty faculty;

	/**
	 * The Mark object representing the student's mark in this course (if applicable).
	 */
	private Mark mark;

	/**
	 * A static set containing all courses in the system.
	 */
	public static HashSet<Course> courses;

	/**
	 * A static initializer block that loads courses from the serialized file at startup.
	 */
	static {
		courses = loadCourses();
	}

	/**
	 * Creates a new Course object with default values.
	 */
	public Course() {

	}

	/**
	 * Creates a new Course object with the specified details.
	 *
	 * @param code The course code.
	 * @param name The course name.
	 * @param courseType The course type.
	 * @param credits The number of credits the course is worth.
	 * @param faculty The faculty to which the course belongs.
	 */
	public Course(String code, String name, CourseType courseType, int credits, Faculty faculty) {
		this.code = code;
		this.name = name;
		this.prerequisites = new HashSet<>();
		this.courseType = courseType;
		this.credits = credits;
		this.faculty = faculty;
		this.mark = new Mark();
	}

	/**
	 * Returns the course code.
	 *
	 * @return The course code (e.g., "CS101").
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns the course name.
	 *
	 * @return The course name (e.g., "Introduction to Programming").
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a set of Course objects representing the prerequisites for this course.
	 *
	 * @return A set of Course objects representing the prerequisites.
	 */
	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}

	/**
	 * Returns the type of the course.
	 *
	 * @return The CourseType enum value representing the course type (e.g., "Mandatory", "Elective").
	 */
	public CourseType getCourseType() {
		return courseType;
	}

	/**
	 * Returns the number of credits the course is worth.
	 *
	 * @return The number of credits.
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Returns the faculty to which the course belongs.
	 *
	 * @return The Faculty enum value representing the faculty.
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	/**
	 * Returns the Mark object representing the student's mark in this course (if applicable).
	 *
	 * @return The Mark object.
	 */
	public Mark getMark(){
		return mark;
	}

	/**
	 * Loads courses from a serialized file.
	 *
	 * @return A HashSet of Course objects representing the loaded courses.
	 */
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

	/**
	 * Saves courses to a serialized file.
	 *
	 * @throws Exception If an error occurs during file saving.
	 */
	public static void saveCourses() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/courses.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		fos.close();
		oos.close();
	}

	/**
	 * Returns a string representation of the Course object, including code, name, and course type.
	 *
	 * @return A string in the format "code name, courseType".
	 */
	@Override
	public String toString(){
		return code + name + ", " + courseType;
	}

	/**
	 * Determines whether two Course objects are equal based on their code, name, prerequisites, course type, credits, faculty, and mark.
	 *
	 * @param o The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Course course = (Course) o;
		return getCredits() == course.getCredits() && Objects.equals(getCode(), course.getCode()) && Objects.equals(getName(), course.getName()) && Objects.equals(getPrerequisites(), course.getPrerequisites()) && getCourseType() == course.getCourseType() && getFaculty() == course.getFaculty() && Objects.equals(getMark(), course.getMark());
	}

	/**
	 * Generates a hash code for the Course object based on its code, name, prerequisites, course type, credits, faculty, and mark.
	 *
	 * @return The hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getCode(), getName(), getPrerequisites(), getCourseType(), getCredits(), getFaculty(), getMark());
	}
}

