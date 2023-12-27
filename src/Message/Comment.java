package Message ;

import Users.User;
import Enums.UserType;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a comment within the system, encapsulating the user who made the comment, the publication date, and the comment text.
 */
public class Comment implements Readable, Serializable {
	/**
	 * The user who made the comment.
	 */
	private User user;

	/**
	 * The date and time when the comment was published.
	 */
	private Date publicationDate;

	/**
	 * The content of the comment.
	 */
	private String comment;

	/**
	 * Creates a comment with default values.
	 */
	public Comment(){
	}

	/**
	 * Creates a comment with the specified user, publication date, and content.
	 *
	 * @param user         The user who made the comment.
	 * @param publicationDate The date and time when the comment was published.
	 * @param comment      The content of the comment.
	 */
	public Comment(User user, Date publicationDate, String comment) {
		this.user = user;
		this.publicationDate = publicationDate;
		this.comment = comment;
	}

	/**
	 * Returns a formatted string representation of the comment, suitable for reading.
	 *
	 * @return The formatted comment string.
	 */
	public String read() {
		return user + ": " + comment + '\n' + publicationDate;
	}


	/**
	 * Gets the user who made the comment.
	 *
	 * @return The user who made the comment.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Gets the publication date of the comment.
	 *
	 * @return The publication date of the comment.
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Gets the content of the comment.
	 *
	 * @return The content of the comment.
	 */
	public String getContent() {
		return comment;
	}

	/**
	 * Returns a concise string representation of the comment, including the user's username, publication date, and comment text.
	 *
	 * @return The concise string representation of the comment.
	 */
	@Override
	public String toString() {
		return user.getUsername() + " " + publicationDate + ":\n" + comment;
	}
}

