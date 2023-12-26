package Users ;

import Contents.News;
import Database.Data;
import Enums.*;
import Message.Comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This abstract class represents a user within the system, providing basic properties and functionality common to all users.
 */
public abstract class User implements Serializable {

	/**
	 * The user's type (e.g., admin, student).
	 */
	private UserType userType;
	/**
	 * The user's unique ID.
	 */
	private String id;

	/**
	 * The user's password.
	 */
	private String password;
	/**
	 * The user's username.
	 */
	private String username;
	/**
	 * The buffered reader used for reading input from the console.
	 */
	private BufferedReader bf;

	/**
	 * Creates a user with default values.
	 */
	public User() {
		new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Creates a user with the specified user type, ID, password, and username.
	 *
	 * @param userType The user type.
	 * @param id       The user ID.
	 * @param password The user password.
	 * @param username The user username.
	 */
	public User(UserType userType, String id, String password, String username) {
		this.userType = userType;
		this.id = id;
		this.password = password;
		this.username = username;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
	}

	// Getters and Setters

	/**
	 * Gets the user's type.
	 *
	 * @return The user type.
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * Gets the user's id.
	 *
	 * @return The user id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return The user password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the user's username.
	 *
	 * @return The username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the user's name.
	 *
	 * @return The name.
	 */
	public String getName() {
		return "";
	}

	/**
	 * Sets the user's type.
	 *
	 * @param userType The new user type.
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * Sets the user's id.
	 *
	 * @param id The new user id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password The new user password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the username.
	 *
	 * @param username The new username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * Leaves a comment on a news article.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public void leaveCommentToNews() throws IOException {
		List<News> news = Data.getInstance().getNews();
		int j = 0;
		for(int i = news.size() - 1; i >= 0; i--)
			System.out.println((++j) + " -> " + news.get(i));
		System.out.println("Choose news to comment: ");
		int n = Integer.parseInt(bf.readLine());
		System.out.println("Type your comment here: ");
		String comment = bf.readLine();
		Data.getInstance().getNews().get(n - 1).leaveComment(new Comment(this, new Date(), comment));
	}

	/**
	 * Verifies the user's password.
	 *
	 * @return True if the password is correct, false otherwise.
	 * @throws IOException If an I/O error occurs.
	 */
	public boolean verifyPassword() throws IOException {
		System.out.println("Enter current password: ");
		String p1 = bf.readLine();
		if(p1.equals(password))
			return true;
		System.out.println("Wrong verification.");
		return false;
	}

	public void changeName(String name) {
	}

	/**
	 * Changes the user's password.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public void changePassword() throws IOException {
		verifyPassword();
		System.out.println("Enter new password: ");
		String newPassword = bf.readLine();

		System.out.println("Retype the new password: ");
		String newPasswordRetype = bf.readLine();

		if (!newPassword.equals(newPasswordRetype)) {
			System.out.println("Passwords do not match. Please try again.");
			return;
		}

		setPassword(newPassword);
		System.out.println("Password is updated.");
	}

	/**
	 * Changes the user's phone number.
	 *
	 * @param phoneNumber The new phone number of the user.
	 * @return True if the phone number was successfully changed, false otherwise.
	 */
	public boolean changePhoneNumber(String phoneNumber) {
		// TODO implement me
		return false;
	}
}

