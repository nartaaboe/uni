package Users ;

import Contents.Course;
import Contents.News;
import Database.Data;
import Enums.*;
import Message.Comment;
import Utils.Hashing.SHA256;

import java.io.*;
import java.util.*;



public abstract class User implements Serializable {
	private UserType userType;
	private String id;
	private String password;
	private String username;


	private static final long serialVersionUID = 1L;

	public static HashSet<User> users;

	static {
		users = loadUsers();
	}

	public User(){

	}

	public User(UserType userType, String id, String password, String username) {
		this.userType = userType;
		this.id = id;
		this.password = SHA256.getHash(password);
		this.username = username;

	}
	/**
	 * Gets the type of user.
	 *
	 * @return The user type.
	 */

	public UserType getUserType() {
		return userType;
	}


	/**
	 * Gets the user's ID.
	 *
	 * @return The user's ID.
	 */

	/**
	 * Gets the user's password.
	 *
	 * @return The user's password.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the user's username.
	 *
	 * @return The user's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Abstract method to get the user's name.
	 *
	 * @return The user's name.
	 */
	public String getName() {
		return "";
	}



	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = SHA256.getHash(password);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void changeName(String name) {
	}


	public boolean verifyPassword() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter current password: ");
		String p1 = bf.readLine();
		if(p1.equals(SHA256.getHash(password)))
			return true;
		System.out.println("Wrong verification.");

		return false;
	}

	public void changePassword() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		if (!verifyPassword()) return;
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


	public boolean changePhoneNumber(String phoneNumber) {
		// TODO implement me
		return false;
	}

	/**
	 * Method to leave a comment on a news object.
	 *
	 * @param news The news object to leave a comment on.
	 * @throws IOException If an I/O error occurs.
	 */
	private void leaveComment(News news) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type your comment here: ");
		String comment = bf.readLine();
		news.getComments().add(new Comment(this, new Date(), comment));
	}

	/**
	 * Method to scroll through news articles, leave comments, and navigate.
	 *
	 * @throws IOException If an I/O error occurs.
	 */

	public void scrollNews() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ListIterator<News> iterator = Data.getInstance().getNews().listIterator();
		News news = iterator.next();

		while(true){
			System.out.println(news);
			System.out.println("1 -> Next");
			System.out.println("2 -> Previous");
			System.out.println("3 -> Leave comment");
			System.out.println("4 -> Leave");
			int n = Integer.parseInt(bf.readLine());
			if(n == 1){
				if(iterator.hasNext()){
					news = iterator.next();
					System.out.println(news);

				} else{
					System.out.println("No more news!");
					break;
				}
			} else if(n == 2){
				if(iterator.hasPrevious()){
					iterator.previous();
					news = iterator.previous();
					System.out.println(news);
				} else {
					System.out.println("No more news!");
					break;
				}
			} else if(n == 3){
				leaveComment(news);
			} else if(n == 4)
				break;
			else
				throw new IOException();
		}
	}
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
	 * Saves the set of users to a file.
	 *
	 * @throws Exception If an error occurs during the saving process.
	 */
	public static void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/users.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		fos.close();
		oos.close();
	}


}

