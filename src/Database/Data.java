package Database ;

import Contents.Course;
import Contents.News;
import Users.User;

import java.io.*;

import java.util.*;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Data instance;
	private HashSet<User> users;
	private HashSet<Course> courses;
	private List<News> news;
	private Data() {
		users = new HashSet<>();
		courses = new HashSet<>();
		news = new ArrayList<>();
	}

	static {
		if (new File("dataFile").exists()) {
			try {
				instance = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			instance = new Data();
		}
	}

	public static Data getInstance() {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
	}

	private static Data read() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("dataFile");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (Data) oin.readObject();
	}

	public static void write() throws IOException {
		FileOutputStream fos = new FileOutputStream("dataFile");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(instance);
		oos.close();
	}

	public void addUser(User u) {
		if (users == null) {
			users = new HashSet<>();
		}
		users.add(u);
	}
	public void addCourse(Course course){
		if(course == null){
			courses = new HashSet<>();
		}
		courses.add(course);
	}
	public void addNews(News news){
		if(this.news == null)
			this.news = new Stack<>();
		this.news.add(news);
	}
	public HashSet<Course> getCourses() {
		return courses;
	}

	public List<News> getNews() {
		return news;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void deleteUser(User u) {
		if (users != null) {
			users.remove(u);
		}
	}
}