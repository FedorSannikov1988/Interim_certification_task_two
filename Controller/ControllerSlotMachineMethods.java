package Controller;

import Model.Toy;

import java.util.List;

public interface ControllerSlotMachineMethods {

    void controllerAddOneNewTypeToy(Toy toy);

    List<Toy> controllerGetAllToy();

    void controllerСhangeQuantityToy(String noteId, String newQuantityToy) throws Exception;

    Toy controllerStartSlotMachine() throws Exception;
}
