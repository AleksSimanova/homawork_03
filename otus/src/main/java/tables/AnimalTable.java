package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import db.MySQLConnector;
import objects.Animal;


public class AnimalTable  extends AbsTable{

    public AnimalTable() {
        super("animals");
        columns.put("id","bigint PRIMARY KEY AUTO_INCREMENT" );
        columns.put("type", "varchar(15)");
        columns.put("name", "varchar(15)");
        columns.put("color", "varchar(15)");
        columns.put("weight", "int");
        columns.put("age", "int");
        create();
    }
//---------- добавление в бд
    public void insert(Animal animal){
        db= new MySQLConnector();
        String sqlQuery=String.format("INSERT INTO %s(type,name,color,weight,age)"+"VALUES('%s','%s','%s','%d','%d')",
                tableName,
                animal.getType(),animal.getName(),animal.getColor(),animal.getWeight(),animal.getWeight(),animal.getAge());
        db.executeRequest(sqlQuery);
        db.close();
    }
    

//-------------  запрос на получение всего списка животных
    public ArrayList<Animal> selectAllAnimals(){
        String sqlQuery=String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }


//---------- запрос с сортировкой по типу
    public ArrayList<Animal>selectByType(String type){
        String sqlQuery=String.format("SELECT * FROM %s WHERE type=%s", tableName ,type);
        return selectByQuery(sqlQuery);
    }


//- просмотр полученых с бд животных
    public ArrayList<Animal> selectByQuery(String sqlQuery){
        ArrayList<Animal>animals= new ArrayList<>();
        db=new MySQLConnector();
        ResultSet rs= db.executeResultWithAnswer(sqlQuery);
        try {
            while(rs.next()){
                animals.add(new Animal(
                    rs.getLong("id"),
                    rs.getString("type"),
                    rs.getString("name"),
                    rs.getString("color"),
                    rs.getInt("weight"),
                    rs.getInt("age")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }finally{
            db.close();
        }return animals;
    }
    
//------- измениние типа , по номеру id
    public void update( String newTypeAnimal, int id){
        
        String sqlUpDateTable=String.format("UPDATE %s SET type = %s WHERE id=",tableName,newTypeAnimal, id);
        db=new MySQLConnector();
        db.executeRequest(sqlUpDateTable);
    }


//=------- удаление таблицы
    public void delete(){
        db=new MySQLConnector();
        String sqlQuery=String.format("DROP TABLE %s;", tableName);
        db.executeRequest(sqlQuery);
        db.close();
    }
}
