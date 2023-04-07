package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperator implements FileOperatorMethods {

    private String fileName;

    public FileOperator(String fileName) {

        this.fileName = fileName + ".csv";

        try (FileWriter toСreateFile = new FileWriter(fileName + ".csv", true)) {
            toСreateFile.flush();
        } catch (IOException ex) {
            System.out.println("ALARM: ERROR: File:" + " " + fileName + " " + "not created");
        }
    }

    @Override
    public List<String> readAllLines() {

        List<String> allLinesFromFile = new ArrayList<>();

        try (FileReader readFile = new FileReader(fileName)) {

            BufferedReader forReadOneLine = new BufferedReader(readFile);

            String line = forReadOneLine.readLine();

            if (line != null) {
                allLinesFromFile.add(line);
            }
            while (line != null) {
                line = forReadOneLine.readLine();
                if (line != null) {
                    allLinesFromFile.add(line);
                }
            }
            forReadOneLine.close();
        }
        catch (IOException ex) {
            System.out.println("ALARM: ERROR: Specified file:" + " " + fileName + " " + "cannot be read");
        }
        return allLinesFromFile;
    }

    @Override
    public void writeAllLines(List<String> lines) {

        try (FileWriter fileToWrite = new FileWriter(fileName, false)) {

            for (String line : lines) {
                fileToWrite.write(line + "\n");
            }
            fileToWrite.flush();
        }
        catch (IOException ex) {
            System.out.println("ALARM: ERROR: Data is not written to the file");
        }
    }
}
