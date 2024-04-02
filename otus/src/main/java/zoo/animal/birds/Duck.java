package zoo.animal.birds;

import zoo.animal.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying {
    String type ="Duck";
    @Override
    public String say(){
        return "Кря-кря";
    }
    @Override
    public  String fly(){
        return "Я умнею летать";
    }
    
    @Override
    public String toString(){
        return String.format("Привет утка, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s, я еще я %s", 
        name,age,getPadej(),weight,color.getName(),say(),fly());
    }
}
