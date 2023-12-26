package Users ;


import Contents.Course;
import Enums.Faculty;
import Enums.ManagerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Contents.News;
import Message.Request;

public class Manager extends Employee implements Serializable {
	private ManagerType managerType;
	private Faculty faculty;
	private BufferedReader bf;
	private List<Request> receivedRequests;
	public Manager(){
		bf = new BufferedReader(new InputStreamReader(System.in));
		receivedRequests = new ArrayList<>();
	}
	public Manager(ManagerType managerType, Faculty faculty){
		this.managerType = managerType;
		this.faculty = faculty;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
		this.receivedRequests = new ArrayList<>();
	}
	public Manager(ManagerType managerType, Faculty faculty, List<Request> receivedRequests){
		this.managerType = managerType;
		this.faculty = faculty;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
		this.receivedRequests = receivedRequests;
	}
	public ManagerType getManagerType() {
		return managerType;
	}

	public Faculty getFaculty() {
		return faculty;
	}
	public List<Request> getReceivedRequests() {
		return receivedRequests;
	}

	public void approveRegistration(Student student) {

	}
	public void addCourseForRegistration(Course course){

	}
	public void assignCourse(){

	}
	public void writeOutCourse(){

	}
	public void viewInfoAboutTeachers() {
	}
	public void viewInfoAboutStudents() {
	}
	public void statisticalReport() {
	}
	public void addNews() {

	}
	public void removeNews(){

	}
}

