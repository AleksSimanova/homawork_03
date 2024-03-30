package zoo.animal;
import zoo.data.ColorData;
public  abstract class AbsAnimal {
    protected String name;
    protected int age;
    protected int weight;
    protected ColorData color;
//---------------------------------------
    public void setName(String name){
        this.name=name;
    }
    
    public void setColor(ColorData color){
        this.color=color;
    }
    public void setAge(int age){
        this.age=age;
    }
    
    public void setWeight(int weight){
        this.weight=weight;
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