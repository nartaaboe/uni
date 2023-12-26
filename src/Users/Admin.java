package Users ;

import Enums.UserType;
import Database.*;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	public Admin(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
	}

	public void seeUsers(){
		System.out.println("All users: ");
		for(User u : Data.getInstance().getUsers()){
			System.out.println(u.getUsername());
		}
	}

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
		bf.close();
	}

	public void deleteUser() throws IOException, UserNotFound {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user name: ");
		String name = bf.readLine();
		bf.close();
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

