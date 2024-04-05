package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import settings.ISettings;
import settings.PropertiesReader;


public class MySQLConnector implements IDBConnector{

    private static Connection connection = null;
    private static Statement statement = null;

    public MySQLConnector(){
        connect();
    }

    private void connect(){
        ISettings reader = new PropertiesReader();
        Map<String,String> settings= reader.read("SQLSettings.properties");
        if ( connection==null){
            try{
                connection=DriverManager.getConnection(
                    settings.get("url")+"/"+settings.get("db_name"),
                        settings.get("db_username"),
                        settings.get("db_password"));
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        if (statement==null){
            try{
                statement= connection.createStatement();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }



    public void executeRequest(String response){
        try {
            statement.execute(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeResultWithAnswer(String response){
        try {
                return statement.executeQuery(response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } return null;
    }

    public void close(){
        if(statement!=null){
            try{
                statement.close();
                statement = null;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}