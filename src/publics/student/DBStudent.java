
package publics.student;

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
public class DBStudent extends DataModel<Student>{
    

    public static List<Student> getData() {
        List<Student> list = new ArrayList<>();
        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SSN, EFName, ELName, DOB, JobTitle, "
                    + "Address, Phone, Sex, Pin FROM employee ORDER BY SSN");
            setMetaData(rs.getMetaData());
            while(rs.next()){
                MyJob job = DBJob.getData(rs.getString(5));
                Student emp = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), 
                        job, rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(emp);
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
    public static List<Student> searchEmployee(String keyword){
        List<Student> employee = new ArrayList<>();
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
                Student st = getData(rs.getString(1));
                //System.out.print("\n Matric: " + st.getFname() + "\t" + st.getLname()+ "\n");
                employee.add(st);
            }
            rs.close();
            stmt.close();
            return employee;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return employee;
    }
    public static Student getData(String key) {
        Student employee = null;
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT SSN, EFName, ELName, DOB, JobTitle, "
                    + "Address, Phone, Sex, Pin FROM employee WHERE SSN = ?");
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                MyJob job = DBJob.getData(rs.getString(5));
                return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), 
                        job, rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }else
                return employee;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return employee;
    }

    public static boolean addData(Student emp) {
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

    public static boolean updateData(Student e) {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE employee "
                    + "SET SSN = ? , SET EFName = ? , SET ELName = ? , SET JobTitle = ? , SET Pin = ?, "
                    + "SET Address = ? , SET Phone = ?, SET DOB = ?, SET Sex = ? "
                    + "WHERE SSN = ?");
            stmt.setString(1, e.getMatric());
            stmt.setString(2, e.getMatric());
            stmt.setString(3, e.getMatric());
            stmt.setString(4, e.getMatric());
            stmt.setString(5, e.getMatric());
            stmt.setString(6, e.getMatric());
            stmt.setString(7, e.getMatric());
            stmt.setString(8, e.getMatric());
            stmt.setString(9, e.getMatric());
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


    public boolean storeData(List<Student> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * send the employee e to the database
     * @param e
     * @return  true or false if the operation is successful
     */
    public static boolean storeData(Student e) {
        //System.out.println(e.toString());
        try{
            String query = "INSERT INTO employee (SSN, EFName, ELName, JobTitle, Pin, "
                    + "Address, Phone, DOB, Sex) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* fill the parameters */
            stmt.setString(1, e.getMatric());
            stmt.setString(2, e.getFname());
            stmt.setString(3, e.getLname());
           
            //stmt.setInt(4, e.getJob().getIdJob());
            stmt.setInt(4, 1);
            stmt.setString(5, e.getPin());
            stmt.setString(6, e.getAddress());
            stmt.setString(7, e.getPhone());
            stmt.setDate(8, e.getDob());
            stmt.setString(9, e.getSex());
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
