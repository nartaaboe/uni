package Contents;
import Message.Comment;
import Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;

public class News implements Serializable {
	private String title;
	private Date publicationDate;
	private String content;
	private HashSet<Comment> comments;
	private BufferedReader bf;

	public static List<News> news;

	static {
		news = loadNews();
	}
	public News(){
		bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public News(String title, Date publicationDate, String content, HashSet<Comment> comments) {
		this.title = title;
		this.publicationDate = publicationDate;
		this.content = content;
		this.comments = comments;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getTitle() {
		return title;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public String getContent() {
		return content;
	}

	public HashSet<Comment> getComments() {
		return comments;
	}

	public void viewNews() {
		System.out.println(title);
		System.out.println(content);
	}

	public void leaveComment(Comment comment){
		System.out.println("Successfully commented!");
		comments.add(comment);
	}

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

	public static void saveNews() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/news.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(news);
		fos.close();
		oos.close();
	}

	public void viewComments(){
		for(Comment c : comments){
			System.out.println(c.read());
		}
	}

	@Override
	public String toString() {
		return title + ", " + publicationDate + '\n' + content;
	}
}

