package Database ;

import Contents.Course;
import Contents.News;
import Users.User;

import java.io.*;

import java.util.*;

/**
 * Provides a central repository for storing and managing data within the University System.
 */
public class Data implements Serializable {

	/**
	 * Unique identifier for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Singleton instance of the Data class.
	 */
	private static Data instance;

	/**
	 * Collection of users in the system.
	 */
	private HashSet<User> users;

	/**
	 * Collection of courses in the system.
	 */
	private HashSet<Course> courses;

	/**
	 * Collection of news items in the system.
	 */
	private List<News> news;

	/**
	 * Private constructor to enforce the singleton pattern.
	 */
	private Data() {
		users = User.users;
		courses = Course.courses;
		news = News.news;
	}

	/**
	 * Returns the singleton instance of the Data class.
	 *
	 * @return the Data instance
	 */
	public static Data getInstance() {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
	}

	/**
	 * Adds a user to the data repository.
	 *
	 * @param u the user to add
	 */
	public void addUser(User u) {
		if (users == null) {
			users = new HashSet<>();
		}
		users.add(u);
	}

	/**
	 * Adds a course to the data repository.
	 *
	 * @param course the course to add
	 */
	public void addCourse(Course course){
		if(course == null){
			courses = new HashSet<>();
		}
		courses.add(course);
	}

	/**
	 * Adds a news item to the data repository.
	 *
	 * @param news the news item to add
	 */
	public void addNews(News news){
		if(this.news == null)
			this.news = new Stack<>();
		this.news.add(news);
	}

	/**
	 * Returns the collection of courses in the data repository.
	 *
	 * @return the collection of courses
	 */
	public HashSet<Course> getCourses() {
		return courses;
	}

	/**
	 * Returns the collection of news items in the data repository.
	 *
	 * @return the collection of news items
	 */
	public List<News> getNews() {
		return news;
	}

	/**
	 * Returns the collection of users in the data repository.
	 *
	 * @return the collection of users
	 */
	public HashSet<User> getUsers() {
		return users;
	}

	/**
	 * Deletes a user from the data repository.
	 *
	 * @param u the user to delete
	 */
	public void deleteUser(User u) {
		if (users != null) {
			users.remove(u);
		}
	}

	/**
	 * Persists all data to files.
	 *
	 * @throws Exception if an error occurs during saving
	 */
	public void save() throws Exception {
		Course.saveCourses();
		News.saveNews();
		User.saveUsers();

    }

}