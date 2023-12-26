package Contents;
import Message.Comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public class News implements Serializable {
	private String title;
	private Date publicationDate;
	private String content;
	private HashSet<Comment> comments;
	private BufferedReader bf;

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

