package Contents;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Transcript implements Serializable {
	private double overallGpa;
	private List<Mark> marks;

	public Transcript(){
		overallGpa = 0.0;
		marks = new ArrayList<>();
	}
	public Transcript(List<Mark> marks) {
		this.marks = marks;
		calculateGPA();
	}
	public void calculateGPA(){

	}
	public double getOverallGpa() {
		return overallGpa;
	}

	public List<Mark> getMarks() {
		return marks;
	}
}

