package Utils.Comparatots;

import Users.Student;

import java.util.Comparator;

/**
 * This class implements a comparator for students, sorting them by their names in alphabetical order.
 */
public class TranscriptComparatorByAlphabetical implements Comparator<Student> {

	/**
	 * Compares two students by their names.
	 *
	 * @param o1 The first student to compare.
	 * @param o2 The second student to compare.
	 * @return A negative integer if the first student should come before the second, a positive integer if the second student should come before the first, or zero if the two students are equal.
	 */
	@Override
	public int compare(Student o1, Student o2) {
		String name1 = o1.getName();
	        String name2 = o2.getName();
	        return name1.compareTo(name2);
	}
}

