
package cognifyzlevel2task;

 import java.util.Scanner;


public class PasswordStrengthChecker {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your desired Password: ");
        String password = scanner.nextLine();
        scanner.close();

        String strengthFeedback = checkPasswordStrength(password);
        System.out.println(strengthFeedback);

    }

    public static String checkPasswordStrength(String password) {

        // Define Criteria
        int lengthCriteria = 8;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialCharacters = "!@#$%^&*()_+[]{}|;:,.<>?~";

        // Check Length
        if(password.length() >= lengthCriteria) {

            // Check Other Criteria
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if(Character.isLowerCase(c)) {
                    hasLowercase = true;
                } else if(Character.isDigit(c)) {
                    hasDigit = true;
                } else if(specialCharacters.contains(String.valueOf(c))) {
                    hasSpecial = true;
                }
            }

            // Analyze Password Strength
            if(hasUppercase && hasLowercase && hasDigit && hasSpecial) {
                return "It is Strong Password!";
            } else {
                return "It is a Weak Password. Please include Uppercase Letters, Lowercase Letters, Numbers & Special Characters!";
            }
        } else {
            return "Password length must be at least " + lengthCriteria + " characters!";
        }
    }
    
}


