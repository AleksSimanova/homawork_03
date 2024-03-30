package zoo.factory;

import zoo.animal.AbsAnimal;
import zoo.animal.birds.Duck;
import zoo.animal.exceptons.AnimalNotSupported;
import zoo.animal.pets.Cat;
import zoo.animal.pets.Dog;
import zoo.data.AnimalData;

public class AnimalFactory {

    public AbsAnimal create (AnimalData animaData) throws AnimalNotSupported{ 
        switch (animaData) {
            case DOG:{
                return new Dog();
            }  
                
            case CAT:{
                return new Cat();
            }
            case DUCK:{
                return new Duck();
            }
        }
            throw new AnimalNotSupported(animaData);
            
        }

    }
