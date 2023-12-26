package Contents;

import Users.Student;

/**
 * A Pair class representing an association between a student and a course.
 */
public class Pair {

    /**
     * The Student object representing the student in the pair.
     */
    private Student student;

    /**
     * The Course object representing the course in the pair.
     */
    private Course course;

    /**
     * Creates a new Pair object with the specified student and course.
     *
     * @param student The Student object to associate with the course.
     * @param course The Course object to associate with the student.
     */
    public Pair(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    /**
     * Returns the Student object in the pair.
     *
     * @return The associated Student object.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Returns the Course object in the pair.
     *
     * @return The associated Course object.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Returns a string representation of the Pair object, including student and course information.
     *
     * @return A string in the format "Pair{student=studentName, course=courseName}".
     */
    @Override
    public String toString() {
        return "Pair{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}
