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
     * @return The SHA-256 hash of string.
     */
    public static String getHash(String str) {
        try {

            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = sha256.digest(str.getBytes());
            StringBuilder hexString = new StringBuilder(hashBytes.length * 2);
            for (byte b : hashBytes) {
                String s = Integer.toHexString(0xff & b);
                if (s.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(s);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

}
