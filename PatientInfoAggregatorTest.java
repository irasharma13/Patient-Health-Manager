import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.NoSuchElementException;


public class PatientInfoAggregatorTest {
    public static void main(String[] args) {
        try {
            // Create input file
            File inputFile = new File("input.txt");
            inputFile.createNewFile();

            // Write test input to file
            FileWriter inputWriter = new FileWriter(inputFile);
            inputWriter.write("ADD PATIENT 1 Ira Sharma\n");
            inputWriter.write("ADD PATIENT 2 Jane Smith\n");
            inputWriter.write("ADD EXAM 1 1\n");
            inputWriter.write("ADD EXAM 1 2\n");
            inputWriter.write("ADD EXAM 2 1\n");
            inputWriter.write("DEL PATIENT 2\n");
            inputWriter.write("DEL EXAM 1 2\n");
            inputWriter.close();

            // Run the PatientInfoAggregator program
            PatientInfoAggregator.main(new String[]{});

            // Check the output file for expected results
            File outputFile = new File("output.txt");
            Scanner outputScanner = new Scanner(outputFile);
            
            if (outputScanner.hasNextLine()) {
                String firstLine = outputScanner.nextLine();
                if (firstLine.equals("Name: Ira Sharma , Id: 1, Exam Count: 1")) {
                    System.out.println("Test passed");
                } else {
                    System.out.println("Test failed");
                }
            } else {
                System.out.println("Output file is empty");
            }
            
            outputScanner.close();
            
            outputScanner.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
