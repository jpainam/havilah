/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.List;
import java.util.Properties;


/**
 *
 * @author jpainam
 * A Generic class used to communicate with a database
 */
public abstract class DataModel<E> {
    /* Only one instance of the connection is needed */
    private static Connection connection = null;
    private static ResultSetMetaData metaData = null;
 
    public DataModel(){} 
    /**
     * Make a connection to the database and return one instance of type Connection
     * @return the connection to the database
     */
    public static Connection getConnection(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null || connection.isClosed()){
                Properties props = new Properties();
                props.put("user", "root");
                props.put("password", "");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/havilahdb", props);
            }
            return connection;
         }catch(SQLException | ClassNotFoundException ex){
             ex.printStackTrace();
         }
         return connection;
    }
    /**
     * 
     */
    public abstract void idExist();
    /**
     *
     * @return
     */
    public static ResultSetMetaData getMetaData(){
       return metaData;
      
    }
    public static void setMetaData(ResultSetMetaData r){
        metaData = r;
    }
    /**
     * Connect to the database and retrieve a list of type E elements
     * @return  a list of type E element
     */
   // public abstract List<E> getData();
    /**
     * Retrieve more information about this key in the database
     * @param key corresponding key in the database
     * @return Return more information key element
     */
   // public abstract E getData(String key);
    /*
     */
    /**
     * store in the database the list of element
     * @param list 
     * @return true or false if the operation is successful or not
     */
   // public abstract boolean storeData(List<E> list);
    /**
     * Expect an element of type E and store is to the database
     * @param e
     * @return true or false, if the operation is successful or not
     */
 //   public abstract boolean storeData(E e);
}
