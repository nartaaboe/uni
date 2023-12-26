package Message ;

import Users.User;
import Enums.UserType;

import java.io.Serializable;
import java.util.Date;


public class Comment implements Readable, Serializable {
	private User user;
	private Date publicationDate;
	private String comment;

	public Comment(){
	}

	public Comment(User user, Date publicationDate, String comment) {
		this.user = user;
		this.publicationDate = publicationDate;
		this.comment = comment;
	}

	public String read() {
		return user + ": " + comment + '\n' + publicationDate;
	}


	public User getUser() {
		return user;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public String getContent() {
		return comment;
	}

	@Override
	public String toString() {
		return user.getUsername() + publicationDate + '\n' + comment;
	}
}

