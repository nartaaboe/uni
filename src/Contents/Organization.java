package Contents;

import Users.Student;
import Users.User;

import java.io.Serializable;
import java.util.HashSet;

/**
 * An Organization class representing a student-run organization within the system.
 */
public class Organization implements Serializable {

	/**
	 * The name of the organization.
	 */
	private String name;

	/**
	 * A description of the organization's purpose and activities.
	 */
	private String description ;

	/**
	 * The User object representing the president of the organization.
	 */
	private User president;

	/**
	 * A set of Student objects representing the members of the organization.
	 */
	private HashSet<Student> members;
	/**
	 * Creates a new Organization object with empty name, description, president, and members.
	 */

	public Organization (){
	}
}

