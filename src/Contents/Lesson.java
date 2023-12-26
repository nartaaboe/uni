package Contents;

import Enums.Attendance;
import Enums.LessonType;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Lesson implements Serializable {
	private int duration;
	private LessonType lessonType;
	private Attendance attendance;
	private double point;
	private Date date;

	public Lesson(){
		this.lessonType = LessonType.LECTURE;
		this.attendance = Attendance.ATTENDED;
		this.date = new Date();
		this.duration = 2;
		this.point = 0.0;
	}

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
	public Lesson(double point){
		this.lessonType = LessonType.PRACTICE;
		this.attendance = Attendance.ATTENDED;
		this.date = new Date();
		this.duration = 1;
		this.point = point;
	}
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

	public int getDuration() {
		return duration;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public Date getDate() {
		return date;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return lessonType.toString() + ", date: " + date.toString() + ", attendance: " + attendance.toString() + ", point: " + point;
	}

	public void displayInfo(){
		System.out.println(this);
	}

}

