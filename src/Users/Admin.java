package Users ;

import Enums.UserType;
import Database.*;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * This class represents an admin user within the system, providing methods for managing other users.
 */
public class Admin extends User implements Serializable {
	/**
	 * The buffered reader used for reading input from the console.
	 */
	private BufferedReader bf;

	/**
	 * Creates an admin user with default values.
	 */
	public Admin(){
		bf = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Creates an admin user with the specified user type, ID, password, and username.
	 *
	 * @param userType The user type.
	 * @param id       The user ID.
	 * @param password The user password.
	 * @param username The user username.
	 */
	public Admin(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
		bf = new BufferedReader(new InputStreamReader(System.in));
	}


	/**
	 * Prints a list of all users in the system to the console.
	 */
	public void seeUsers(){
		System.out.println("All users: ");
		for(User u : Data.getInstance().getUsers()){
			System.out.println(u.getUsername());
		}
	}

	/**
	 * Creates a new user based on user input.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public void createUser() throws IOException {
		System.out.println("Type here userType, id, password, username: ");
		String userType = bf.readLine();
		String id = bf.readLine();
		String password = bf.readLine();
		String username = bf.readLine();
		if(userType == UserType.ADMIN.toString().toLowerCase()){
			Admin admin = new Admin(UserType.ADMIN, id, password, username);
			Data.getInstance().addUser(admin);
		} else if(userType == UserType.STUDENT.toString().toLowerCase()){
			Student student = new Student(UserType.STUDENT, id, password, username);
			Data.getInstance().addUser(student);
		}
	}

	/**
	 * Deletes a user with the specified username.
	 *
	 * @throws IOException   If an I/O error occurs.
	 * @throws UserNotFound If the user is not found.
	 */
	public void deleteUser() throws IOException, UserNotFound {
		System.out.println("Enter user name: ");
		String name = bf.readLine();
		for(User u : Data.getInstance().getUsers()){
			if(u.getUsername().equals(name)){
				Data.getInstance().deleteUser(u);
				System.out.println("User successfully deleted!");
				return;
			}
		}
		throw new UserNotFound();
	}
}

