/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Database.DataModel;

/**
 *
 * @author jpainam
 * Created : 07 Nov 2013
 * Modification : 08 Nov 2013
 */
public class DBJob extends DataModel{
    public DBJob(){
        super();
    }
    public static MyJob getData(String id){
        MyJob job = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM job WHERE IdJob = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                return new MyJob(rs.getInt(1), rs.getString(2));
            else
                return job;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return job;
    }
    public static List<MyJob> getData(){
        List<MyJob> list = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job ORDER BY TITLE");
            while(rs.next()){
                list.add(new MyJob(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void idExist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
