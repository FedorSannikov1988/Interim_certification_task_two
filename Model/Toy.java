package Model;

public class Toy {

    private String idToy = "";

    private String titleToy = "";

    private String quantityToy = "";

    private String frequencyFallingOutToy = "";

    public Toy(String titleToy, String quantityToy, String frequencyFallingOutToy) {
        this.titleToy = titleToy;
        this.quantityToy = quantityToy;
        this.frequencyFallingOutToy = frequencyFallingOutToy;
    }

    public Toy(String idToy, String titleToy, String quantityToy, String frequencyFallingOutToy) {
        this(titleToy, quantityToy, frequencyFallingOutToy);
        this.idToy = idToy;
    }

    public String getIdToy() {
        return idToy;
    }

    public void setIdToy(String idToy) {
        this.idToy = idToy;
    }

    public String getTitleToy() {
        return titleToy;
    }

    public String getQuantityToy() {
        return quantityToy;
    }

    public void setQuantityToy(String quantityToy) {
        this.quantityToy = quantityToy;
    }

    public String getFrequencyFallingOutToy() {
        return frequencyFallingOutToy;
    }

    @Override
    public String toString() {
        return "Уникальный номер группы игрушек: " + idToy + " " + "Название игрушки: " + titleToy + " " +
                "Количество: " + quantityToy + " " + "Частота выпадения: " + frequencyFallingOutToy;
    }
}
