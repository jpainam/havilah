/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.garment.AddGarment;
import ui.garment.DisplayGarment;
import ui.employee.AddEmployee;
import ui.employee.DisplayEmployee;

/**
 *
 * @author jpainam
 */
public final class GUI extends javax.swing.JFrame {
    public static volatile GUI instance = null;
  
    public static GUI getInstance(){
        if(GUI.instance == null){
            synchronized(GUI.class){
                if(GUI.instance == null)
                    GUI.instance = new GUI();
            }
        }
        return GUI.instance;
    }
    /**
     * Creates new form GUI
     */
    public GUI() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jmenuBar = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmAccount = new javax.swing.JMenu();
        jmDisplayAccount = new javax.swing.JMenuItem();
        jmAddAccount = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmDisplayEmployee = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmAddCustomer = new javax.swing.JMenuItem();
        jmAddEmployee = new javax.swing.JMenuItem();
        jmAddManager = new javax.swing.JMenuItem();
        jmAddGarment = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dry cleaning 1.0");
        setBounds(new java.awt.Rectangle(200, 50, 700, 300));
        setPreferredSize(new java.awt.Dimension(835, 550));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jmFile.setText("File");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/connect.png"))); // NOI18N
        jMenuItem7.setText("Connect");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmFile.add(jMenuItem7);
        jmFile.add(jSeparator3);

        jmAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/account.png"))); // NOI18N
        jmAccount.setText("Account");

        jmDisplayAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/display_account.png"))); // NOI18N
        jmDisplayAccount.setText("Display Account");
        jmAccount.add(jmDisplayAccount);

        jmAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_account.png"))); // NOI18N
        jmAddAccount.setText("Add Account");
        jmAccount.add(jmAddAccount);

        jmFile.add(jmAccount);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.png"))); // NOI18N
        jMenuItem8.setText("Exit");
        jmFile.add(jMenuItem8);

        jmenuBar.add(jmFile);

        jmEdit.setText("View");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/display_customer.png"))); // NOI18N
        jMenuItem2.setText("Customer Details");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmEdit.add(jMenuItem2);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/display_inventory.png"))); // NOI18N
        jMenuItem5.setText("Check Inventory");
        jmEdit.add(jMenuItem5);
        jmEdit.add(jSeparator2);

        jmDisplayEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/display_employee.png"))); // NOI18N
        jmDisplayEmployee.setText("Display Employee");
        jmDisplayEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDisplayEmployeeActionPerformed(evt);
            }
        });
        jmEdit.add(jmDisplayEmployee);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/display_garment.png"))); // NOI18N
        jMenuItem3.setText("Display Garment");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmEdit.add(jMenuItem3);

        jmenuBar.add(jmEdit);

        jMenu1.setText("Operation");

        jmAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user.png"))); // NOI18N
        jmAddCustomer.setText("Add Customer");
        jMenu1.add(jmAddCustomer);

        jmAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/employee.png"))); // NOI18N
        jmAddEmployee.setText("Add Employee");
        jmAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(jmAddEmployee);

        jmAddManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/groupe.png"))); // NOI18N
        jmAddManager.setText("Add Manager");
        jMenu1.add(jmAddManager);

        jmAddGarment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_garment.png"))); // NOI18N
        jmAddGarment.setText("Add Garment");
        jmAddGarment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddGarmentActionPerformed(evt);
            }
        });
        jMenu1.add(jmAddGarment);

        jmenuBar.add(jMenu1);

        jMenu3.setText("Order");

        jMenuItem11.setText("Checkout");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Edit order");
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Place an order");
        jMenu3.add(jMenuItem13);

        jmenuBar.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/help.png"))); // NOI18N
        jMenuItem9.setText("Help");
        jMenu2.add(jMenuItem9);
        jMenu2.add(jSeparator1);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/aboutus.png"))); // NOI18N
        jMenuItem10.setText("About us");
        jMenuItem10.setToolTipText("Form about us");
        jMenu2.add(jMenuItem10);

        jmenuBar.add(jMenu2);

        setJMenuBar(jmenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddEmployeeActionPerformed
        try{
            //JOptionPane.showMessageDialog(null, "Ceci est le clic");
            this.setContentPane(new AddEmployee());
            this.repaint();
            this.pack();
            //JOptionPane.showMessageDialog(null, "Ceci est le clic");
        }catch(IllegalStateException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jmAddEmployeeActionPerformed

    private void jmDisplayEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDisplayEmployeeActionPerformed
        try{
            //JOptionPane.showMessageDialog(null, "Ceci est le clic");
            this.setContentPane(new DisplayEmployee());
            this.repaint();
            this.pack();
            //JOptionPane.showMessageDialog(null, "Ceci est le clic");
        }catch(IllegalStateException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jmDisplayEmployeeActionPerformed

    private void jmAddGarmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddGarmentActionPerformed
        try{
            this.setContentPane(new AddGarment());
            this.repaint();
            this.pack();
        }catch(IllegalStateException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jmAddGarmentActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
            this.getContentPane().removeAll();
            this.setContentPane(new DisplayGarment());
            this.repaint();
            this.pack();
        }catch(IllegalStateException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu jmAccount;
    private javax.swing.JMenuItem jmAddAccount;
    private javax.swing.JMenuItem jmAddCustomer;
    private javax.swing.JMenuItem jmAddEmployee;
    private javax.swing.JMenuItem jmAddGarment;
    private javax.swing.JMenuItem jmAddManager;
    private javax.swing.JMenuItem jmDisplayAccount;
    private javax.swing.JMenuItem jmDisplayEmployee;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmenuBar;
    // End of variables declaration//GEN-END:variables
    
}
