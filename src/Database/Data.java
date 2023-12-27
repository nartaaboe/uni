package Database;

import Contents.Course;
import Contents.News;
import Enums.Language;
import Users.User;

import java.io.*;
import java.util.*;

/**
 * The Data class represents the data storage and management for users, courses, and news in the application.
 * It follows the Singleton pattern to ensure a single instance of the class throughout the application.
 */
public class Data implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	// Singleton instance
	private static Data instance;

	// Collections to store users, courses, and news
	private HashSet<User> users;
	private HashSet<Course> courses;
	private List<News> news;

	/**
	 * Private constructor to prevent external instantiation.
	 * Initializes the collections by referencing existing collections from User, Course, and News classes.
	 */
	private Data() {
		users = User.users;
		courses = Course.courses;
		news = News.news;
	}

	/**
	 * Returns the singleton instance of the Data class.
	 *
	 * @return The singleton instance of the Data class.
	 */
	public static Data getInstance() {
		if (instance == null) {
			instance = new Data();
		}
		return instance;
	}

	/**
	 * Adds a user to the collection of users.
	 *
	 * @param u The user to be added.
	 */
	public void addUser(User u) {
		if (users == null) {
			users = new HashSet<>();
		}
		users.add(u);
	}

	/**
	 * Adds a course to the collection of courses.
	 *
	 * @param course The course to be added.
	 */
	public void addCourse(Course course) {
		if (course == null) {
			courses = new HashSet<>();
		}
		courses.add(course);
	}

	/**
	 * Adds news to the collection of news.
	 *
	 * @param news The news to be added.
	 */
	public void addNews(News news) {
		if (this.news == null)
			this.news = new Stack<>();
		this.news.add(news);
	}

	/**
	 * Gets the set of courses stored in the data.
	 *
	 * @return The set of courses.
	 */
	public HashSet<Course> getCourses() {
		return courses;
	}

	/**
	 * Gets the list of news stored in the data.
	 *
	 * @return The list of news.
	 */
	public List<News> getNews() {
		return news;
	}

	/**
	 * Gets the set of users stored in the data.
	 *
	 * @return The set of users.
	 */
	public HashSet<User> getUsers() {
		return users;
	}

	/**
	 * Deletes a user from the collection of users.
	 *
	 * @param u The user to be deleted.
	 */
	public void deleteUser(User u) {
		if (users != null) {
			users.remove(u);
		}
	}

	/**
	 * Saves the courses, news, and users to their respective files.
	 *
	 * @throws Exception If an error occurs during the saving process.
	 */
	public void save() throws Exception {
		Course.saveCourses();
		News.saveNews();
		User.saveUsers();
	}

	/**
	 * Gets the text corresponding to the given key and language from the resource bundle.
	 *
	 * @param key  The key to look up in the resource bundle.
	 * @param lang The language for which to retrieve the text.
	 * @return The text corresponding to the key and language.
	 */
	public String getText(String key, Language lang) {
		ResourceBundle bundle;
		if (lang == Language.KZ) {
			bundle = ResourceBundle.getBundle("resources/lang", new Locale("kz", "KZ"));
		} else if (lang == Language.RU) {
			bundle = ResourceBundle.getBundle("resources/lang", new Locale("ru", "RU"));
		} else {
			bundle = ResourceBundle.getBundle("resources/lang", new Locale("en", "US"));
		}

		if (!bundle.containsKey(key)) return "";

		return bundle.getString(key);
	}
}
