/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.employee;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import publics.student.DBStudent;
import publics.student.Student;
import publics.student.StudentJTable;
import publics.student.StudentJTableModel;
import publics.RowHeadersRenderer;
import ui.GUI;

/**
 *
 * @author jpainam
 * Created : 11 Nov 2013
 * Modification : 11 Nov 2013
 */
public class DisplayEmployee extends javax.swing.JPanel{

    /**
     * Creates new form DisplayEmployee
     */
    public DisplayEmployee() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtSearchEmployee = new javax.swing.JTextField();
        jbSearchEmployee = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbEditEmployee = new javax.swing.JButton();
        jbDeleteEmployee = new javax.swing.JButton();
        jbDetailsEmployee = new javax.swing.JButton();
        jscrollTableEmployee = new javax.swing.JScrollPane();

        jLabel9.setBackground(new java.awt.Color(222, 144, 144));
        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 160, 123));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LIST OF EMPLOYEE");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Table of employee"));

        jLabel1.setText("Search for an employee");

        jbSearchEmployee.setText("Search");
        jbSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchEmployeeActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jbEditEmployee.setText("Edit");
        jbEditEmployee.setToolTipText("Edit the selected Employee");
        jbEditEmployee.setEnabled(false);
        jbEditEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditEmployeeActionPerformed(evt);
            }
        });

        jbDeleteEmployee.setText("Delete");
        jbDeleteEmployee.setToolTipText("Delete the selected Employee");
        jbDeleteEmployee.setEnabled(false);
        jbDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteEmployeeActionPerformed(evt);
            }
        });

        jbDetailsEmployee.setText("Details");
        jbDetailsEmployee.setToolTipText("Find more details on the selected Employee");
        jbDetailsEmployee.setEnabled(false);
        jbDetailsEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetailsEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jbEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jbDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jbDetailsEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbEditEmployee)
                .addComponent(jbDeleteEmployee)
                .addComponent(jbDetailsEmployee))
        );

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableValueChanged(e);
            }
        });
        jscrollTableEmployee.setViewportView(table);
        jscrollTableEmployee.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscrollTableEmployee)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(390, 390, 390))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearchEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscrollTableEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchEmployeeActionPerformed
        ArrayList<Student> employee;
        employee = (ArrayList<Student>) DBStudent.searchStudent(jtSearchEmployee.getText());
        table.removeAll();
        table.setModel(new StudentJTableModel(employee));
      
        table.getColumnModel().getColumn(0).setHeaderValue("N°");
        table.getColumnModel().getColumn(0).setPreferredWidth(0x2);
        table.getColumnModel().getColumn(0).setWidth(0x2);
        Dimension d = table.getPreferredScrollableViewportSize();
        d.width = getPreferredSize().width;
        table.setPreferredScrollableViewportSize(d);
        table.setRowHeight(table.getRowHeight());
        RowHeadersRenderer rowRenderer = new RowHeadersRenderer();
        //gridStudent.setDefaultRenderer(String.class, rowRenderer); // This does not work
        table.getColumnModel().getColumn(0).setCellRenderer(rowRenderer);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_jbSearchEmployeeActionPerformed

    private void jbEditEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditEmployeeActionPerformed
        String ssn = getMatric();
        GUI g = GUI.getInstance();
        g.getContentPane().removeAll();
        //JOptionPane.showMessageDialog(null, "I here");
        //g.setContentPane(new EditEmployee(DBStudent.getData(ssn)));
        //JOptionPane.showMessageDialog(null, "I here again");
        g.repaint();
        g.pack();
 
    }//GEN-LAST:event_jbEditEmployeeActionPerformed
    private String getMatric(){
        int row = table.getSelectedRow();
        return table.getValueAt(row, 1).toString();
    }
    private void jbDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteEmployeeActionPerformed
        if(DBStudent.deleteData(getMatric())){
            JOptionPane.showMessageDialog(null, "Employee deleted with success");
            /* Retirer une ligne du tableau quand supprimer est ok */
            //table.updateUI();
            GUI g = GUI.getInstance();
            g.getContentPane().removeAll();
            g.setContentPane(new DisplayEmployee());
            g.repaint();
            g.pack();
        }else{
            JOptionPane.showMessageDialog(null, "Error in deleting the employee");
        }
    }//GEN-LAST:event_jbDeleteEmployeeActionPerformed

    private void jbDetailsEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetailsEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbDetailsEmployeeActionPerformed
    private void tableValueChanged(ListSelectionEvent e) {
        if(table.getSelectedRow()  >= 0){
            jbDeleteEmployee.setEnabled(true);
            jbEditEmployee.setEnabled(true);
            jbDetailsEmployee.setEnabled(true);
        }else{
            jbDeleteEmployee.setEnabled(false);
            jbEditEmployee.setEnabled(false);
            jbDetailsEmployee.setEnabled(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbDeleteEmployee;
    private javax.swing.JButton jbDetailsEmployee;
    private javax.swing.JButton jbEditEmployee;
    private javax.swing.JButton jbSearchEmployee;
    private javax.swing.JScrollPane jscrollTableEmployee;
    private javax.swing.JTextField jtSearchEmployee;
    // End of variables declaration//GEN-END:variables
    private StudentJTable table = new StudentJTable();
}
