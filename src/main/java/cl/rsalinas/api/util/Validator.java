package cl.rsalinas.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static String REGULAR_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static String REGULAR_PASSWORD = "^(?=.*[0-9])"
                                                + "(?=.*[a-z])(?=.*[A-Z])"
                                                + "(?=.*[@#$%^&+=])"
                                                + "(?=\\S+$).{8,20}$";


     public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(REGULAR_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password){
        Pattern pattern = Pattern.compile(REGULAR_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
