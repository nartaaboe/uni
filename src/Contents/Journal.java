package Contents;

import Enums.Attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

/**
 * A Journal class representing a student's academic journal, containing course-specific scores, attendance, and overall performance data.
 */
public class Journal implements Serializable {
	/**
	 * A HashMap storing lesson scores for each course, organized by Course objects as keys and LinkedHashSets of Lesson objects as values.
	 */
	private HashMap<Course, LinkedHashSet<Lesson>> points;

	/**
	 * The total earned points across all courses.
	 */
	private double allPoints;

	/**
	 * The total number of attended lessons across all courses.
	 */
	private int allAttends;

	/**
	 * The total number of absent lessons (including late attendances) across all courses.
	 */
	private int allAbsents;

	/**
	 * Creates a new Journal object with empty scores.
	 */
	public Journal(){
		points = new HashMap<>();
		allPoints = 0.0;
		allAttends = 0;
		allAbsents = 0;
	}

	/**
	 * Creates a new Journal object with the provided scores.
	 *
	 * @param points A HashMap containing initial course-specific lesson scores.
	 */
	public Journal(HashMap<Course, LinkedHashSet<Lesson>> points){
		this.points = points;
		this.allPoints = 0.0;
		this.allAttends = 0;
		this.allAbsents = 0;
	}

	/**
	 * Returns a HashMap containing lesson scores for each course, organized by Course objects as keys and LinkedHashSets of Lesson objects as values.
	 *
	 * @return A HashMap of course-specific lesson scores.
	 */
	public HashMap<Course, LinkedHashSet<Lesson>> getPoints() {
		return points;
	}

	/**
	 * Calculates and returns the total earned points for a specific course.
	 *
	 * @param course The Course object for which to calculate total points.
	 * @return The total earned points for the specified course.
	 */
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

	/**
	 * Returns the total earned points across all courses.
	 *
	 * @return The total earned points across all courses.
	 */
	public double getAllPoints(){
		return allPoints;
	}

	/**
	 * Prints a summary of overall attendance statistics, including attended and absent lessons.
	 */
	public void getAllAttendances(){
		System.out.println("Attended: " + allAttends + ", Absent: " + allAbsents);
	}

	/**
	 * Prompts the user to enter a course name, calculates and displays scores for each lesson in that course,
	 * and updates overall attendance statistics.
	 *
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
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
		
	}

	/**
	 * Displays scores for each lesson in a specific course and updates overall attendance statistics.
	 *
	 * @param course The Course object for which to display scores.
	 * @throws IOException If an I/O error occurs while reading user input.
	 */

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

