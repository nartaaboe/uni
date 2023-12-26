package Users ;

import Enums.UserType;
import Database.*;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Admin extends User implements Serializable {
	private BufferedReader bf;

	public Admin(){
		bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public Admin(UserType userType, String id, String password, String username) {
		super(userType, id, password, username);
		bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public void seeUsers(){
		System.out.println("All users: ");
		for(User u : Data.getInstance().getUsers()){
			System.out.println(u.getUsername());
		}
	}

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

