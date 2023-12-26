package Contents;
import Message.Comment;
import Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;

/**
 * A News class representing a news article within the system, containing title, publication date, content, and comments.
 */
public class News implements Serializable {

	/**
	 * The title of the news article.
	 */
	private String title;

	/**
	 * The date when the news article was published.
	 */
	private Date publicationDate;

	/**
	 * The main content of the news article.
	 */
	private String content;

	/**
	 * A set of comments associated with the news article.
	 */
	private HashSet<Comment> comments;

	/**
	 * A BufferedReader object for reading user input (likely used for comment input).
	 */

	/**
	 * A static list containing all news articles, loaded from a file upon class initialization.
	 */
	public static List<News> news;

	static {
		news = loadNews();
	}

	/**
	 * Creates a new News object with empty content and comments.
	 */
	public News(){
	}

	/**
	 * Creates a new News object with the specified title, publication date, content, and comments.
	 *
	 * @param title The title of the news article.
	 * @param publicationDate The date when the article was published.
	 * @param content The main content of the article.
	 * @param comments A set of comments associated with the article.
	 */
	public News(String title, Date publicationDate, String content, HashSet<Comment> comments) {
		this.title = title;
		this.publicationDate = publicationDate;
		this.content = content;
		this.comments = comments;
	}

	/**
	 * Returns the title of the news article.
	 *
	 * @return The title of the article.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the date when the news article was published.
	 *
	 * @return The publication date of the article.
	 */

	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Returns the main content of the news article.
	 *
	 * @return The content of the article.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Returns a set of comments associated with the news article.
	 *
	 * @return A HashSet of Comment objects representing the comments on the article.
	 */
	public HashSet<Comment> getComments() {
		return comments;
	}


	/**
	 * Displays the title and content of the news article to the console.
	 */
	public void viewNews() {
		System.out.println(title);
		System.out.println(content);
	}

	/**
	 * Adds a new comment to the news article.
	 *
	 * @param comment The Comment object to add to the article.
	 */
	public void leaveComment(Comment comment){
		System.out.println("Successfully commented!");
		comments.add(comment);
	}

	/**
	 * Loads a list of News objects from a serialized file.
	 *
	 * @return A List of News objects loaded from the file, or an empty ArrayList if the file doesn't exist.
	 */
	private static List<News> loadNews() {
		File file = new File("db/news.ser");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				return (List<News>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}

	/**
	 * Saves the current list of News objects to a serialized file.
	 *
	 * @throws Exception If an error occurs during file saving.
	 */
	public static void saveNews() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/news.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(news);
		fos.close();
		oos.close();
	}

	/**
	 * Displays all comments associated with the news article to the console.
	 */
	public void viewComments(){
		for(Comment c : comments){
			System.out.println(c.read());
		}
	}

	/**
	 * Returns a string representation of the News object, including title, publication date, and content.
	 *
	 * @return A string in the format "title, publicationDate\ncontent".
	 */
	@Override
	public String toString() {
		return title + ", " + publicationDate + '\n' + content;
	}
}

