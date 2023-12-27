package Contents;

import java.io.Serializable;

/**
 * The Mark class represents the assessment and grading information for a course.
 * It includes attestation scores, a final exam score, total score, and whether the student passed.
 */
public class Mark implements Serializable {
	private Course course;
	private double attestationFirst;
	private double attestationSecond;
	private double finalExam;
	private double total;
	private boolean isPassed;

	/**
	 * Constructor for creating a Mark object with default scores.
	 *
	 * @param course The course for which the assessment is recorded.
	 */
	public Mark(Course course) {
		this.course = course;
		attestationFirst = 0.0;
		attestationSecond = 0.0;
		finalExam = 0.0;
		total = 0.0;
	}

	/**
	 * Constructor for creating a Mark object with specified attestation scores.
	 *
	 * @param course           The course for which the assessment is recorded.
	 * @param attestationFirst The first attestation score.
	 * @param attestationSecond The second attestation score.
	 */
	public Mark(Course course, double attestationFirst, double attestationSecond) {
		this.course = course;
		this.attestationFirst = attestationFirst;
		this.attestationSecond = attestationSecond;
		this.finalExam = 0.0;
		this.total = attestationFirst + attestationSecond;
	}

	/**
	 * Constructor for creating a Mark object with specified attestation and final exam scores.
	 *
	 * @param course           The course for which the assessment is recorded.
	 * @param attestationFirst The first attestation score.
	 * @param attestationSecond The second attestation score.
	 * @param finalExam        The final exam score.
	 */
	public Mark(Course course, double attestationFirst, double attestationSecond, double finalExam) {
		this.course = course;
		this.attestationFirst = attestationFirst;
		this.attestationSecond = attestationSecond;
		this.finalExam = finalExam;
		total = attestationFirst + attestationSecond + finalExam;
	}

	/**
	 * Checks if the student has passed to the final exam based on attestation scores.
	 *
	 * @return true if passed to the final exam, false otherwise.
	 */
	public boolean isPassedToFinal() {
		return (attestationFirst + attestationSecond) >= 29.5;
	}

	/**
	 * Checks if the student has passed the final exam.
	 *
	 * @return true if passed the final exam, false otherwise.
	 */
	public boolean isPassedFinal() {
		return finalExam >= 19.5;
	}

	/**
	 * Gets the first attestation score.
	 *
	 * @return The first attestation score.
	 */
	public double getAttestationFirst() {
		return attestationFirst;
	}

	/**
	 * Gets the second attestation score.
	 *
	 * @return The second attestation score.
	 */
	public double getAttestationSecond() {
		return attestationSecond;
	}

	/**
	 * Gets the final exam score.
	 *
	 * @return The final exam score.
	 */
	public double getFinalExam() {
		return finalExam;
	}

	/**
	 * Gets the total score.
	 *
	 * @return The total score.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Checks if the student has passed the course.
	 *
	 * @return true if passed, false otherwise.
	 */
	public boolean isPassed() {
		return isPassed;
	}

	/**
	 * Sets the first attestation score.
	 *
	 * @param attestationFirst The first attestation score to set.
	 */
	public void setAttestationFirst(double attestationFirst) {
		this.attestationFirst = attestationFirst;
	}

	/**
	 * Sets the second attestation score.
	 *
	 * @param attestationSecond The second attestation score to set.
	 */
	public void setAttestationSecond(double attestationSecond) {
		this.attestationSecond = attestationSecond;
	}

	/**
	 * Sets the final exam score.
	 *
	 * @param finalExam The final exam score to set.
	 */
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	/**
	 * Gets the course associated with this mark.
	 *
	 * @return The course associated with this mark.
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Gets the letter grade based on the total score.
	 *
	 * @return The letter grade.
	 */
	public Character getLetterGrade() {
		if (total >= 90) {
			return 'A';
		} else if (total >= 80) {
			return 'B';
		} else if (total >= 70) {
			return 'C';
		} else if (total >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

	/**
	 * Returns a string representation of the Mark object.
	 *
	 * @return A string containing attestation scores, final exam score, and letter grade.
	 */
	@Override
	public String toString() {
		return attestationFirst + ", " + attestationSecond + ", " + finalExam + ", " + getLetterGrade();
	}
}
