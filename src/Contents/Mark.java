package Contents;


import java.io.Serializable;

/**
 * A Mark class representing a student's marks in a course, including scores for attestations, the final exam,
 * the overall total, a passed/failed status, and a letter grade.
 */
public class Mark implements Serializable {

	/**
	 * The student's score for the first attestation.
	 */
	private double attestationFirst;

	/**
	 * The student's score for the second attestation.
	 */
	private double attestationSecond;

	/**
	 * The student's score for the final exam.
	 */
	private double finalExam;

	/**
	 * The student's overall total score, calculated as the sum of attestations and the final exam.
	 */
	private double total;

	/**
	 * Indicates whether the student has passed the course based on the total score.
	 */
	private boolean isPassed;

	/**
	 * Creates a new Mark object with default scores.
	 */
	public Mark(){
	}

	/**
	 * Creates a new Mark object with the specified scores.
	 *
	 * @param attestationFirst The student's score for the first attestation.
	 * @param attestationSecond The student's score for the second attestation.
	 * @param finalExam The student's score for the final exam.
	 */
	public Mark(double attestationFirst, double attestationSecond, double finalExam) {
		this.attestationFirst = attestationFirst;
		this.attestationSecond = attestationSecond;
		this.finalExam = finalExam;
		total = attestationFirst + attestationSecond + finalExam;
	}

	/**
	 * Indicates whether the student has earned a sufficient score in attestations to qualify for the final exam.
	 *
	 * @return True if the combined attestation score is at least 29.5, false otherwise.
	 */
	public boolean isPassedToFinal() {
		return (attestationFirst + attestationSecond) >= 29.5;
	}

	/**
	 * Indicates whether the student has passed the final exam based on the final exam score.
	 *
	 * @return True if the final exam score is at least 19.5, false otherwise.
	 */

	public boolean isPassedFinal() {
		return finalExam >= 19.5;
	}

	/**
	 * Returns the student's score for the first attestation.
	 *
	 * @return The score for the first attestation.
	 */
	public double getAttestationFirst() {
		return attestationFirst;
	}

	/**
	 * Returns the student's score for the second attestation.
	 *
	 * @return The score for the second attestation.
	 */
	public double getAttestationSecond() {
		return attestationSecond;
	}

	/**
	 * Returns the student's score for the final exam.
	 *
	 * @return The score for the final exam.
	 */
	public double getFinalExam() {
		return finalExam;
	}

	/**
	 * Returns the student's overall total score, calculated as the sum of attestations and the final exam.
	 *
	 * @return The overall total score.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Indicates whether the student has passed the course based on the total score.
	 *
	 * @return True if the student has passed, false otherwise.
	 */
	public boolean isPassed() {
		return isPassed;
	}

	/**
	 * Sets the student's score for the first attestation.
	 *
	 * @param attestationFirst The new score for the first attestation.
	 */
	public void setAttestationFirst(double attestationFirst) {
		this.attestationFirst = attestationFirst;
	}

	/**
	 * Sets the student's score for the second attestation.
	 *
	 * @param attestationSecond The new score for the second attestation.
	 */
	public void setAttestationSecond(double attestationSecond) {
		this.attestationSecond = attestationSecond;
	}

	/**
	 * Sets the student's score for the final exam.
	 *
	 * @param finalExam The new score for the final exam.
	 */
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	/**
	 * Calculates and returns the student's letter grade based on the overall total score.
	 *
	 * @return The letter grade (A, B, C, D, or F).
	 */
	public Character getLetterGrade(){
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
	 * Returns a string representation of the Mark object, including attestation scores, final exam score, and letter grade.
	 *
	 * @return A string in the format "attestation1, attestation2, finalExam, letterGrade".
	 */
	@Override
	public String toString(){
		return attestationFirst + ", " + attestationSecond + ", " + finalExam + ", " + getLetterGrade();
	}
}

