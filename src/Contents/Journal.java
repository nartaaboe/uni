package Contents;

import Enums.Attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Journal implements Serializable {

	private HashMap<Course, LinkedHashSet<Lesson>> points;
	private double allPoints;
	private int allAttends;
	private int allAbsents;
	public Journal(){
		points = new HashMap<>();
		allPoints = 0.0;
		allAttends = 0;
		allAbsents = 0;
	}

	public Journal(HashMap<Course, LinkedHashSet<Lesson>> points){
		this.points = points;
		this.allPoints = 0.0;
		this.allAttends = 0;
		this.allAbsents = 0;
	}
	public HashMap<Course, LinkedHashSet<Lesson>> getPoints() {
		return points;
	}
	public double getAllPoints(Course course){
		for(Map.Entry<Course, LinkedHashSet<Lesson>> entry : points.entrySet()){
			if(entry.getKey().equals(course)){
				for(Lesson lesson : entry.getValue()){
					allPoints += lesson.getPoint();
				}
			}
		}
		return allPoints;
	}
	public double getAllPoints(){
		return allPoints;
	}
	public void getAllAttendances(){
		System.out.println("Attended: " + allAttends + ", Absent: " + allAbsents);
	}
	public void showPoints() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter course name: ");
		String name = bf.readLine();
		int allLate = 0;
		for(Map.Entry<Course, LinkedHashSet<Lesson>> entry : points.entrySet()){
			if(entry.getKey().getName().equals(name)){
				int i = 0;
				for(Lesson lesson : entry.getValue()){
					i++;
					allPoints += lesson.getPoint();
					if(lesson.getAttendance() == Attendance.ATTENDED)
						allAttends++;
					else if(lesson.getAttendance() == Attendance.LATE)
						allLate++;
					else if(lesson.getAttendance() == Attendance.ABSENT)
						allAbsents++;
					System.out.println(i + " -> " + lesson);
				}
			}
		}
		allAbsents += (allLate / 2);
		bf.close();
	}

	public void showPoints(Course course) throws IOException {
		int allLate = 0;
		for(Map.Entry<Course, LinkedHashSet<Lesson>> entry : points.entrySet()){
			if(entry.getKey().equals(course)){
				int i = 0;
				for(Lesson lesson : entry.getValue()){
					i++;
					allPoints += lesson.getPoint();
					if(lesson.getAttendance() == Attendance.ATTENDED)
						allAttends++;
					else if(lesson.getAttendance() == Attendance.LATE)
						allLate++;
					else if(lesson.getAttendance() == Attendance.ABSENT)
						allAbsents++;
					System.out.println(i + " -> " + lesson);
				}
			}
		}
		allAbsents += (allLate / 2);
	}
}

