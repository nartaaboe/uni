package Contents;


import java.io.Serializable;

public class Mark implements Serializable {
	private Course course;
	private double attestationFirst;
	private double attestationSecond;
	private double finalExam;
	private double total;
	private boolean isPassed;
	public Mark(Course course){
		this.course = course;
		attestationFirst = 0.0;
		attestationSecond = 0.0;
		finalExam = 0.0;
		total = 0.0;
	}
	public Mark(Course course, double attestationFirst, double attestationSecond){
		this.course = course;
		this.attestationFirst = attestationFirst;
		this.attestationSecond = attestationSecond;
		this.finalExam = 0.0;
		this.total = attestationFirst + attestationSecond;
	}
	public Mark(Course course, double attestationFirst, double attestationSecond, double finalExam) {
		this.course = course;
		this.attestationFirst = attestationFirst;
		this.attestationSecond = attestationSecond;
		this.finalExam = finalExam;
		total = attestationFirst + attestationSecond + finalExam;
	}
	public boolean isPassedToFinal() {
		return (attestationFirst + attestationSecond) >= 29.5;
	}
	public boolean isPassedFinal() {
		return finalExam >= 19.5;
	}
	public double getAttestationFirst() {
		return attestationFirst;
	}
	public double getAttestationSecond() {
		return attestationSecond;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public double getTotal() {
		return total;
	}
	public boolean isPassed() {
		return isPassed;
	}

	public void setAttestationFirst(double attestationFirst) {
		this.attestationFirst = attestationFirst;
	}

	public void setAttestationSecond(double attestationSecond) {
		this.attestationSecond = attestationSecond;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public Course getCourse() {
		return course;
	}

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
	@Override
	public String toString(){
		return attestationFirst + ", " + attestationSecond + ", " + finalExam + ", " + getLetterGrade();
	}
}

