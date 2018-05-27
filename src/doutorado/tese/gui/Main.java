/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import java.awt.Dimension;
import java.io.File;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson Soares
 */
public class Main extends javax.swing.JFrame {

    private JDesktopPane desktop;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setExtendedState(NORMAL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        myDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        radioRetangulo = new javax.swing.JRadioButton();
        radioMeiaLua = new javax.swing.JRadioButton();
        closeDialog = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        callInternalFrame = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        grupo.add(radioRetangulo);
        grupo.add(radioMeiaLua);

        jLabel1.setText("Escolha a forma:");

        radioRetangulo.setText("Retangulo");

        radioMeiaLua.setText("Meia lua");

        closeDialog.setText("OK");
        closeDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myDialogLayout = new javax.swing.GroupLayout(myDialog.getContentPane());
        myDialog.getContentPane().setLayout(myDialogLayout);
        myDialogLayout.setHorizontalGroup(
            myDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDialogLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(myDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioMeiaLua)
                    .addComponent(radioRetangulo)
                    .addComponent(jLabel1)
                    .addComponent(closeDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        myDialogLayout.setVerticalGroup(
            myDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myDialogLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(radioRetangulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioMeiaLua)
                .addGap(18, 18, 18)
                .addComponent(closeDialog)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        callInternalFrame.setText("Call Internal Frame");
        callInternalFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callInternalFrameActionPerformed(evt);
            }
        });

        jButton1.setText("Show Personal Dialog");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Shape selectec:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(callInternalFrame)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(callInternalFrame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void callInternalFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callInternalFrameActionPerformed

        Object[] possibilities = {"ham", "spam", "yam"};
        String s = (String) JOptionPane.showInputDialog(
                null,
                "Complete the sentence:\n"
                + "\"Green eggs and...\"",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "ham");

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            System.out.println("Green eggs and... " + s + "!");
            return;
        }
    }//GEN-LAST:event_callInternalFrameActionPerformed

    private void closeDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeDialogActionPerformed
//        JRadioButton selection = (JRadioButton) grupo.getSelection();
        System.out.println("Selecionado: " + grupo.getSelection().toString());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_closeDialogActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        myDialog.setVisible(true);
        myDialog.setSize(new Dimension(350, 350));
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });

        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);

        String path = new File("src\\icon\\setaDir.png")
                .getAbsolutePath();
        System.out.println(path);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton callInternalFrame;
    private javax.swing.JButton closeDialog;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDialog myDialog;
    private javax.swing.JRadioButton radioMeiaLua;
    private javax.swing.JRadioButton radioRetangulo;
    // End of variables declaration//GEN-END:variables

}
