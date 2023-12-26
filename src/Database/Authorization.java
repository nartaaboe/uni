package Database;

import Contents.Course;
import Contents.Pair;
import Enums.UserType;
import Users.*;
import Utils.CustomExceptions.CourseNotFound;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;


public class Authorization {
    private User user;

    private boolean exitSystem;
    public Authorization(){

        exitSystem = false;
    }
    public void login() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username: ");
        String username = bf.readLine();
        System.out.println("Enter password: ");
        String password = bf.readLine();
        for (User u : Data.getInstance().getUsers()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Successfully authorized!");
                this.user = u;
                return;
            }
        }
        
        throw new UserNotFound();

    }
    public void logout() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username: ");
        String username = bf.readLine();
        System.out.println("Enter password: ");
        String password = bf.readLine();
        for(User u : Data.getInstance().getUsers()){
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                System.out.println("Successfully logout!");
                this.user = null;
                return;
        }
        
        throw new UserNotFound();
    }
    public void viewMenu() throws IOException, UserNotFound, ParseException, CourseNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        exitSystem = true;
        while(true){
            if(!exitSystem)
                return;

            System.out.println("----Welcome to University System!----");
            System.out.println("choose one option!");
            System.out.println("1 -> Login.");
            System.out.println("2 -> Exit System.");
            int n = Integer.parseInt(bf.readLine()); 
            if(n == 1){
                login();
                if(user != null && user.getUserType() == UserType.ADMIN)
                    runAdmin();
                else if(user != null && user.getUserType() == UserType.STUDENT)
                    runStudent();
                else if(user != null && user.getUserType() == UserType.TEACHER)
                    runTeacher();
                else if(user != null && user.getUserType() == UserType.MANAGER)
                    runManager();
                else if(user != null && user.getUserType() == UserType.TECHSUPPORTSPECIALIST)
                    runTechSupportSpecialist();
                else if(user != null && user.getUserType() == UserType.RECTOR)
                    runRector();
                else if(user != null && user.getUserType() == UserType.DEAN)
                    runDean();
            }
            else if(n == 2){
                exitSystem = false;
                return;
            }
        }


    }
    private void runStudent() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Student student = (Student) user;
        while(true){
            System.out.println("--------------Menu------------");
            System.out.println("1 -> Logout");
            System.out.println("2 -> See journal");
            System.out.println("3 -> See transcript");
            System.out.println("4 -> Put attendance");
            System.out.println("5 -> News");
            System.out.println("6 -> Mark");
            System.out.println("7 -> Exit System");
            int n = Integer.parseInt(bf.readLine());
            switch (n){
                case 1:
                    logout();
                    return;
                case 2:
                    student.viewJournal();
                    while(true){
                        System.out.println("-------------Journal----------");
                        System.out.println("1 -> Logout");
                        System.out.println("2 -> Get over all points");
                        System.out.println("3 -> Get over all attendances");
                        System.out.println("4 -> Exit system");
                        int m = Integer.parseInt(bf.readLine());
                        switch (m){
                            case 1:
                                logout();
                                return;
                            case 2:
                                student.getJournal().getAllPoints();
                                break;
                            case 3:
                                student.getJournal().getAllAttendances();
                                break;
                            case 4:
                                exitSystem = false;
                                return;
                            default:
                                throw new IOException();
                        }
                    }
                case 3:
                    student.viewTranscript();
                    break;
                case 4:
                    student.putAttendance();
                    break;
                case 5:
                    student.scrollNews();
                    break;
                case 6:
                    student.viewMarks();
                    break;
                case 7:
                    exitSystem = false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }
    private void runAdmin() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Admin admin = (Admin) user;
        while(true) {
            System.out.println("--------------Menu------------");
            System.out.println("1 -> Logout");
            System.out.println("2 -> See all users");
            System.out.println("3 -> Create user");
            System.out.println("4 -> Delete user");
            System.out.println("5 -> Exit System");
            int n = Integer.parseInt(bf.readLine());
            switch (n){
                case 1:
                    logout();
                    return;
                case 2:
                    admin.seeUsers();
                    break;
                case 3:
                    admin.createUser();
                    break;
                case 4:
                    admin.deleteUser();
                    break;
                case 5:
                    exitSystem = false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }

    private void runTeacher() throws IOException, UserNotFound, ParseException, CourseNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Teacher teacher = (Teacher) user;
        while(true) {
            System.out.println("--------------Menu------------");
            System.out.println("1 -> Logout");
            System.out.println("2 -> See all students");
            System.out.println("3 -> See journal");
            System.out.println("4 -> Put attestation point");
            System.out.println("5 -> Put final exam point");
            System.out.println("6 -> Send complaint");
            System.out.println("7 -> Send message");
            System.out.println("5 -> Exit system");
            int n = Integer.parseInt(bf.readLine());
            switch (n){
                case 1:
                    logout();
                    return;
                case 2:
                    teacher.viewStudents();
                    break;
                case 3:
                    Pair pair = teacher.viewJournal();
                    while(true){
                        Student student = pair.getStudent();
                        Course course = pair.getCourse();
                        System.out.println("-------------Journal----------");
                        System.out.println("1 -> Logout");
                        System.out.println("2 -> Put point");
                        System.out.println("3 -> Change point");
                        System.out.println("4 -> Put attendance");
                        System.out.println("5 -> Change attendance");
                        System.out.println("6 -> Exit System");
                        int m = Integer.parseInt(bf.readLine());
                        switch (m) {
                            case 1:
                                logout();
                                return;
                            case 2:
                                teacher.putPoint(student, course);
                                break;
                            case 3:
                                teacher.changePoint(student, course);
                                break;
                            case 4:
                                teacher.putAttendance(student, course);
                                break;
                            case 5:
                                teacher.changeAttendance(student, course);
                                break;
                            case 6:
                                exitSystem = false;
                                return;
                            default:
                                throw new IOException();
                        }
                        student.getJournal().showPoints(course);
                    }
                case 4:
                    teacher.putAttestationPoints();
                    break;
                case 5:
                    teacher.putFinalExamMark();
                    break;
                case 6:
                    teacher.sendComplaint();
                    break;
                case 7:
                    break;
                case 8:
                    exitSystem= false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }
    private void runManager() throws UserNotFound, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = (Manager) user;
        while(true){
            System.out.println("--------------Menu------------");
            System.out.println("1 -> Logout");
            System.out.println("2 -> See info about students");
            System.out.println("3 -> See info about teachers");
            System.out.println("4 -> Assign course to teacher");
            System.out.println("5 -> Exit system");
            int n = Integer.parseInt(bf.readLine());
            switch (n){
                case 1:
                    logout();
                    break;
                case 2:
                    manager.viewInfoAboutStudents();
                    break;
                case 3:
                    manager.viewInfoAboutTeachers();
                    break;
                case 4:
                    manager.assignCourse();
                    break;
                case 5:
                    exitSystem = false;
                    return;
            }
        }
    }
    private void runTechSupportSpecialist(){
        TechSupportSpecialist techSupportSpecialist = (TechSupportSpecialist) user;
    }
    private void runDean(){
        Dean dean = (Dean) user;
    }
    private void runRector(){
        Rector rector = (Rector) user;
    }
}
