import java.util.Scanner;
import java.util.regex.*;
class patternm {
  
    // Function to validate the password.
    public static boolean
    isValidPassword(String password)
    {
  
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{5,10}$";
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }
  
    // Driver Code.
    public static void main(String args[])
    {
  
        // Test Case 1:
        Scanner in = new Scanner(System.in);
        String str= in.next();
        System.out.println(isValidPassword(str));
    
}
}
