package Model;

import java.util.ArrayList;
import java.util.List;

public class SlotMachine implements SlotMachineMethods {

    private FileOperator fileOperator;

    private TemplateForToy templateForToy;

    public SlotMachine(FileOperator fileOperator, TemplateForToy templateForToy) {
        this.fileOperator = fileOperator;
        this.templateForToy = templateForToy;
    }

    @Override
    public List<Toy> getAllToy() {

        List<Toy> allToy = new ArrayList<>();

        List<String> allLinesReadFromFile = fileOperator.readAllLines();

        for (String oneLine : allLinesReadFromFile) {

            allToy.add(templateForToy.templateForRead(oneLine));

        }

        return allToy;

    }

    @Override
    public void setAllToy(List<Toy> toys) {

        List<String> allLinesWriteFromFile = new ArrayList<>();

        for (Toy toy: toys) {

            allLinesWriteFromFile.add(templateForToy.templateForWrite(toy));

        }

        fileOperator.writeAllLines(allLinesWriteFromFile);

    }

    @Override
    public void addOneNewTypeToy(Toy toy) {

        List<Toy> allNoteInFile = getAllToy();

        int max = 0;

        for (Toy oneNoteInFile : allNoteInFile) {

            int idToy = Integer.parseInt(oneNoteInFile.getIdToy());

            if (max < idToy) {
                max = idToy;
            }
        }

        int newIdToy = max + 1;

        String id = String.format("%d", newIdToy);

        toy.setIdToy(id);
        allNoteInFile.add(toy);
        setAllToy(allNoteInFile);
    }
}
