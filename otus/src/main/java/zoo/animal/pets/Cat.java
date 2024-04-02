package zoo.animal.pets;

import zoo.animal.AbsAnimal;

public class Cat extends AbsAnimal {
    @Override
    public String getType(){
        return "Cat";
    }
    @Override
    public  String say(){
        return"Мяу";
    }
    @Override
    public String toString(){
        return String.format("Привет кошка, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s", 
        name,age,getPadej(),weight,color.getName(),say());
    }
}
