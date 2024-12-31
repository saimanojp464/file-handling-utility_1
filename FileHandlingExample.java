import java.io.*;
import java.nio.file.*;

public class FileHandlingExample {

    // Create a new file and write to it
    public static void createFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Hello, this is a sample text in the file.\n");
            bufferedWriter.write("Java file handling is interesting!\n");
            bufferedWriter.close();
            System.out.println("File '" + filename + "' created and content written successfully!");
        } catch (IOException e) {
            System.out.println("Error creating or writing to the file: " + e.getMessage());
        }
    }

    // Append text to an existing file
    public static void appendToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("This is an additional line of text.\n");
            bufferedWriter.close();
            System.out.println("Text appended to '" + filename + "' successfully!");
        } catch (IOException e) {
            System.out.println("Error appending to the file: " + e.getMessage());
        }
    }

    // Read the content of a file
    public static void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("Content of '" + filename + "':\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file '" + filename + "' does not exist.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Check if the file exists
    public static void checkFileExists(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The file '" + filename + "' exists.");
        } else {
            System.out.println("The file '" + filename + "' does not exist.");
        }
    }

    // Delete the file
    public static void deleteFile(String filename) {
        try {
            Path path = Paths.get(filename);
            if (Files.deleteIfExists(path)) {
                System.out.println("File '" + filename + "' deleted successfully!");
            } else {
                System.out.println("The file '" + filename + "' does not exist, so it cannot be deleted.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "sample_file.txt";

        // Create a new file and write to it
        createFile(filename);

        // Read the file content
        readFile(filename);

        // Append new text to the file
        appendToFile(filename);

        // Read the file content again to see the changes
        readFile(filename);

        // Check if file exists
        checkFileExists(filename);

        // Delete the file
        deleteFile(filename);
    }
}
