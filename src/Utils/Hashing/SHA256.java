package Utils.Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class provides a static method to hash a string using the SHA-256 algorithm.
 */
public class SHA256 {

    /**
     * Generates a SHA-256 hash of the given string.
     *
     * @param str The input string to hash.
     * @return The hexadecimal representation of the SHA-256 hash.
     */
    public static String getHash(String str) {
        try {
            // Create a SHA-256 digest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Perform the hashing
            byte[] encodedhash = digest.digest(str.getBytes());

            // Convert byte array into signum representation
            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // Return the string in hexadecimal format
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) { // Catch block to handle the exception
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

}
