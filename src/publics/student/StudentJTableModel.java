
package publics.student;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jpainam
 * Created : 11 Nov 2013
 * Modification : 11 Nov 2013
 */
public class StudentJTableModel extends AbstractTableModel{
    private String[] columns = {"ID", "MATRIC", "First Name", "Last Name", "Middle Name", ""};
    private static ArrayList<Student> data = new ArrayList<>();
    /**
     * Constructor
     */
    public StudentJTableModel(){
        data.clear();
        data.addAll(DBStudent.getData());
    }
    public StudentJTableModel(ArrayList<Student> ls){
        data.clear();
        data.addAll(ls);
    }
    public String[] getColumns() {
        return columns;
    }

    public ArrayList<Student> getData() {
        return data;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student e = data.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return "" + (rowIndex + 1);
            case 1 : return e.getMatric();
            case 2 : return e.getFirstname();
            case 3 : return e.getLastname();
            //case 4 : return e.getJobTitle();
            case 5 : return e.getPhone();
        }
        return "";
    }
    public Student getRow(int i){
        return data.get(i);
    }
    /**
     * function used for testing
     */
    public static void test(){
       for(Student e : data){
           System.out.println(e.toString());
       }
    }
    
}
