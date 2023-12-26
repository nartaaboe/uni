package Utils.Comparatots;

import Users.Student;

import java.util.Comparator;

public class TranscriptComparatorByGPA implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		double gpa1 = o1.getGpa();
	        double gpa2 = o2.getGpa();
	        return Double.compare(gpa1, gpa2);
	}
}

