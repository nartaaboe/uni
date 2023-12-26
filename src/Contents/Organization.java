package Contents;

import Users.User;

import java.io.*;
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
	private String description;

	/**
	 * The User object representing the president of the organization.
	 */
	private User president;

	/**
	 * A set of User objects representing the members of the organization.
	 */
	private HashSet<User> members;

	/**
	 * Creates a new Organization object with empty name, description, president, and members.
	 */

	/**
	 * A static set containing all courses in the system.
	 */
	public static HashSet<Organization> organizations;

	/**
	 * A static initializer block that loads courses from the serialized file at startup.
	 */
	static {
		organizations = loadOrganizations();
	}
	public Organization() {
		this.name = "";
		this.description = "";
		this.president = null;
		this.members = new HashSet<>();
	}

	/**
	 * Creates a new Organization object with the specified name, description, and president.
	 *
	 * @param name        The name of the organization.
	 * @param description A description of the organization's purpose and activities.
	 * @param president   The User object representing the president of the organization.
	 */
	public Organization(String name, String description, User president) {
		this.name = name;
		this.description = description;
		this.president = president;
		this.members = new HashSet<>();
	}

	/**
	 * Allows a user to join the organization.
	 *
	 * @param member The User object to be added as a member.
	 */
	public void join(User member) {
		members.add(member);
	}

	/**
	 * Allows a user to leave the organization.
	 *
	 * @param member The User object to be removed as a member.
	 */
	public void leave(User member) {
		members.remove(member);
	}

	/**
	 * Loads organizations from a serialized file.
	 *
	 * @return A HashSet of Course objects representing the loaded courses.
	 */
	private static HashSet<Organization> loadOrganizations() {
		File file = new File("db/organization.ser");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				return (HashSet<Organization>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<>();
	}

	/**
	 * Saves organizations to a serialized file.
	 *
	 * @throws Exception If an error occurs during file saving.
	 */
	public static void saveCourses() throws Exception {
		FileOutputStream fos = new FileOutputStream("db/organization.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(organizations);
		fos.close();
		oos.close();
	}


}
