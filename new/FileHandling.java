import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

// Custom user-defined exception demonstrating exception creation and throwing
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class FileHandling {

    public static void main(String[] args) {
        File inputFile = new File("new/programming.txt");
        // Fallback to relative path if run from within the new/ directory
        if (!inputFile.exists()) {
            inputFile = new File("programming.txt");
        }

        File outputFile = new File(inputFile.getParent() == null ? "file_summary.txt" : inputFile.getParent() + "/file_summary.txt");

        System.out.println("=== Java File I/O and Exception Handling Demo ===");
        System.out.println("Reading from: " + inputFile.getAbsolutePath());

        // Demonstrate File class methods
        System.out.println("File exists: " + inputFile.exists());
        System.out.println("File readable: " + inputFile.canRead());
        System.out.println("File size: " + inputFile.length() + " bytes");

        try {
            // Read and process file contents with custom exception check
            processFile(inputFile, outputFile);
            System.out.println("\nSuccessfully processed file and generated output report: " + outputFile.getName());
        } catch (FileNotFoundException e) {
            System.err.println("Catch Block [FileNotFoundException]: File was not found! " + e.getMessage());
        } catch (EmptyFileException e) {
            System.err.println("Catch Block [Custom EmptyFileException]: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Catch Block [IOException]: An I/O error occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally Block: Execution completed, resource cleanup verified.");
        }
    }

    // Demonstrates declaring exceptions with 'throws'
    public static void processFile(File input, File output) throws FileNotFoundException, EmptyFileException, IOException {
        if (!input.exists()) {
            throw new FileNotFoundException("Specified input file does not exist: " + input.getPath());
        }

        if (input.length() == 0) {
            // Demonstrates throwing custom exception with 'throw'
            throw new EmptyFileException("The file is empty. Cannot process empty file.");
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        // Reading using Scanner
        System.out.println("\n--- Sample Content Preview (First 5 lines via Scanner) ---");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(input);
            int previewCount = 0;
            while (fileScanner.hasNextLine() && previewCount < 5) {
                String line = fileScanner.nextLine();
                System.out.println("  " + line);
                previewCount++;
            }
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        // Reading full content using BufferedReader and counting
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(input));
            writer = new PrintWriter(new FileWriter(output));

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            // Writing report using PrintWriter
            writer.println("=========================================");
            writer.println("         FILE ANALYSIS SUMMARY REPORT    ");
            writer.println("=========================================");
            writer.println("Source File      : " + input.getName());
            writer.println("Total Lines      : " + lineCount);
            writer.println("Total Words      : " + wordCount);
            writer.println("Total Characters : " + charCount);
            writer.println("File Size (bytes): " + input.length());
            writer.println("=========================================");
            writer.flush();

            System.out.println("\n--- Analysis Statistics ---");
            System.out.println("Total Lines : " + lineCount);
            System.out.println("Total Words : " + wordCount);
            System.out.println("Total Chars : " + charCount);

        } finally {
            // Resource cleanup in finally block
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
