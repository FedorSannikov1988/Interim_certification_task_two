package View;

public interface ViewSlotMachineMethods {

    void viewHi();

    void viewExit();

    void viewAllCommands();

    void viewErrorMessage(String textError);

    String viewPrompt(String message);

    void viewAllToyInSlotMachine();

    void viewAddOneNewTypeToy() throws Exception;

    void viewСhangeQuantityToy() throws Exception;

    void viewStartSlotMachine() throws Exception;
}
