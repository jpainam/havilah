package publics.student;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author jpainam
 * Created : 01 - Nov - 2013
 * Last Modification : 01 - Nov - 2013
 */
public final class Student{
    protected int id;
    private String matric;
    private String fname;
    private String lname;
    private String mname;
    private Date dob;
    private String address;
    private String phone;
    private String sex;
    private String parentno;
    private String parent;
    
    private static volatile Student instance = null;
    /**
     * Default constructor
     */
    public Student(){
        this.matric = new String();
        this.fname = new String();
        this.lname = new String();
        Calendar cal = Calendar.getInstance();
        this.dob = new Date(cal.getTimeInMillis());
    }
    public Student(int id, String matric, String fname, String lname, 
            String mname, String sex,Date dob, String address, 
                    String phone, String parentno, String parent){
        this.id = id;
        this.matric = matric;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.parent = parent;
        this.parentno = parentno;        
    }
    /**
     * Constructor by copy
     */
    public Student(Student e){
        this.setDob(e.getDob());
        this.setFname(e.getFname());
        this.setLname(e.getLname());
        this.setMatric(e.getMatric());
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }
    public void setId(int i){
        this.id = i;
    }
    /**
     * 
     * @param fname 
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    /**
     * 
     * @param lname 
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    /**
     * 
     * @return 
     */
    public int getId(){
        return this.id;
    }
    /**
     * 
     * @return 
     */
    public String getMatric() {
        if(!this.matric.isEmpty())
            return matric;
        else
            return "";
    }
    /**
     * 
     * @return 
     */
    public String getFname() {
        if(!this.fname.isEmpty())
            return fname;
        else
            return "";
    }
    /**
     * 
     * @return 
     */
    public String getLname() {
        if(!this.lname.isEmpty())
            return lname;
        else
            return "";
    }
    /**
     * 
     * @return 
     */
    public Date getDob() {
        if(this.dob.getTime() != 0)
            return dob;
        else{
            Calendar cal = Calendar.getInstance();
            return new Date(cal.getTimeInMillis());
        }
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return super.toString();
    }
    public final static Student getInstance(){
        if(Student.instance == null){
            synchronized(Student.class){
                if(Student.instance == null)
                    Student.instance = new Student();
            }
        }
        return Student.instance;
    }

    

    public String getAddress() {
        if(!this.address.isEmpty())
            return this.address;
        else
            return "";
    }

    public String getPhone() {
        if(!this.phone.isEmpty())
            return this.phone;
        else
            return "";
    }

    public String getSex() {
        if(!this.sex.isEmpty())
            return sex;
        else
            return "";
    }
}
