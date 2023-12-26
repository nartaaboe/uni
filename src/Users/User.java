package Users ;

import Contents.Course;
import Contents.News;
import Database.Data;
import Enums.*;
import Message.Comment;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * An abstract User class representing a user of the university system.
 */
public abstract class User implements Serializable {

	/**
	 * The serial version UID.
	 */
	private UserType userType;

	/**
	 * The user's type (e.g., "student", "teacher", "admin").
	 */
	private String id;

	/**
	 * The user's ID.
	 */
	private String password;

	/**
	 * The user's password.
	 */
	private String username;

	/**
	 * The user's username.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A static set of all users in the system.
	 */
	public static HashSet<User> users;

	/**
	 * A static initializer block that loads user data from the "db/users.ser" file into the {@code users} set.
	 */
	static {
		users = loadUsers();
	}

	/**
	 * Creates a new User object with default values.
	 */
	public User(){

	}

	/**
	 * Creates a new User object with the specified user type, ID, password, and username.
	 *
	 * @param userType    The user's type (e.g., "student", "teacher", "admin").
	 * @param id          The user's ID.
	 * @param password    The user's password.
	 * @param username    The user's username.
	 */
	public User(UserType userType, String id, String password, String username) {
		this.userType = userType;
		this.id = id;
		this.password = password;
		this.username = username;

	}

	/**
	 * Returns the user's type.
	 *
	 * @return The UserType enum value representing the user's type.
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * Returns the user's ID.
	 *
	 * @return The user's ID as a String.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the user's password.
	 *
	 * @return The user's password as a String.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Returns the user's username.
	 *
	 * @return The user's username as a String.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Returns the user's full name.
	 *
	 * @return The user's full name as a String. Implementations in subclasses should provide the appropriate name for each user type.
	 */
	public String getName() {
		return "";
	}

	/**
	 * Allows the user to leave a comment on a news item.
	 *
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
	public void leaveCommentToNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
	 * Sets the user's type.
	 *
	 * @param userType The new UserType value to set.
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * Sets the user's ID.
	 *
	 * @param id The new ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password The new password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the user's username.
	 *
	 * @param username The new username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Changes the user's full name.
	 *
	 * @param name The new full name to set.
	 */
	public void changeName(String name) {
	}

	/**
	 * Verifies the user's current password.
	 *
	 * @return True if the provided password matches the user's current password, false otherwise.
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
	public boolean verifyPassword() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter current password: ");
		String p1 = bf.readLine();
		if(p1.equals(password))
			return true;
		System.out.println("Wrong verification.");
		
		return false;
	}

	/**
	 * Allows the user to change their password.
	 *
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
	public void changePassword() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
	 * Allows the user to change their phone number.
	 *
	 * @param phoneNumber The new phone number to set.
	 * @return True if the phone number was changed successfully, false otherwise.
	 */
	public boolean changePhoneNumber(String phoneNumber) {
		// TODO implement me
		return false;
	}

	/**
	 * A private static method that loads user data from the "db/users.ser" file into a HashSet.
	 *
	 * @return A HashSet containing the loaded User objects, or an empty HashSet if the file does not exist or an error occurs.
	 */
	private static HashSet<User> loadUsers() {
		File file = new File("db/users.ser");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				return (HashSet<User>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<>();
	}

	/**
	 * A public static method that saves the current set of users to the "db/users.ser" file.
	 *
	 * @throws Exception If an error occurs during serialization or file output.
	 */
	public static void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/users.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		fos.close();
		oos.close();
	}

}

