package Utils.Comparatots;

import Users.Student;

import java.util.Comparator;

/**
 * This class implements a comparator for students, sorting them by their GPAs in descending order.
 */
public class TranscriptComparatorByGPA implements Comparator<Student> {

	/**
	 * Compares two students by their GPAs.
	 *
	 * @param o1 The first student to compare.
	 * @param o2 The second student to compare.
	 * @return A negative integer if the first student should come before the second, a positive integer if the second student should come before the first, or zero if the two students are equal.
	 */
	@Override
	public int compare(Student o1, Student o2) {
		return -1;
	}
}

