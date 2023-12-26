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


public abstract class User implements Serializable {
	private UserType userType;
	private String id;
	private String password;
	private String username;
	private BufferedReader bf;

	public User() {
		new BufferedReader(new InputStreamReader(System.in));
	}

	public User(UserType userType, String id, String password, String username) {
		this.userType = userType;
		this.id = id;
		this.password = password;
		this.username = username;
		this.bf = new BufferedReader(new InputStreamReader(System.in));
	}

	public UserType getUserType() {
		return userType;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return "";
	}

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
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void changeName(String name) {
	}


	public boolean verifyPassword() throws IOException {
		System.out.println("Enter current password: ");
		String p1 = bf.readLine();
		if(p1.equals(password))
			return true;
		System.out.println("Wrong verification.");
		return false;
	}

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


	public boolean changePhoneNumber(String phoneNumber) {
		// TODO implement me
		return false;
	}
}

