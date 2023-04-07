package Model;

public class TemplateForToy {

    public Toy templateForRead(String oneLine) {

        String[] partsForToy = oneLine.split(";");

        return new Toy(partsForToy[0],
                partsForToy[1],
                partsForToy[2],
                partsForToy[3]);
    }

    public String templateForWrite(Toy toy) {

        return(   toy.getIdToy() + ";"
                + toy.getTitleToy() + ";"
                + toy.getQuantityToy() + ";"
                + toy.getFrequencyFallingOutToy()+ ";");

    }



}
