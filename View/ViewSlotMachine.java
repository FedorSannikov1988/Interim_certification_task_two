package View;

import Controller.ControllerSlotMachine;
import Model.Toy;

import java.util.List;
import java.util.Scanner;

public class ViewSlotMachine implements ViewSlotMachineMethods {

    private ControllerSlotMachine controllerSlotMachine;

    private ValidationInputData validationInputData;

    public ViewSlotMachine(ControllerSlotMachine controllerSlotMachine,
                           ValidationInputData validationInputData) {

        this.controllerSlotMachine = controllerSlotMachine;
        this.validationInputData = validationInputData;
    }

    public void menu() {

        Commands managementCommands;

        viewHi();

        while (true) {

            String command = viewPrompt("Введите команду для игрового автомата: ");

            try {

                managementCommands = Commands.valueOf(command.toUpperCase());

                switch (managementCommands) {
                    case HELP:
                        viewAllCommands();
                        break;
                    case VIEW_CONTENT_SLOTMACHINE:
                        viewAllToyInSlotMachine();
                        break;
                    case ADD_TOYS:
                        viewAddOneNewTypeToy();
                        break;
                    case CHANGE_QUANTITY_TOYS:
                        viewСhangeQuantityToy();
                        break;
                    case START_SLOTMACHINE:
                        viewStartSlotMachine();
                        break;
                    case EXIT:
                        viewExit();
                        return;
                }
            }
            catch (Exception ex) {

                viewErrorMessage(ex.getMessage());
            }
        }
    }

    @Override
    public void viewErrorMessage(String textError) {

        boolean flagMessage = textError.contains("No enum constant");

        if (flagMessage) {

            System.out.println("Комманда не найдена");
        }
        else {

            System.out.println(textError);
        }
    }

    @Override
    public void viewHi() {

        System.out.print("\n" + "Начни работу с команды HELP" + "\n"
                + "Регистр при вводе команд значения не имеет" + "\n"+ "\n");

        System.out.print("\n" + "Если автомат пуст заряди его" + "\n"
                + "с помощью команды: add_toys" + "\n"+ "\n");
    }

    @Override
    public String viewPrompt(String message) {

        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    @Override
    public void viewAllCommands() {

        Commands[] arrayCommand = Commands.values();

        System.out.print("\n"+"Список имеющихся команд:"+"\n");
        for (Commands item: arrayCommand) {
            System.out.println(item);
        }
        System.out.print("\n");
    }

    @Override
    public void viewAllToyInSlotMachine() {

        List<Toy> allToy = controllerSlotMachine.controllerGetAllToy();

        if (!allToy.isEmpty()){
            System.out.print("\n");
            for (Toy oneToy : allToy) {
                System.out.println(oneToy);
            }
            System.out.print("\n");
        }
        else {
            System.out.print("В автомате нет игрушек для розыгрыша"+"\n");
        }
    }

    @Override
    public void viewAddOneNewTypeToy() throws Exception {

        Toy newTypeToy = inputNewTypeToy();

        controllerSlotMachine.controllerAddOneNewTypeToy(newTypeToy);
    }

    @Override
    public void viewСhangeQuantityToy() throws Exception {

        String toyId = viewPrompt("Уникальный номер контейнера с игрушками количество которых вы бы хотели изменить: ");
        String changeQuantityToyOneType = viewPrompt("Новое значение количества выбранных игрушек: ");

        validationInputData.validateIdToy(toyId);
        validationInputData.validateQuantityNewToy(changeQuantityToyOneType);

        controllerSlotMachine.controllerСhangeQuantityToy(toyId, changeQuantityToyOneType);
    }

    @Override
    public void viewStartSlotMachine() throws Exception {

        Toy winToy = controllerSlotMachine.controllerStartSlotMachine();

        System.out.println("\n"+"Вы выйграли игрушку: " + winToy.getTitleToy() +
                " с чаcтотой выпадения: " + winToy.getFrequencyFallingOutToy()+"\n");
    }

    @Override
    public void viewExit() {

        System.out.println("Мы ждем Вас снова !");
    }

    private Toy inputNewTypeToy() throws Exception {

        String titleNewToy = viewPrompt("Название игрушки: ");
        String quantityNewToy = viewPrompt("Количество: ");
        String frequencyFallingOutToyNewToy = viewPrompt("Частота выпадения в % (вводить только латинские цифры): ");

        validationInputData.validateQuantityNewToy(quantityNewToy);
        validationInputData.validateFrequencyFallingOutToy(frequencyFallingOutToyNewToy);

        return new Toy(titleNewToy, quantityNewToy, frequencyFallingOutToyNewToy+"%");
    }
}
