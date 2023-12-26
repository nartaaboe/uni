package Contents;

import Users.Student;
import Users.User;

import java.io.Serializable;
import java.util.HashSet;

public class Organization implements Serializable {
	private String name;
	private String description ;
	private User president;
	
	private HashSet<Student> members;
	public Organization (){
	}
}

