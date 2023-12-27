
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


        // Admin
        // username: admin
        // password: 123123

        // Course
        // code: CSCI2105
        // name: ADS

        // Teacher
        // username: b_baisakov
        // password: 789789
        // salary: 10000000.0

        // Manager
        // username: k_aigul
        // password: 159159

        // Student 1
        // username: e_sanzhar
        // password: 456456

        // Student 2
        // username: b_kaisar
        // password: 753753


        Authorization a = new Authorization();

        a.viewMenu();
        Data.getInstance().save();

    }
}
