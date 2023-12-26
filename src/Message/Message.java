package Message ;


import java.io.Serializable;
/**
 * This class represents a message within the system, encapsulating its theme (subject), description (body), and read status.
 */
public class Message implements Readable, Serializable {

	/**
	 * The theme (subject) of the message.
	 */
	private String theme;

	/**
	 * The description (body) of the message.
	 */
	private String description;

	/**
	 * Indicates whether the message has been read or not.
	 */
	private boolean isRead;

	/**
	 * Creates a message with default values.
	 */
	public Message(){
	}

	/**
	 * Creates a message with the specified theme, description, and read status.
	 *
	 * @param theme         The theme (subject) of the message.
	 * @param description   The description (body) of the message.
	 * @param isRead        Indicates whether the message is initially marked as read or not.
	 */
	public Message(String theme, String description, boolean isRead) {
		this.theme = theme;
		this.description = description;
		this.isRead = isRead;
	}

	/**
	 * Returns a formatted string representation of the message, suitable for reading.
	 *
	 * @return The formatted message string.
	 */
	public String read() {
		return theme + '\n' + description;
	}

	/**
	 * Gets the theme (subject) of the message.
	 *
	 * @return The theme of the message.
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * Gets the description (body) of the message.
	 *
	 * @return The description of the message.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Checks if the message has been read.
	 *
	 * @return True if the message has been read, false otherwise.
	 */
	public boolean isRead() {
		return isRead;
	}

	/**
	 * Returns a concise string representation of the message, including its theme, description, and read status.
	 *
	 * @return The concise string representation of the message.
	 */
	@Override
	public String toString() {
		return "Message{" +
				"theme='" + theme + '\'' +
				", description='" + description + '\'' +
				", isRead=" + isRead +
				'}';
	}
}

