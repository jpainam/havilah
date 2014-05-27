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
    private Date dob;
    private MyJob job;
    private String address;
    private String phone;
    private String sex;
    public static volatile Student instance = null;
    private String pin;
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
    public Student(String SSN, String fname, String lname, Date dob, MyJob job, 
            String addr, String phone, String sex, String pin){
        this.matric = SSN;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.job = job;
        this.address = addr;
        this.phone = phone;
        this.sex = sex;
        this.pin = pin;
    }
    /**
     *
     * @param SSN ssn of the employee
     * @param fname his first name
     * @param lname his last name
     * @param dob his date of birth
     * @param job his job @see MyJob 
     * @param addr the address of the employee
     * @param phone the phone number
     * @param sex the sex type Enumerative
     * @param pin the password used for the connection
     * @param id the id, auto increment in the database
     */
    public Student(String SSN, String fname, String lname, Date dob, MyJob job, 
            String addr, String phone, String sex, String pin, int id){
        this.matric = SSN;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.job = job;
        this.address = addr;
        this.phone = phone;
        this.sex = sex;
        this.pin = pin;
        this.id = id;
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
        return "Employee [FName : " + this.getFname()+ ", LName : " + this.getLname() + 
                " Dob : " + this.getDob() + " PIN = " + pin + " ]";
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

    public String getJobTitle() {
        if(this.job != null)
            return this.job.getTitle();
        else
            return "";
    }

    public String getPin() {
        if(!this.pin.isEmpty())
            return this.pin;
        else
            return "";
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
    public MyJob getJob(){
        if(this.job == null)
            return this.job;
        else
            return new MyJob();
    }
}
