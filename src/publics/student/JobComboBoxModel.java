/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.student;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jpainam
 * Created : 07 Nov 2013
 * Modification : 07 Nov 2013
 */
public class JobComboBoxModel extends DefaultComboBoxModel<MyJob>{
    
    public JobComboBoxModel(Vector<MyJob> e) {
        super(e);
    }

    public JobComboBoxModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getSelectedItem() {
        return super.getSelectedItem();
    }

    @Override
    public MyJob getElementAt(int index) {
        return super.getElementAt(index); 
    }

    @Override
    public int getIndexOf(Object anObject) {
        /*if(anObject instanceof MyJob){
            MyJob obj = MyJob(anObject);
        }*/
        return super.getIndexOf(anObject);
    }
    
}