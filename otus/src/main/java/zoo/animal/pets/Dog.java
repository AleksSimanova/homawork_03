package zoo.animal.pets;

import zoo.animal.AbsAnimal;

public class Dog extends AbsAnimal {
    @Override
    public String say(){
        return "Гав-Гав" ;
    }
    @Override
    public String toString(){
        return String.format("Привет cобака, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s", 
        name,age,getPadej(),weight,color.getName(),say());
    }
}
