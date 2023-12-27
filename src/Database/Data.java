package Database ;

import Contents.Course;
import Contents.News;
import Enums.Language;
import Users.User;

import java.io.*;

import java.util.*;

public class Data implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private static Data instance;
	private HashSet<User> users;
	private HashSet<Course> courses;
	private List<News> news;
	private Data() {
		users = User.users;
		courses = Course.courses;
		news = News.news;
	}


	public static Data getInstance() {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
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

	public void save() throws Exception {
		Course.saveCourses();
		News.saveNews();
		User.saveUsers();

    }

	public String getText(String key, Language lang){
		ResourceBundle bundle;
		if (lang == Language.KZ){
			bundle = ResourceBundle.getBundle("resourses/lang", new Locale("kz", "KZ"));
		} else if (lang == Language.RU){
			bundle = ResourceBundle.getBundle("resourses/lang", new Locale("ru", "RU"));
		} else {
			bundle = ResourceBundle.getBundle("resourses/lang", new Locale("en", "US"));
		}

		if (!bundle.containsKey(key)) return "";

		return bundle.getString(key);

	}

}