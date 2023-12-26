package Contents;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A Transcript class representing a student's academic transcript, containing course-specific marks and overall GPA.
 */
public class Transcript implements Serializable {

	/**
	 * The student's overall grade point average (GPA).
	 */
	private double overallGpa;

	/**
	 * A LinkedHashMap storing Course objects as keys and corresponding Mark objects as values.
	 */
	private LinkedHashMap<Course, Mark> marks;

	/**
	 * Creates a new Transcript object with empty marks and initializes the overall GPA to 0.0.
	 */

	public Transcript(){
		overallGpa = 0.0;
		marks = new LinkedHashMap<>();
	}

	/**
	 * Creates a new Transcript object with the provided marks and calculates the overall GPA.
	 *
	 * @param marks A LinkedHashMap containing initial course-specific Mark objects.
	 */
	public Transcript(LinkedHashMap<Course, Mark> marks) {
		this.marks = marks;
		calculateGPA();
	}

	/**
	 * Calculates the overall GPA based on the marks in each course.
	 */
	public void calculateGPA(){
		for(Map.Entry<Course, Mark> entry : marks.entrySet()){

		}
	}

	/**
	 * Returns the student's overall GPA.
	 *
	 * @return The overall GPA.
	 */
	public double getOverallGpa() {
		return overallGpa;
	}

	/**
	 * Returns a LinkedHashMap containing course-specific marks.
	 *
	 * @return A LinkedHashMap of Course objects as keys and Mark objects as values.
	 */
	public LinkedHashMap<Course, Mark> getMarks() {
		return marks;
	}
}

