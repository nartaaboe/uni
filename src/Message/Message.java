package Message ;


import java.io.Serializable;

public class Message implements Readable, Serializable {
	private String theme;
	private String description;
	private boolean isRead;
	public Message(){
	}
	public Message(String theme, String description, boolean isRead) {
		this.theme = theme;
		this.description = description;
		this.isRead = isRead;
	}
	public String read() {
		return theme + '\n' + description;
	}
	public String getTheme() {
		return theme;
	}
	public String getDescription() {
		return description;
	}
	public boolean isRead() {
		return isRead;
	}
	@Override
	public String toString() {
		return "Message{" +
				"theme='" + theme + '\'' +
				", description='" + description + '\'' +
				", isRead=" + isRead +
				'}';
	}
}

