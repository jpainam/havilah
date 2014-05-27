
package publics.garment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Database.DataModel;
import static utils.Database.DataModel.getConnection;

/**
 *
 * @author jpainam
 */
public class DBGarment extends DataModel<Garment>{
    

    public static List<Garment> getData() {
        List<Garment> list = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT GarmentNo, StockName, Price, PriceBump FROM garment ORDER BY GarmentNo");
            setMetaData(rs.getMetaData());
            while(rs.next()){
                Garment gar = new Garment(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                list.add(gar);
            }
            rs.close();
            stmt.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
   }
    /**
     * Search employees in the database
     * @param keyword search the likeness of this word from the database
     * @return a list of searched employee
     */
    public static List<Garment> searchGarment(String keyword){
        List<Garment> garment = new ArrayList<>();
        String query = "SELECT SSN FROM employee e "
                + "WHERE SSN LIKE ? OR EFName LIKE ? OR ELName LIKE ? "
                + "OR Phone LIKE ? OR Pin LIKE ? OR Address LIKE ? "
                + "OR Sex LIKE ? OR DOB LIKE ? OR "
                + "(SELECT TITLE FROM job b WHERE b.IdJob = e.JobTitle) LIKE ? ";
        try{
            //Query query = session.CreateQuery();
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* fill the params */
            for(int i = 1; i <= 9; i++){
                stmt.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Garment st = getData(rs.getString(1));
                //System.out.print("\n Matric: " + st.getFname() + "\t" + st.getLname()+ "\n");
                garment.add(st);
            }
            rs.close();
            stmt.close();
            return garment;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return garment;
    }
    public static Garment getData(String key) {
        Garment garment = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT SSN, EFName, ELName, DOB, JobTitle, "
                    + "Address, Phone, Sex, Pin FROM employee WHERE SSN = ?");
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Garment(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
            }else
                return garment;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return garment;
    }

    public static boolean addData(Garment emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean deleteData(String matric) {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM employee WHERE SSN = ?");
            stmt.setString(1, matric);
            int nb = stmt.executeUpdate();
            if(nb == 0)
                return false;
            else
                return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateData(Garment e) {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE employee "
                    + "SET SSN = ? , SET EFName = ? , SET ELName = ? , SET JobTitle = ? , SET Pin = ?, "
                    + "SET Address = ? , SET Phone = ?, SET DOB = ?, SET Sex = ? "
                    + "WHERE SSN = ?");
            /*stmt.setString(1, e.getMatric());
            stmt.setString(2, e.getMatric());
            stmt.setString(3, e.getMatric());
            stmt.setString(4, e.getMatric());
            stmt.setString(5, e.getMatric());
            stmt.setString(6, e.getMatric());
            stmt.setString(7, e.getMatric());
            stmt.setString(8, e.getMatric());
            stmt.setString(9, e.getMatric());*/
            int nb = stmt.executeUpdate();
            if(nb == 0)
                return false;
            else
                return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }


    public boolean storeData(List<Garment> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * send the employee e to the database
     * @param e
     * @return  true or false if the operation is successful
     */
    public static boolean storeData(Garment g) {
        //System.out.println(g.toString());
        try{
            String query = "INSERT INTO employee (SSN, EFName, ELName, JobTitle, Pin, "
                    + "Address, Phone, DOB, Sex) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* fill the parameters */
            /*stmt.setString(1, e.getMatric());
            stmt.setString(2, e.getFname());
            stmt.setString(3, e.getLname());
            stmt.setInt(4, e.getJob().getIdJob());
            stmt.setString(5, e.getPin());
            stmt.setString(6, e.getAddress());
            stmt.setString(7, e.getPhone());
            stmt.setDate(8, e.getDob());
            stmt.setString(9, e.getSex());*/
            int nber = stmt.executeUpdate();
            if(nber == 0)
                return false;
            else
                return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void idExist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
