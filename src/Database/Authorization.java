package Database;

import Contents.Course;
import Contents.Pair;
import Enums.Language;
import Enums.UserType;
import Users.*;
import Utils.CustomExceptions.CourseNotFound;
import Utils.CustomExceptions.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * Handles user authentication, authorization, and role-based menu navigation within the University System.
 */
public class Authorization {

    /**
     * The currently logged-in user.
     */
    private User user;

    /**
     * A flag indicating whether the system should continue running.
     */
    private boolean exitSystem;

    /**
     * The current language.
     */
    private Language lang;

    /**
     * Constructs a new Authorization object.
     */
    public Authorization(){

        exitSystem = false;
        lang = Language.EN;
    }

    /**
     * Authenticates a user with the given username and password.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the user is not found in the system
     */
    public void login() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Data.getInstance().getText("enterUsername", lang));
        String username = bf.readLine();
        System.out.println(Data.getInstance().getText("enterPassword", lang));
        String password = bf.readLine();
        for (User u : Data.getInstance().getUsers()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println(Data.getInstance().getText("successfullyAuthorized", lang));
                this.user = u;
                return;
            }
        }
        
        throw new UserNotFound();

    }

    /**
     * Logs out the currently logged-in user.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if no user is currently logged in
     */
    public void logout() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Data.getInstance().getText("enterUsername", lang));
        String username = bf.readLine();
        System.out.println(Data.getInstance().getText("enterPassword", lang));
        String password = bf.readLine();
        for(User u : Data.getInstance().getUsers()){
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                System.out.println(Data.getInstance().getText("successfullyAuthorized", lang));
                this.user = null;
                return;
        }
        
        throw new UserNotFound();
    }

    /**
     * Displays the main menu of the University System, handles user login, and directs users to role-based features.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if a user is not found in the system
     * @throws ParseException if an error occurs while parsing input
     * @throws CourseNotFound if a course is not found in the system
     */
    public void viewMenu() throws IOException, UserNotFound, ParseException, CourseNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        exitSystem = true;
        while(true){
            if(!exitSystem)
                return;

            System.out.println("----" + Data.getInstance().getText("welcomeMessage", lang) + "----");
            System.out.println(Data.getInstance().getText("chooseOption", lang));
            System.out.println("1 -> " + Data.getInstance().getText("login", lang));
            System.out.println("2 -> " + Data.getInstance().getText("language", lang));
            System.out.println("3 -> " + Data.getInstance().getText("exitSystem", lang));
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
            else if (n == 2){
                changeLanguage();
                viewMenu();
            }
            else if(n == 3){
                exitSystem = false;
                return;
            }
        }


    }

    /**
     * Handles the student-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the student user is not found in the system
     */
    private void runStudent() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Student student = (Student) user;
        while(true){
            System.out.println("--------------" + Data.getInstance().getText("menu", lang) + "------------");
            System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
            System.out.println("2 -> " + Data.getInstance().getText("seeJournal", lang));
            System.out.println("3 -> " + Data.getInstance().getText("seeTranscript", lang));
            System.out.println("4 -> " + Data.getInstance().getText("putAttendance", lang));
            System.out.println("5 -> " + Data.getInstance().getText("news", lang));
            System.out.println("6 -> " + Data.getInstance().getText("mark", lang));
            System.out.println("7 -> " + Data.getInstance().getText("language", lang));
            System.out.println("8 -> " + Data.getInstance().getText("exitSystem", lang));

            int n = Integer.parseInt(bf.readLine());
            switch (n){
                case 1:
                    logout();
                    return;
                case 2:
                    student.viewJournal();
                    while(true){
                        System.out.println("--------------" + Data.getInstance().getText("journal", lang) + "------------");
                        System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
                        System.out.println("2 -> " + Data.getInstance().getText("getOverallPoints", lang));
                        System.out.println("3 -> " + Data.getInstance().getText("getOverallAttendances", lang));
                        System.out.println("4 -> " + Data.getInstance().getText("exitSystem", lang));

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
                    changeLanguage();
                    break;
                case 8:
                    exitSystem = false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }

    /**
     * Handles the admin-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the admin user is not found in the system
     */
    private void runAdmin() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Admin admin = (Admin) user;
        while(true) {
            System.out.println("--------------" + Data.getInstance().getText("menu", lang) + "------------");
            System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
            System.out.println("2 -> " + Data.getInstance().getText("seeAllUsers", lang));
            System.out.println("3 -> " + Data.getInstance().getText("createUser", lang));
            System.out.println("4 -> " + Data.getInstance().getText("deleteUser", lang));
            System.out.println("5 -> " + Data.getInstance().getText("language", lang));
            System.out.println("6 -> " + Data.getInstance().getText("exitSystem", lang));

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
                    changeLanguage();
                    break;
                case 6:
                    exitSystem = false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }

    /**
     * Handles the teacher-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the teacher user is not found in the system
     * @throws ParseException if an error occurs while parsing input
     * @throws CourseNotFound if a course is not found in the system
     */
    private void runTeacher() throws IOException, UserNotFound, ParseException, CourseNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Teacher teacher = (Teacher) user;
        while(true) {
            System.out.println("--------------" + Data.getInstance().getText("menu", lang) + "------------");
            System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
            System.out.println("2 -> " + Data.getInstance().getText("seeAllStudents", lang));
            System.out.println("3 -> " + Data.getInstance().getText("seeJournal", lang));
            System.out.println("4 -> " + Data.getInstance().getText("putAttestationPoint", lang));
            System.out.println("5 -> " + Data.getInstance().getText("putFinalExamPoint", lang));
            System.out.println("6 -> " + Data.getInstance().getText("sendComplaint", lang));
            System.out.println("7 -> " + Data.getInstance().getText("sendMessage", lang));
            System.out.println("8 -> " + Data.getInstance().getText("language", lang));
            System.out.println("9 -> " + Data.getInstance().getText("exitSystem", lang));

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
                        System.out.println("--------------" + Data.getInstance().getText("journal", lang) + "------------");
                        System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
                        System.out.println("2 -> " + Data.getInstance().getText("putPoint", lang));
                        System.out.println("3 -> " + Data.getInstance().getText("changePoint", lang));
                        System.out.println("4 -> " + Data.getInstance().getText("putAttendance", lang));
                        System.out.println("5 -> " + Data.getInstance().getText("changeAttendance", lang));
                        System.out.println("6 -> " + Data.getInstance().getText("exitSystem", lang));

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
                    changeLanguage();
                    break;
                case 9:
                    exitSystem= false;
                    return;
                default:
                    throw new IOException();
            }
        }
    }

    /**
     * Handles the manager-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the manager user is not found in the system
     */
    private void runManager() throws UserNotFound, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = (Manager) user;
        while(true){
            System.out.println("--------------" + Data.getInstance().getText("menu", lang) + "------------");
            System.out.println("1 -> " + Data.getInstance().getText("logout", lang));
            System.out.println("2 -> " + Data.getInstance().getText("seeInfoStudents", lang));
            System.out.println("3 -> " + Data.getInstance().getText("seeInfoTeachers", lang));
            System.out.println("4 -> " + Data.getInstance().getText("assignCourseToTeacher", lang));
            System.out.println("5 -> " + Data.getInstance().getText("assignCourseToStudent", lang));
            System.out.println("6 -> " + Data.getInstance().getText("news", lang));
            System.out.println("7 -> " + Data.getInstance().getText("viewRequests", lang));
            System.out.println("8 -> " + Data.getInstance().getText("language", lang));
            System.out.println("9 -> " + Data.getInstance().getText("exitSystem", lang));

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
                    manager.approveRegistration();
                    break;
                case 5:
                    manager.addNews();
                    break;
                case 6:
                    manager.scrollNews();
                    break;
                case 7:
                    manager.viewRequests();
                    break;
                case 8:
                    exitSystem = false;
                    return;
            }
        }
    }

    /**
     * Handles the tech support specialist-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the tech support specialist user is not found in the system
     */
    private void runTechSupportSpecialist(){
        TechSupportSpecialist techSupportSpecialist = (TechSupportSpecialist) user;
    }

    /**
     * Handles the dean-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the dean user is not found in the system
     */
    private void runDean(){
        Dean dean = (Dean) user;
    }

    /**
     * Handles the rector-specific menu and features within the University System.
     *
     * @throws IOException if an error occurs while reading input
     * @throws UserNotFound if the rector user is not found in the system
     */
    private void runRector(){
        Rector rector = (Rector) user;
    }


    private void changeLanguage() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------" + Data.getInstance().getText("language", lang) + "------------");
        System.out.println(Data.getInstance().getText("currentLanguage", lang) + lang.getText());
        System.out.println("1 -> Қазақша");
        System.out.println("2 -> Русский");
        System.out.println("3 -> English");

        int n = Integer.parseInt(bf.readLine());
        switch (n){
            case 1:
                lang = Language.KZ;
                break;
            case 2:
                lang = Language.RU;
                break;
            case 3:
                lang = Language.EN;
                break;

        }

    }
}
