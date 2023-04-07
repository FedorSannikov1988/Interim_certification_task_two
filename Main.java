import Controller.ControllerSlotMachine;
import Model.FileOperator;
import Model.SlotMachine;
import Model.TemplateForToy;
import View.ValidationInputData;
import View.ViewSlotMachine;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        TemplateForToy templateForToy = new TemplateForToy();

        FileOperator fileOperator = new FileOperator("warehouse");

        SlotMachine slotMachine = new SlotMachine(fileOperator, templateForToy);

        ValidationInputData validationInputData = new ValidationInputData();

        ControllerSlotMachine controllerSlotMachine = new ControllerSlotMachine(slotMachine, validationInputData);

        ViewSlotMachine viewSlotMachine = new ViewSlotMachine(controllerSlotMachine, validationInputData);

        viewSlotMachine.menu();
    }
}