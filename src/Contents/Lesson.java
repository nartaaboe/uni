package Contents;

import Enums.Attendance;
import Enums.LessonType;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A Lesson class representing a single lesson within a course, containing details like type, attendance, date, duration, and points.
 */
public class Lesson implements Serializable {
	/**
	 * The duration of the lesson in hours.
	 */
	private int duration;

	/**
	 * The type of the lesson (lecture or practice).
	 */
	private LessonType lessonType;

	/**
	 * The attendance status of the student for this lesson.
	 */
	private Attendance attendance;

	/**
	 * The points earned by the student in this lesson (for practice lessons).
	 */
	private double point;

	/**
	 * The date when the lesson took place.
	 */

	private Date date;

	/**
	 * Creates a new Lesson object with default values:
	 * - Lesson type: Lecture
	 * - Attendance: Attended
	 * - Date: Current date
	 * - Duration: 2 hours
	 * - Point: 0.0
	 */
	public Lesson(){
		this.lessonType = LessonType.LECTURE;
		this.attendance = Attendance.ATTENDED;
		this.date = new Date();
		this.duration = 2;
		this.point = 0.0;
	}

	/**
	 * Creates a new Lesson object with specified lesson type and attendance.
	 *
	 * @param lessonType The type of the lesson (lecture or practice).
	 * @param attendance The attendance status of the student for this lesson.
	 */
	public Lesson(LessonType lessonType, Attendance attendance){
		this.lessonType = lessonType;
		this.attendance = attendance;
		this.date = new Date();
		if(lessonType == LessonType.LECTURE)
			this.duration = 2;
		else
			this.duration = 1;
		this.point = 0.0;
	}

	/**
	 * Creates a new practice Lesson object with the specified point earned.
	 *
	 * @param point The points earned by the student in this practice lesson.
	 */
	public Lesson(double point){
		this.lessonType = LessonType.PRACTICE;
		this.attendance = Attendance.ATTENDED;
		this.date = new Date();
		this.duration = 1;
		this.point = point;
	}

	/**
	 * Creates a new Lesson object with specified lesson type, attendance, and point earned.
	 *
	 * @param lessonType The type of the lesson (lecture or practice).
	 * @param attendance The attendance status of the student for this lesson.
	 * @param point The points earned by the student in this practice lesson (if applicable).
	 */
	public Lesson(LessonType lessonType, Attendance attendance, double point){
		this.lessonType = lessonType;
		this.attendance = attendance;
		this.date = new Date();
		if(lessonType == LessonType.LECTURE)
			this.duration = 2;
		else
			this.duration = 1;
		this.point = point;
	}

	/**
	 * Creates a new Lesson object with specified lesson type, attendance, and date.
	 *
	 * @param lessonType The type of the lesson (lecture or practice).
	 * @param attendance The attendance status of the student for this lesson.
	 * @param date The date when the lesson took place.
	 */
	public Lesson(LessonType lessonType, Attendance attendance, Date date){
		this.lessonType = lessonType;
		this.attendance = attendance;
		this.date = date;
		if(lessonType == LessonType.LECTURE)
			this.duration = 2;
		else
			this.duration = 1;
		this.point = 0.0;
	}

	/**
	 * Creates a new Lesson object with all details specified.
	 *
	 * @param lessonType The type of the lesson (lecture or practice).
	 * @param attendance The attendance status of the student for this lesson.
	 * @param date The date when the lesson took place.
	 * @param point The points earned by the student in this practice lesson (if applicable).
	 */
	public Lesson(LessonType lessonType, Attendance attendance, Date date, double point) {
		this.lessonType = lessonType;
		this.attendance = attendance;
		this.date = date;
		if(lessonType == LessonType.LECTURE)
			this.duration = 2;
		else
			this.duration = 1;
		this.point = point;
	}

	/**
	 * Returns the duration of the lesson in hours.
	 *
	 * @return The duration of the lesson.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Returns the type of the lesson (lecture or practice).
	 *
	 * @return The LessonType enum value representing the lesson type.
	 */
	public LessonType getLessonType() {
		return lessonType;
	}

	/**
	 * Returns the attendance status of the student for this lesson.
	 *
	 * @return The Attendance enum value representing the attendance status.
	 */
	public Attendance getAttendance() {
		return attendance;
	}

	/**
	 * Returns the date when the lesson took place.
	 *
	 * @return The Date object representing the lesson date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the duration of the lesson in hours.
	 *
	 * @param duration The new duration of the lesson.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Sets the type of the lesson (lecture or practice).
	 *
	 * @param lessonType The LessonType enum value representing the new lesson type.
	 */
	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	/**
	 * Sets the attendance status of the student for this lesson.
	 *
	 * @param attendance The Attendance enum value representing the new attendance status.
	 */
	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	/**
	 * Sets the date when the lesson took place.
	 *
	 * @param date The Date object representing the new lesson date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the points earned by the student in this lesson (for practice lessons).
	 *
	 * @return The points earned in this lesson.
	 */
	public double getPoint() {
		return point;
	}

	/**
	 * Sets the points earned by the student in this lesson (for practice lessons).
	 *
	 * @param point The new points earned in this lesson.
	 */
	public void setPoint(double point) {
		this.point = point;
	}

	/**
	 * Returns a string representation of the Lesson object, including lesson type, date, attendance, and points.
	 *
	 * @return A string in the format "lessonType, date: date, attendance: attendance, point: point".
	 */
	@Override
	public String toString() {
		return lessonType.toString() + ", date: " + date.toString() + ", attendance: " + attendance.toString() + ", point: " + point;
	}

	/**
	 * Displays the information about the lesson to the console.
	 */
	public void displayInfo(){
		System.out.println(this);
	}

}

