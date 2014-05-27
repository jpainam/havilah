/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.garment;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jpainam
 * Created : 14 Nov 2013
 * Modification : 14 Nov 2013
 */
public class GarmentJTableModel extends AbstractTableModel{
    private String[] columns = {"N°", "Garment ID", "Stock Name", "Stock Price", "Price Bump"};
    /**
     * 
     */
    private static ArrayList<Garment> data = new ArrayList<>();
    /**
     * 
     */
    public GarmentJTableModel(){
        data.clear();
        data.addAll(DBGarment.getData());
    }
    public GarmentJTableModel(ArrayList<Garment> list){
        data.clear();
        data.addAll(list);
    }
    /**
     * 
     * @return 
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Garment g = data.get(row);
        
        switch(column){
            case 0 : return "" + (row + 1);
            case 1 : return g.getGarmentNo();
            case 2 : return g.getStockName();
            case 3 : return g.getPrice();
            case 4 : return g.getPriceBump();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l);
    }
    
}
