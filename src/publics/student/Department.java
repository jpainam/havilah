/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.student;

/**
 *
 * @author jpainam
 */
public class Department {
    private int id;
    private String name;
    private String shortname;
    private int hod;
   
    
    
    public Department(){
        id = (int)(Math.random() % 500);
        name = new String();
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return this.name;
    }
    
    
}
