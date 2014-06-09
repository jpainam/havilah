
package publics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import publics.exceptions.Exceptions;
import utils.Database.DataModel;
import static utils.Database.DataModel.getConnection;

/**
 *
 * @author jpainam
 * created : 01 - Nov - 2013
 * Last Modification : 04 - June - 2014
 */
public class DBUsers extends DataModel<Users>{
    /**
     * 
     * @return 
     */
    public static List<Users> getData() {
        List<Users> users = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY IDUSER");
            while(rs.next()){
                users.add(new Users(rs.getInt("IDUSER"), rs.getString("LOGIN"),
                        rs.getString("PASSWORD"), rs.getString("PROFILE")));
            }
            rs.close();
            stmt.close();
            return users;
        }catch(SQLException ex){
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    /**
     * 
     * @param key
     * @return 
     */
    public static Users getData(String key) {
        Users user = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM users WHERE LOGIN = ?");
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user = new Users(rs.getString("LOGIN"), rs.getString("PASSWORD"));
            }
            rs.close();
            stmt.close();
            return user;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return user;
    }
    /**
     * 
     * @param list
     * @return 
     */
    public boolean storeData(List<Users> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param e
     * @return 
     */
    public boolean storeData(Users e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void idExist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
