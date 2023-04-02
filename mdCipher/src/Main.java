import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Input strings to hash and check for collisions
        String input1 = "Hi";
        String input2 = "See";
        String input3 = "There";
        String input4 = "Hi";

        // Hashes map to store hash values and their corresponding input strings
        Map<String, String> hashes = new HashMap<>();

        // Get instance of MessageDigest with MD5 algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Compute hash value of first input string
        byte[] mdBytes1 = md.digest(input1.getBytes());

        // Convert byte array representation of hash value to hexadecimal string
        String mdString1 = new BigInteger(1, mdBytes1).toString(16);

        // Store hash value and input string in hashes map
        hashes.put(mdString1, input1);

        // Print MD5 hash value of first input string
        System.out.println("MD5 Hash of '" + input1 + "' is: " + mdString1);

        // Compute hash value of second input string
        byte[] mdBytes2 = md.digest(input2.getBytes());

        // Convert byte array representation of hash value to hexadecimal string
        String mdString2 = new BigInteger(1, mdBytes2).toString(16);

        // Check if hash value already exists in hashes map
        if (hashes.containsKey(mdString2)) {
            String collisionInput = hashes.get(mdString2);
            System.out.println("Collision found between '" + input2 + "' and '" + collisionInput + "'");
        } else {
            // Store hash value and input string in hashes map
            hashes.put(mdString2, input2);

            // Print MD5 hash value of second input string
            System.out.println("MD5 Hash of '" + input2 + "' is: " + mdString2);

            System.out.println("No collision found");
        }

        // Compute hash value of third input string
        byte[] mdBytes3 = md.digest(input3.getBytes());

        // Convert byte array representation of hash value to hexadecimal string
        String mdString3 = new BigInteger(1, mdBytes3).toString(16);

        // Check if hash value already exists in hashes map
        if (hashes.containsKey(mdString3)) {
            String collisionInput = hashes.get(mdString3);
            System.out.println("Collision found between '" + input3 + "' and '" + collisionInput + "'");
        } else {
            // Store hash value and input string in hashes map
            hashes.put(mdString3, input3);

            // Print MD5 hash value of third input string
            System.out.println("MD5 Hash of '" + input3 + "' is: " + mdString3);

            System.out.println("No collision found");
        }

        // Compute hash value of fourth input string
        byte[] mdBytes4 = md.digest(input4.getBytes());

        // Convert byte array representation of hash value to hexadecimal string
        String mdString4 = new BigInteger(1, mdBytes4).toString(16);

        // Check if hash value already exists in hashes map
        if (hashes.containsKey(mdString4)) {
            String collisionInput = hashes.get(mdString4);
            System.out.println("Collision found between '" + input4 + "' and '" + collisionInput + "'");
        }else {
            // Store hash value and input string in hashes map
            hashes.put(mdString3, input4);

            // Print MD5 hash value of third input string
            System.out.println("MD5 Hash of '" + input4 + "' is: " + mdString4);

            System.out.println("No collision found");
        }
    }
}