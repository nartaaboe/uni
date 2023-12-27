package Contents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Transcript class represents a student's academic transcript containing a list of marks.
 * It includes functionality to calculate the overall GPA based on the marks.
 */
public class Transcript implements Serializable {
	private double overallGpa;
	private List<Mark> marks;

	/**
	 * Default constructor to create an empty Transcript object.
	 */
	public Transcript() {
		overallGpa = 0.0;
		marks = new ArrayList<>();
	}

	/**
	 * Constructor to create a Transcript object with a pre-existing list of marks.
	 * Calculates the overall GPA based on the provided marks.
	 *
	 * @param marks The list of marks to be included in the transcript.
	 */
	public Transcript(List<Mark> marks) {
		this.marks = marks;
		calculateGPA();
	}

	/**
	 * Calculates the overall GPA based on the marks in the transcript.
	 * This method should be called after adding or modifying marks.
	 */
	public void calculateGPA() {
		// TODO: Implement GPA calculation logic
	}

	/**
	 * Gets the overall GPA from the transcript.
	 *
	 * @return The overall GPA.
	 */
	public double getOverallGpa() {
		return overallGpa;
	}

	/**
	 * Gets the list of marks in the transcript.
	 *
	 * @return The list of marks.
	 */
	public List<Mark> getMarks() {
		return marks;
	}
}
