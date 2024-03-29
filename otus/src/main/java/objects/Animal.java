package objects;
public class Animal {
//-  для структурирования получаемых данных из таблицы
    private long id;
    private String type,name,color;
    private int weight,age;

//-  на получение из 
    public Animal( long id, String type, String name, String color, int weight,int age){
        this.id=id;
        this.type=type;
        this.name=name;
        this.color=color;
        this.weight=weight;
        this.age=age;
    }
    //- запрос на создание
    public Animal ( String type, String name, String color, int weight,int age){
        this.type=type;
        this.name=name;
        this.color=color;
        this.weight=weight;
        this.age=age;
    }

    public long getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getWeight(){
        return weight;
    }
    public int getAge(){
        return age;
    }
    public void  setId(long id){
        this.id= id;
    }
    public void  setType(String type){
        this.type= type;
    }
    public void  setName(String name){
        this.name= name;
    };
    public void  setColor(String color){
        this.color= color;
    };
    public void  setWeight(int weight){
        this.weight= weight;
    };
    public void  setAge(int age){
        this.age= age;}

    public String  toString (){
        return String.format("Animal: id= %s, type= %s, name= %s, color=%s, weight=%d, age=%d", id,  type,  name,  color,  weight, age);
    }
}

