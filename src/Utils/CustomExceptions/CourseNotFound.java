package Utils.CustomExceptions;

public class CourseNotFound extends Exception{
    public CourseNotFound(){
        super("Course not found!");
    }
    public CourseNotFound(String message){
        super(message);
    }
}
