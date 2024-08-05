package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Random;

public class Helper {

    public static boolean isNullOrEmpty(String str){
        if(str.isEmpty() || str.isBlank()){
            return true;
        }

            return false;

    }

    public static boolean isNullOrEmpty(int number){
        // You can't have a null integer, so we only check if it's less than or equal to zero.
        return number <= 0;
    }

    public static boolean isNullOrEmpty(double number){
        return number <=0;
    }

    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(1000); // Change 1000 to your desired range
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

    public static boolean isNumeric(String str) {
        if (isNullOrEmpty(str)) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

}
