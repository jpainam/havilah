/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.student;

/**
 *
 * @author jpainam
 */
public class MyJob {
    private int idJob;
    private String title;
    public MyJob(){
        idJob = (int)(Math.random() % 500);
        title = new String();
    }

    public MyJob(int id, String t) {
        idJob = id;
        title = t;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdJob() {
        return idJob;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
    
    
}
