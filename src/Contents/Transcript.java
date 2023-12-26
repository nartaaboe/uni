package Contents;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Transcript implements Serializable {
	private double overallGpa;
	private LinkedHashMap<Course, Mark> marks;

	public Transcript(){
		overallGpa = 0.0;
		marks = new LinkedHashMap<>();
	}

	public Transcript(LinkedHashMap<Course, Mark> marks) {
		this.marks = marks;
		calculateGPA();
	}

	public void calculateGPA(){
		for(Map.Entry<Course, Mark> entry : marks.entrySet()){

		}
	}
	public double getOverallGpa() {
		return overallGpa;
	}

	public LinkedHashMap<Course, Mark> getMarks() {
		return marks;
	}
}

