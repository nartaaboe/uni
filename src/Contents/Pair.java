package Contents;

import Users.Student;

public class Pair {
    private Student student;
    private Course course;
    public Pair(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}
