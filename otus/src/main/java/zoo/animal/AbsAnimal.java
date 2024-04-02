package zoo.animal;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Schema.Validation;

import zoo.data.ColorData;
import zoo.utilit.EnamConvecters;
import zoo.utilit.Validators;

public  abstract class AbsAnimal {
    protected String name;
    protected int age;
    protected int weight;
    protected ColorData color;

    private EnamConvecters enamConvecters=new EnamConvecters();
    private Validators validators= new Validators(); 
//---------------------------------------

    public void setName(Scanner sc){
        String name="";
        while (true) {
            System.out.println("Введите имя животного");
            name= sc.next();
            if (validators.isStringChars(name)) {
                break;   
            }
            System.out.println("Введите именя животного состояшее из букв");
        }
        this.name=name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    
    public void setColor(Scanner sc){
        String colorDataStr="";
        while (true) {
            System.out.printf("Выбирете цвет животного из %s \n",enamConvecters.getNamesEnam(ColorData.class,"/"));
            colorDataStr=sc.next().toUpperCase();
            if(validators.checkValuesInEnam(ColorData.class,colorDataStr)){
                break;
            }
            System.out.printf("%s не представлен на данной ферме,выберите цвет из представленных в списке \n",colorDataStr);
            
        }
        
        this.color=ColorData.valueOf(colorDataStr);
    }

    public void setAge(Scanner sc){
        String ageStr;
        while (true) {
            System.out.println("Введите возраст животного");
            ageStr=sc.next();
            if (validators.isAgeNimbers(ageStr)&&Integer.parseInt(ageStr)>0){
                break;
            }
            System.out.println("возраст введен не корркутно");
        }
        this.age=Integer.parseInt(ageStr);
    }
    
    public void setWeight(Scanner sc){
        String weightSt;
        while (true){
            System.out.println("Введите вес животного");
            weightSt=sc.next();
        if (validators.isAgeNimbers(weightSt)&&Integer.parseInt(weightSt)>0){
            break;
        }
        System.out.println("Введите положительное число");
        }
        this.weight=Integer.parseInt(weightSt);
    }
    
//-------------------------------------
    public String getName(){
        return name;
    }
    
    public ColorData getColorData(){
        return color;
    }

    public int getAge(){
        return age;
    }

    public int getWeight(){
        return weight;
    }

    public abstract String getType();
//-----------------------------------
    public String  say(){
        return "Я говорю";
    }

    public void  go (){
        System.out.println( "Я иду");} 

    public  void  drink(){
            System.out.println( "Я пью");
    }
    
    public void eat(){
        System.out.println("я ем");
    }
//----------------------------------
@Override
    public String toString(){
        return String.format("Привет меня зовут %s, мне %s %s, я вещу %d кг, мой цвет %s", 
                            name,age,getPadej(),weight,color.getName());
    }

    protected String getPadej(){
        int remains=age % 10;
            if(age>=11&& age<=14){
                return "лет";
            }
            if(remains==1){
                return "год";
            }
            if(remains<5){
                return "года";
            }
            return "лет";
        
        
    }
}