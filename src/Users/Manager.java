package Users ;


import Database.Data;
import Enums.Faculty;
import Enums.ManagerType;

import java.io.*;
import java.util.*;

import Contents.News;
import Enums.UserType;
import Message.Request;

public class Manager extends Employee implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private ManagerType managerType;
	private Faculty faculty;

	private List<Request> receivedRequests;
	private Queue<Request> courseRegistration;

	public Manager() {
		receivedRequests = new ArrayList<>();
		courseRegistration = new LinkedList<>();
	}

	public Manager(ManagerType managerType, Faculty faculty) {
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = new ArrayList<>();
		this.courseRegistration = new LinkedList<>();
	}

	public Manager(ManagerType managerType, Faculty faculty, List<Request> receivedRequests) {
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = receivedRequests;
		this.courseRegistration = new LinkedList<>();
	}

	public Manager(UserType userType, String id, String password, String username, double salary, ManagerType managerType,
				   Faculty faculty, List<Request> receivedRequests, Queue<Request> courseRegistration) {
		super(userType, id, password, username, salary);
		this.managerType = managerType;
		this.faculty = faculty;
		this.receivedRequests = receivedRequests;
		this.courseRegistration = courseRegistration;
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

	public Queue<Request> getCourseRegistration() {
		return courseRegistration;
	}

	public void viewRequests() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		for (Request request : receivedRequests) {
			i++;
			System.out.println(i + " -> " + request);
		}
		int n = Integer.parseInt(bf.readLine());
		closeRequest(receivedRequests.get(n - 1));
	}

	private void closeRequest(Request request) {
		System.out.println("request closed " + request);
	}

	public void approveRegistration() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (!courseRegistration.isEmpty()) {
			Request request = courseRegistration.poll();
			System.out.println(request.getFrom() + " -> sent request to registration to " + request.getDescription());
			System.out.println("1 -> Approve or 2 -> Reject?");
			int n = Integer.parseInt(bf.readLine());
			if (n == 1) {
				Student student = (Student) request.getFrom();
				for (User user : Data.getInstance().getUsers()) {
					if (user instanceof Teacher && ((Teacher) user).getCourseWithStudents().containsKey(request.getCourse())) {
						student.getTeacherCourse().put((Teacher) user, request.getCourse());
					}
				}
			}
		}
	}

	public void writeOutCourse() {

	}

	public void viewInfoAboutTeachers() {
		for (User user : Data.getInstance().getUsers()) {
			if (user instanceof Teacher) {
				Teacher teacher = (Teacher) user;
				System.out.println(teacher);
			}
		}
	}

	public void viewInfoAboutStudents() {
		for (User user : Data.getInstance().getUsers()) {
			if (user instanceof Student) {
				Student student = (Student) user;
				System.out.println(student);
			}
		}
	}

	public void statisticalReport() {
		int s = 0;
		int e = 0;
		int m = 0;
		int d = 0;
		int r = 0;
		int t = 0;
		for (User user : Data.getInstance().getUsers()) {
			if (user instanceof Student)
				s++;
			if (user instanceof Employee) {
				e++;
				if (user instanceof Teacher)
					t++;
				if (user instanceof Dean)
					d++;
				if (user instanceof Rector)
					r++;
				if (user instanceof Manager)
					m++;
			}
		}
		System.out.println("Number of students -> " + s);
		System.out.println("Number of teachers -> " + t);
		System.out.println("Number of managers -> " + m);
		System.out.println("Number of deans -> " + d);
		System.out.println("Number of rectors -> " + r);
		System.out.println("Number of employee -> " + e);
	}

	private News createNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter title: ");
		String title = bf.readLine();
		System.out.println("Type description here: ");
		String content = bf.readLine();
		return new News(title, new Date(), content, new HashSet<>());
	}

	/**
	 *
	 * @throws IOException
	 */
	public void addNews() throws IOException {
		Data.getInstance().getNews().add(createNews());
	}

	/**
	 *
	 * @param news
	 */
	public void removeNews(News news) {
		Iterator<News> iterator = Data.getInstance().getNews().iterator();
		while (iterator.hasNext()) {
			News currentNews = iterator.next();
			if (currentNews.equals(news)) {
				iterator.remove();
				break;
			}
		}
	}

	/**
	 *
	 * @throws IOException
	 */
	@Override
	public void scrollNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ListIterator<News> iterator = Data.getInstance().getNews().listIterator();
		News news = iterator.next();
		System.out.println(news);
		while (true) {
			System.out.println("1 -> Next");
			System.out.println("2 -> Previous");
			System.out.println("3 -> Remove news");
			System.out.println("4 -> Leave");
			int n = Integer.parseInt(bf.readLine());
			if (n == 1) {
				if (iterator.hasNext()) {
					news = iterator.next();
					System.out.println(news);
				} else {
					System.out.println("No more news!");
					break;
				}
			} else if (n == 2) {
				if (iterator.hasPrevious()) {
					iterator.previous();
					news = iterator.previous();
					System.out.println(news);
				} else {
					System.out.println("No more news!");
					break;
				}
			} else if (n == 3) {
				removeNews(news);
			} else if (n == 4)
				break;
			else
				throw new IOException();
		}
	}
}