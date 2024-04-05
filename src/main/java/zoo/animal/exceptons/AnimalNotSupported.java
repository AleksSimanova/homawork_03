package zoo.animal.exceptons;

import zoo.data.AnimalData;

public class AnimalNotSupported  extends Exception {
    public AnimalNotSupported (AnimalData animaData){
        super (String.format(":Животное %s,на этой ферме не представлено", animaData.name()));
    }

}