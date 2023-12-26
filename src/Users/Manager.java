package Users ;


import Contents.Course;
import Database.Data;
import Enums.Faculty;
import Enums.ManagerType;

import java.io.*;
import java.util.*;

import Contents.News;
import Message.Request;

public class Manager extends Employee implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private ManagerType managerType;
	private Faculty faculty;

	private List<Request> receivedRequests;

	public Manager(){

		receivedRequests = new ArrayList<>();
	}

	public Manager(ManagerType managerType, Faculty faculty){
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = new ArrayList<>();
	}

	public Manager(ManagerType managerType, Faculty faculty, List<Request> receivedRequests){
		this.managerType = managerType;
		this.faculty = faculty;
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

	public void viewRequests(){
		for(Request request : receivedRequests){
			System.out.println(request);
		}
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

	private News createNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter title: ");
		String title = bf.readLine();
		System.out.println("Type description here: ");
		String content = bf.readLine();
		return new News(title, new Date(), content, new HashSet<>());
	}
	public void addNews() throws IOException {
		Data.getInstance().getNews().add(createNews());
	}
	public void removeNews(News news){
		Data.getInstance().getNews().remove(news);
	}
	@Override
	public void scrollNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ListIterator<News> iterator = Data.getInstance().getNews().listIterator();
		News news = iterator.next();
		System.out.println(news);
		while(true){
			System.out.println("1 -> Next");
			System.out.println("2 -> Previous");
			System.out.println("3 -> Remove news");
			System.out.println("4 -> Add news");
			System.out.println("5 -> Leave");
			int n = Integer.parseInt(bf.readLine());
			if(n == 1){
				if(iterator.hasNext()){
					news = iterator.next();
					System.out.println(news);
				}
				else{
					System.out.println("No more news!");
					break;
				}
			}
			else if(n == 2){
				if(iterator.hasPrevious()){
					iterator.previous();
					news = iterator.previous();
					System.out.println(news);
				}
				else {
					System.out.println("No more news!");
					break;
				}
			}
			else if(n == 3){
				removeNews(news);
			}
			else if(n == 4){
				addNews();
			}
			else if(n == 5)
				break;
			else
				throw new IOException();
		}
	}
}

