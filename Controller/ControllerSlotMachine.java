package Controller;

import Model.SlotMachine;
import Model.Toy;
import View.ValidationInputData;

import java.util.List;
import java.util.Random;

public class ControllerSlotMachine implements ControllerSlotMachineMethods {

    private SlotMachine slotmachine;

    private ValidationInputData validationInputData;

    public ControllerSlotMachine(SlotMachine slotmachine,
                                 ValidationInputData validationInputData) {

        this.slotmachine = slotmachine;
        this.validationInputData = validationInputData;
    }

    @Override
    public void controllerAddOneNewTypeToy(Toy toy) {

        slotmachine.addOneNewTypeToy(toy);
    }

    @Override
    public List<Toy> controllerGetAllToy() {

        return slotmachine.getAllToy();
    }

    @Override
    public void controllerСhangeQuantityToy(String noteId, String newQuantityToy) throws Exception {

        List<Toy> allToy = slotmachine.getAllToy();

        Toy foundToy = controllerSearchToyById(noteId, allToy);

        foundToy.setQuantityToy(newQuantityToy);

        slotmachine.setAllToy(allToy);
    }

    @Override
    public Toy controllerStartSlotMachine() throws Exception {

        List<Toy> allToy = slotmachine.getAllToy();

        validationInputData.validateFillingListToy(allToy);

        String randomIdToy = controllerGenerationRandomIdForToy(allToy);

        Toy winningToy = controllerSearchToyById(randomIdToy, allToy);

        int quantityWinningToyInt = Integer.parseInt(winningToy.getQuantityToy());

        controllerСhoosingActionForSlotMachine(quantityWinningToyInt, randomIdToy);

        return winningToy;
    }

    private void controllerСhoosingActionForSlotMachine(int quantityWinningToyInt, String randomIdToy) throws Exception {

        if (quantityWinningToyInt >= 2) {

            controllerСhangeQuantityToy(randomIdToy,
                    Integer.toString((quantityWinningToyInt - 1)));
        }
        else {

            controllerDeleteToyById(randomIdToy);
        }
    }

    private String controllerGenerationRandomIdForToy(List<Toy> allToy) {

        int maxId = controllerFaundMaxId(allToy);

        int minId = controllerFaundMinId(allToy);

        String randomIdToyStr = Integer.toString(controllerGenerationRandomNamberInInterval(maxId, minId));

        while (true) {

            for (Toy toy : allToy) {
                if (toy.getIdToy().equals(randomIdToyStr)) {
                    return randomIdToyStr;
                }
            }

            randomIdToyStr = Integer.toString(controllerGenerationRandomNamberInInterval(maxId, minId));
        }
    }

    private int controllerGenerationRandomNamberInInterval(int max, int min) {

        int delta = max - min;
        Random random = new Random();
        int randNambr = random.nextInt(delta + 1);
        return randNambr + min;
    }

    private int controllerFaundMaxId(List<Toy> allToy) {

        int maxId = 0;

        for (Toy toy : allToy) {

            int IdToyInt = Integer.parseInt(toy.getIdToy());

            if (IdToyInt > maxId) {
                maxId = IdToyInt;
            }
        }
        return maxId;
    }

    private int controllerFaundMinId(List<Toy> allToy) {

        int minId = Integer.parseInt(allToy.get(0).getIdToy());

        for (Toy toy : allToy) {

            int IdToyInt = Integer.parseInt(toy.getIdToy());

            if (IdToyInt < minId) {
                minId = IdToyInt;
            }
        }
        return minId;
    }

    private void controllerDeleteToyById(String deleteId) throws Exception {

        List<Toy> allToy = slotmachine.getAllToy();

        Toy faundToy = controllerSearchToyById(deleteId, allToy);

        allToy.remove(faundToy);

        slotmachine.setAllToy(allToy);
    }

    public Toy controllerSearchToyById(String toyId, List<Toy> allToy) throws Exception {

        for (Toy toy : allToy) {
            if (toy.getIdToy().equals(toyId)) {
                return toy;
            }
        }
        throw new Exception("Типа игрушек промаркированных таким образом нет");
    }
}
