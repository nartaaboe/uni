package Utils.CustomExceptions;

/**
 * This class represents an exception that is thrown when a course is not found.
 */
public class CourseNotFound extends Exception{

    /**
     * Creates a new instance of the exception with no message.
     */
    public CourseNotFound(){
        super("Course not found!");
    }

    /**
     * Creates a new instance of the exception with the specified message.
     *
     * @param message The message to be associated with the exception.
     */
    public CourseNotFound(String message){
        super(message);
    }
}
