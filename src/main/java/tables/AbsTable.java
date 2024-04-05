package tables;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import db.IDBConnector;
import db.MySQLConnector;


public abstract class AbsTable {
    protected String tableName;
    protected Map<String,String>columns = new HashMap<>();

    IDBConnector db;

    public AbsTable (String tableName){
        this.tableName=tableName;

    }
    //- создание таблицы
    public void create(){
        String sqlRequest= String.format("CREATE TABLE IF NOT EXISTS %s (%s)", this.tableName, convertMapColumnsToString());
        db=new MySQLConnector();
        db.executeRequest(sqlRequest);
        db.close();
    }

    private String convertMapColumnsToString(){
        final String result = columns.entrySet().stream()
                                .map((Map.Entry entry)->String.format("%s %s", entry.getKey(),entry.getValue()))
                                .collect(Collectors.joining(", "));
        return result;
    }
// поменять color  -colorData
}
