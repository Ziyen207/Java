import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Random;

class Computer {
    public void displayInfo() {
        System.out.println("This is a general computer.");
    }
}

class PersonalComputer extends Computer {
    @Override
    public void displayInfo() {
        System.out.println("This is a Personal Computer (PC). Useful for home and office work.");
    }
}

class AppleMacintosh extends Computer {
    @Override
    public void displayInfo() {
        System.out.println("This is an Apple Macintosh (MAC). Known for its design and performance.");
    }
}

class Laptop extends Computer {
    @Override
    public void displayInfo() {
        System.out.println("This is a Laptop (Notebook). Portable and convenient for mobile work.");
    }
    
    public void displayInfo(String brand) {
        System.out.println("This is a " + brand + " Laptop.");
    }
}

public class Test {
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] randomStrings = new String[100];
        
        for (int i = 0; i < 100; i++) {
            randomStrings[i] = generateRandomString(10 + RANDOM.nextInt(6)); // Length between 10 and 15
        }
        
        // Create a new array of size 200 by inserting numbers at even positions
        String[] modifiedArray = new String[200];
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            modifiedArray[counter++] = String.valueOf(i % 10); // Insert number
            modifiedArray[counter++] = randomStrings[i]; // Insert original string
        }
        
        // Print the modified array
        for (String str : modifiedArray) {
            System.out.println(str);
        }
        
        // Decode the given encoded value
        String encodedValue = "YXBwbGUlMjZvcmFuZ2U=";
        byte[] decodedBytes = Base64.getDecoder().decode(encodedValue);
        String decodedString = new String(decodedBytes, "UTF-8");
        decodedString = URLDecoder.decode(decodedString, "UTF-8");
        System.out.println("Decoded Strip Value: " + decodedString);
        
        // Demonstrating Polymorphism
        Computer pc = new PersonalComputer();
        Computer mac = new AppleMacintosh();
        Computer laptop = new Laptop();
        
        pc.displayInfo();
        mac.displayInfo();
        laptop.displayInfo();
        
        // Demonstrating Method Overloading
        Laptop specificLaptop = new Laptop();
        specificLaptop.displayInfo("Dell");
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }

    // Method to check if we can sum to a target value using given coin values
    public static boolean canSumFrom(int targetValue, int[] numbers) {
        boolean[] dp = new boolean[targetValue + 1];
        dp[0] = true;

        for (int i = 0; i <= targetValue; i++) {
            if (dp[i]) {
                for (int num : numbers) {
                    if (i + num <= targetValue) {
                        dp[i + num] = true;
                    }
                }
            }
        }
        return dp[targetValue];
    }
}
