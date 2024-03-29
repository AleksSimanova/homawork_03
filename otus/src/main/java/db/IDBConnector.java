package db;

import java.sql.ResultSet;

public interface IDBConnector {
    
    void executeRequest(String response);
    
    ResultSet executeResultWithAnswer(String response);

    void close();
}
