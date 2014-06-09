package publics.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.Database.DataModel;
import static utils.Database.DataModel.getConnection;

/**
 *
 * @author jpainam
 */
public class DBStudent extends DataModel<Student> {

    /*
     *  Student(int id, String matric, String fname, String lname,
            String mname, String sex, Date dob, String address,
            String phone, String parentno, String parent, Department depart) {

     * */
    public static List<Student> getData() {
        List<Student> list = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.*, d.ID FROM student s "
                    + "LEFT JOIN department d ON d.ID = s.DEPARTMENT "
                    + "ORDER BY MATRIC");
            setMetaData(rs.getMetaData());
            while (rs.next()) {
                Department depart = DBDepartment.getData(rs.getString("ID"));
                
                Student stud = new Student(rs.getInt("ID"), rs.getString("MATRIC"),
                        rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
                        rs.getString("MIDDLENAME"), rs.getString("SEX"), rs.getDate("DOB"),
                        rs.getString("ADDRESS"), rs.getString("PHONE"), rs.getString("PARENTNO"), rs.getString("PARENT"),
                        depart);
                list.add(stud);
            }
            rs.close();
            stmt.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Search employees in the database
     *
     * @param keyword search the likeness of this word from the database
     * @return a list of searched employee
     */
    public static List<Student> searchStudent(String keyword) {
        List<Student> student = new ArrayList<>();
        String query = "SELECT MATRIC FROM student e "
                + "WHERE MATRIC LIKE ? OR FIRSTNAME LIKE ? OR LASTNAME LIKE ? "
                + "OR MIDDLENAME LIKE ? OR SEX LIKE ? OR PHONE LIKE ? "
                + "OR ADDRESS LIKE ? OR PARENTNO LIKE ? OR PARENT LIKE ? "
                + "OR (SELECT NAME FROM department d WHERE d.ID = s.DEPARTMENT) LIKE ? ";
        try {
            //Query query = session.CreateQuery();
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* fill the params */
            int nb = query.lastIndexOf("?");
            for (int i = 1; i <= nb; i++) {
                stmt.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student st = getData(rs.getString(1));
                //System.out.print("\n Matric: " + st.getFirstname() + "\t" + st.getLastname()+ "\n");
                student.add(st);
            }
            rs.close();
            stmt.close();
            return student;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return student;
    }

    public static Student getData(String key) {
        Student student = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM student WHERE MATRIC = ?");
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                //return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), 
                //    job, rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            } else {
                return student;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return student;
    }

    public static boolean addData(Student emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean deleteData(String matric) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM student WHERE MATRIC = ?");
            stmt.setString(1, matric);
            int nb = stmt.executeUpdate();
            if (nb == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateData(Student e) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE student "
                    + "SET SSN = ? , SET EFName = ? , SET ELName = ? , SET DEPARTMENT = ? , SET Pin = ?, "
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
            if (nb == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean storeData(List<Student> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * send the student e to the database
     *
     * @param e
     * @return true or false if the operation is successful
     */
    public static boolean storeData(Student e) {
        //System.out.println(e.toString());
        try {
            String query = "INSERT INTO student "
                    + "(MATRIC, FIRSTNAME, LASTNAME, MIDDLENAME, SEX, "
                    + "DOB, DEPARTMENT, ADDRESS, PHONE, PARENTNO, PARENT) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            /* fill the parameters */
            stmt.setString(1, e.getMatric());
            stmt.setString(2, e.getFirstname());
            stmt.setString(3, e.getLastname());
            stmt.setString(4, e.getMiddlename());
            stmt.setString(5, e.getSex());
            stmt.setDate(6, e.getDob());
            stmt.setInt(7, e.getDepartment().getId());
            stmt.setString(8, e.getAddress());
            stmt.setString(9, e.getPhone());
            stmt.setString(10, e.getParentNo());
            stmt.setString(11, e.getInfoParent());
            int nber = stmt.executeUpdate();
            if (nber == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void idExist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
