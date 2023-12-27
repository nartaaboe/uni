package Contents;

import Users.User;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Represents a file with information such as path and owner.
 */
public class CFile {
    /** The path of the file. */
    private String path;

    /** The owner of the file. */
    private User owner;

    /**
     * Constructs a new File with the specified path and owner.
     *
     * @param path  The path of the file.
     * @param owner The owner of the file.
     */
    public CFile(String path, User owner) {
        this.path = path;
        this.owner = owner;
    }

    /**
     * Calculates the size of the file and returns it in megabytes.
     *
     * @return The size of the file in megabytes.
     */
    private double getSizeMB() {
        try {
            Path filePath = Paths.get(path);
            long fileSizeInBytes = Files.size(filePath);
            return fileSizeInBytes / (1024.0 * 1024.0); // Convert bytes to megabytes
        } catch (Exception e) {
            System.err.println("Error calculating file size: " + e.getMessage());
            return 0.0;
        }
    }

    /**
     * Displays the content of the file.
     * This method simulates viewing the file.
     */
    public void viewFile() {
        System.out.println("Viewing file: " + path);
    }

    /**
     * Downloads the file.
     * This method simulates downloading the file.
     */
    public void downloadFile() {
        System.out.println("Downloading file: " + path);
    }

    /**
     * Returns a string representation of the file.
     *
     * @return A string representation of the file.
     */
    @Override
    public String toString() {
        return "File{" +
                "path='" + path + '\'' +
                ", owner=" + owner +
                ", sizeMB=" + getSizeMB() +
                '}';
    }

    /**
     * Checks if two files are equal.
     *
     * @param o The object to compare with this file.
     * @return true if the files are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CFile file = (CFile) o;
        return Objects.equals(path, file.path) && Objects.equals(owner, file.owner);
    }

    /**
     * Generates a hash code for the file.
     *
     * @return The hash code for the file.
     */
    @Override
    public int hashCode() {
        return Objects.hash(path, owner);
    }
}


