package Utils.CustomExceptions;

/**
 * This class represents an exception that is thrown when a user is not found.
 */
public class UserNotFound extends Exception{
    /**
     * Creates a new instance of the exception with no message.
     */
    public UserNotFound(){
        super("User not found!");
    }

    /**
     * Creates a new instance of the exception with the specified message.
     *
     * @param message The message to be associated with the exception.
     */
    public UserNotFound(String message){
        super(message);
    }
}
