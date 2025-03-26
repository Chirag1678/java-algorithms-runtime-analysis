import java.io.*;
import java.util.Random;

// Class to find file reading efficiency of FileReader and InputStreamReader
public class FileReadingComparison {
    public static void main(String[] args) {
        // Declare a variable to store the file path
        String fileName = "large_file.txt";

        // Describe different sizes for file
        int MB = 1024 * 1024;
        int[] sizes = {MB, 100 * MB, 500 * MB}; // 1MB, 100MB, 500MB

        // loop to generate file for different sizes and measure readers performance
        for(int size:sizes) {
            System.out.printf("Generating file of size: %dMB...\n", size / MB);
            generateFile(fileName, size);

            // compare time for reading file
            compareTime(fileName);
        }
    }

    // method to generate file
    static void generateFile(String fileName, int size) {
        // Use try-catch to handle exception
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();
            for(int i=0;i<size;i++) {
                bw.write((char)('A' + random.nextInt(26))); // Write random uppercase letters
            }
        } catch(IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // method to compare time of both readers
    static void compareTime(String fileName) {
        // Define start and endTime variables to store time
        long startTime, endTime;

        // FileReader time
        startTime = System.nanoTime();
        readFileUsingFileReader(fileName);
        endTime = System.nanoTime();
        long fileReaderTime = (endTime - startTime);
        System.out.printf("Time taken by file reader to read file: %.4fs\n", fileReaderTime / 1e9);

        // InputStreamReader Time
        startTime = System.nanoTime();
        readFileUsingInputStreamReader(fileName);
        endTime = System.nanoTime();
        long inputStreamTime = (endTime - startTime);
        System.out.printf("Time taken by input stream reader to read file: %.4fs\n\n", inputStreamTime / 1e9);
    }

    // method to read file using fileReader
    static void readFileUsingFileReader(String fileName) {
        try(FileReader fr = new FileReader(fileName)) {
            while(fr.read()!=-1);
        } catch(IOException e) {
            System.out.println("Error reading file using file reader: " + e.getMessage());
        }
    }

    // method to read file using inputStreamReader
    static void readFileUsingInputStreamReader(String fileName) {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))) {
            while(isr.read()!=-1);
        } catch(IOException e) {
            System.out.println("Error reading file using input stream reader: " + e.getMessage());
        }
    }
}
// Sample Output ->
// Generating file of size: 1MB...
// Time taken by file reader to read file: 0.1614s
// Time taken by input stream reader to read file: 0.0680s

// Generating file of size: 100MB...
// Time taken by file reader to read file: 3.8054s
// Time taken by input stream reader to read file: 3.5248s

// Generating file of size: 500MB...
// Time taken by file reader to read file: 18.2571s
// Time taken by input stream reader to read file: 17.9497s