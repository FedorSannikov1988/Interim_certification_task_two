package Model;

import java.util.List;

public interface FileOperatorMethods {

    List<String> readAllLines();

    void writeAllLines(List<String> lines);
}
