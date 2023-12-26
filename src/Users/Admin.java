package Users ;

import Enums.UserType;
import Database.*;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * An Admin class representing an administrator user with system-wide management capabilities.
 */
public class Admin extends User implements Serializable {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Admin object with the specified details.
	 *
	 * @param userType    The user type (always UserType.ADMIN).
	 * @param id          The admin's ID.
	 * @param password    The admin's password.
	 * @param username    The admin's username.
	 */
	public Admin(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
	}

	/**
	 * Displays a list of all users in the system.
	 */
	public void seeUsers(){
		System.out.println("All users: ");
		for(User u : Data.getInstance().getUsers()){
			System.out.println(u.getUsername());
		}
	}

	/**
	 * Creates a new user in the system.
	 *
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
	public void createUser() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
	 * Deletes a user from the system.
	 *
	 * @throws IOException       If an I/O error occurs while reading user input.
	 * @throws UserNotFound      If the specified user is not found.
	 */
	public void deleteUser() throws IOException, UserNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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

