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
public class DBDepartment extends DataModel{
    public DBDepartment(){
        super();
    }
    public static Department getData(String id){
        Department depart = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM department WHERE ID = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                return new Department(rs.getInt(1), rs.getString(2));
            else
                return depart;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return depart;
    }
    public static List<Department> getData(){
        List<Department> list = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM department ORDER BY NAME");
            while(rs.next()){
                list.add(new Department(rs.getInt(1), rs.getString(2)));
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
