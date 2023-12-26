
import Users.*;
import Enums.*;
import Contents.*;
import Database.*;
import Utils.CustomExceptions.CourseNotFound;
import Utils.CustomExceptions.UserNotFound;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Authorization a = new Authorization();
        Admin admin = new Admin(UserType.ADMIN, "22B030296", "123123", "admin");
        Data.getInstance().addUser(admin);
        Course course = new Course("CSCI2105", "Algosi", CourseType.BASIC, 5, Faculty.FIT);
        HashMap<Course, LinkedHashSet<Lesson>> points = new HashMap<>();
        LinkedHashSet<Lesson> map = new LinkedHashSet<>();
        map.add(new Lesson(LessonType.LECTURE, Attendance.ATTENDED, new Date(1638789000000L), 0.0));
        map.add(new Lesson(LessonType.PRACTICE, Attendance.ATTENDED, new Date(163000000000L), 1.0));
        map.add(new Lesson(LessonType.PRACTICE, Attendance.ATTENDED, 7.0));
        points.put(course, map);
        Journal journal1 = new Journal(points);
        Mark mark = new Mark(course);
        List<Mark> lst = new ArrayList<>();
        lst.add(mark);
        Transcript transcript = new Transcript(lst);
        HashMap<Teacher, Course> hashMap = new HashMap<>();
        Teacher teacher1 = new Teacher(UserType.TEACHER, "19B090456", "789789", "Beisenbek", 10000000.0, TeacherType.PROFESSOR);
        hashMap.put(teacher1, course);
        Student student1 = new Student(UserType.STUDENT, "22B030371", "456456", "sanzhar", Faculty.FIT, 2, hashMap, journal1, transcript);
        Student student2 = new Student(UserType.STUDENT, "22B030794", "753753", "kaisar", Faculty.FIT, 2, hashMap, journal1, transcript);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        HashMap<Course, List<Student>> mp = new HashMap<>();
        mp.put(course, list);
        teacher1.setCourseWithStudents(mp);
        Data.getInstance().addUser(teacher1);
        Data.getInstance().addUser(student1);
        Data.getInstance().addUser(student2);
        News news1 = new News("Bomb in kbtu", new Date(1638789000000L), "bla bla", new HashSet<>());
        News news2 = new News("New year!", new Date(), "New semak starts with new year...", new HashSet<>());
        Data.getInstance().getNews().add(news1);
        Data.getInstance().getNews().add(news2);
        a.viewMenu();
        Data.getInstance().save();

    }
}
