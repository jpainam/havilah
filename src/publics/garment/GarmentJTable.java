/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.garment;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.tree.DefaultXTreeCellRenderer;

import publics.RowHeadersRenderer;
import ui.employee.DisplayEmployee;
import ui.GUI;
import ui.garment.DetailsGarment;

/**
 *
 * @author jpainam
 * Created : 14 Nov 2013
 * Modification : 14 Nov 2013
 */
public class GarmentJTable extends JTable implements MouseListener{
    private JPopupMenu popupMenu = new JPopupMenu();
    private int selectedLine;
    private int selectedCol;
    /**
     * 
     */
    public GarmentJTable(){
        initComponents();
    }
    /**
     * 
     */
    private void initComponents(){
        setModel(new GarmentJTableModel());
        addMouseListener(this);
        setColumnSelectionAllowed(false);
        setRowSelectionAllowed(true);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        /* pour la premiere colonne */
        getColumnModel().getColumn(0).setHeaderValue("N°");
        getColumnModel().getColumn(0).setPreferredWidth(0x2);
        getColumnModel().getColumn(0).setWidth(0x2);
        Dimension d = getPreferredScrollableViewportSize();
        d.width = getPreferredSize().width;
        setPreferredScrollableViewportSize(d);
        setRowHeight(getRowHeight());
        RowHeadersRenderer rowRenderer = new RowHeadersRenderer();
        //setDefaultRenderer(String.class, rowRenderer); // This does not work
        getColumnModel().getColumn(0).setCellRenderer(rowRenderer);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /* Context Menu */
        JMenuItem mnEdit = new JMenuItem("Edit" );
        mnEdit.setActionCommand("Edit" );
        mnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit_popup.png")));
        mnEdit.setToolTipText("Edit the selected Employee");
        /* Delete contex menu */
        JMenuItem mnDelete = new JMenuItem("Delete");
        mnDelete.setActionCommand("Delete");
        mnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete_popup.png")));
        mnDelete.setToolTipText("Delete the selected Employee");
        /** Details context menu */
        JMenuItem mnDetails = new JMenuItem("Show Details");
        mnDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/details_popup.png")));
        mnDetails.setActionCommand("Details");
        mnDetails.setToolTipText("Gives more details on this Employee");
        /* Assign a garment */
        JMenu mnGarment = new JMenu("Assign" );
        mnGarment.setActionCommand("Garment");
        mnGarment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assign_garment.png")));
        mnGarment.setToolTipText("Assign a garment to a selected employee");
        /* Exit context menu */
        JMenuItem mnExit = new JMenuItem("Exit");
        mnExit.setActionCommand("Exit");
        mnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit_popup.png")));
        mnExit.setToolTipText("Exit the context menu");
        /** add action listener to menu */
        mnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnEditActionPerformed();
            }
        });
        mnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnDeleteActionPerformed();
            }
        });
        mnDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnDetailsActionPerformed();
            }
        });
        
        mnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });
        for(int i = 0; i <= 10; i++){
            JMenuItem empl1 = new JCheckBoxMenuItem("Employee " + i);
            mnGarment.add(empl1);
        }
    
        popupMenu.add(mnEdit);
        popupMenu.add(mnDelete);
        popupMenu.add(new JPopupMenu.Separator());
        popupMenu.add(mnDetails);
        popupMenu.add(mnGarment);
        popupMenu.add(mnExit);
        
    }
    private void showPopup(MouseEvent e){
        Point p = new Point(e.getX(), e.getY());
        //System.out.println(columnAtPoint(p));
        selectedCol = columnAtPoint(p);
        selectedLine = rowAtPoint(p);
        clearSelection();
        if(selectedLine >= 0){
            this.setRowSelectionInterval(selectedLine, selectedLine);
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
     }
    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.print("Mouse Pressed\n");
        if(SwingUtilities.isRightMouseButton(e)){
            showPopup(e);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
  

    public int getSelectedCol() {
        return selectedCol;
    }
    public int getSelectedLine(){
        return this.selectedLine;
    }
    public String getId(){
        return this.getValueAt(selectedLine, 1).toString();
    }
    private void mnDetailsActionPerformed(){
        String id = getId();
        GUI g = GUI.getInstance();
        g.getContentPane().removeAll();
        g.setContentPane(new DetailsGarment());
        g.repaint();
        g.pack();
    }
    private void mnDeleteActionPerformed(){
        if(DBGarment.deleteData(getId())){
            JOptionPane.showMessageDialog(null, "Garment deleted with success");
            GUI g = GUI.getInstance();
            g.getContentPane().removeAll();
            g.setContentPane(new DisplayEmployee());
            //EmployeeJTable em = new EmployeeJTable();
            g.repaint();
            g.pack();
            //this.getParent().repaint();
         }else
            JOptionPane.showMessageDialog(null, "Error in deleting the Garment");
    }
    
    private void mnEditActionPerformed(){}
}
