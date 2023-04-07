package View;

import Model.Toy;

import java.util.List;

public class ValidationInputData {

    public void validateFrequencyFallingOutToy(String frequencyFallingOutToy) throws Exception {

        int frequencyFallingOutToyInt = 0;

        try {
            frequencyFallingOutToyInt = Integer.parseInt(frequencyFallingOutToy);
        }
        catch(Exception ex) {
            throw new Exception("Вы ввели не число при вводе процента выпадения игрушки!");
        }

        if (frequencyFallingOutToyInt < 1 || frequencyFallingOutToyInt > 100) {
            throw new Exception("Введенное число не может быть меньше 1-ого и больше 100-а % " +
                    "при вводе количества игрушек!");
        }
    }

    public void validateQuantityNewToy(String quantityToy) throws Exception {

        int quantityToyInt = 0;

        try {
            quantityToyInt = Integer.parseInt(quantityToy);
        }
        catch(Exception ex) {
            throw new Exception("Вы ввели не число при вводе количества игрушек!");
        }

        if (quantityToyInt <= 0 ) {
            throw new Exception("Введенное число не может быть меньше или равно нулю " +
                    "при вводе количества игрушек!");
        }
    }

    public void validateIdToy(String IdToy) throws Exception {

        int IdToyInt = 0;

        try {
            IdToyInt = Integer.parseInt(IdToy);
        }
        catch(Exception ex) {
            throw new Exception("Вы ввели не число при вводе уникального " +
                    "номера контейнера с одним типом игрушек!");
        }

        if (IdToyInt < 1 ) {
            throw new Exception("Введенное число не может быть меньше 1-ого " +
                    "при вводе уникального номера контейнера " +
                    "с одним типом игрушек!");
        }
    }

    public void validateFillingListToy(List<Toy> allToy) throws Exception {

        if (allToy.isEmpty()) {

            throw new Exception("В игровом автомате нет игрушек");
        }
    }
}
