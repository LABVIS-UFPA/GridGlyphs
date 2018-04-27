/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.visualizacao.grid.Grid;

/**
 *
 * @author Anderson Soares
 */
public class MainGrid extends javax.swing.JFrame {

    private Grid gridPanel;
//    private final JLayeredPane layerPane;

    /**
     * Creates new form MainGrid
     */
    public MainGrid() {
        initComponents();

//        layerPane = new JLayeredPane();
//        layerPane.add(painelEsquerda, 0, 0);//penultimo é a ordem das camadas
//        layerPane.setBounds(painelEsquerda.getBounds());
//        painelEsquerda.add(layerPane);
        gridPanel = new Grid();
        painelEsquerda.add(gridPanel);

//        gridPanel = new Grid(painelEsquerda.getBounds());
//        painelEsquerda.add(gridPanel);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painelEsquerda = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu15x24 = new javax.swing.JMenuItem();
        menu15x32 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        radio24 = new javax.swing.JRadioButtonMenuItem();
        radio28 = new javax.swing.JRadioButtonMenuItem();
        radio32 = new javax.swing.JRadioButtonMenuItem();

        buttonGroup1.add(radio24);
        buttonGroup1.add(radio28);
        buttonGroup1.add(radio32);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelEsquerdaLayout = new javax.swing.GroupLayout(painelEsquerda);
        painelEsquerda.setLayout(painelEsquerdaLayout);
        painelEsquerdaLayout.setHorizontalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        painelEsquerdaLayout.setVerticalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Open File");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Set Up");

        menu15x24.setText("15 x 24");
        menu15x24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu15x24ActionPerformed(evt);
            }
        });
        jMenu2.add(menu15x24);

        menu15x32.setText("15 x 28");
        menu15x32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu15x32ActionPerformed(evt);
            }
        });
        jMenu2.add(menu15x32);

        jMenuItem4.setText("15 x 32");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        radio24.setText("24");
        radio24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio24ActionPerformed(evt);
            }
        });
        jMenu2.add(radio24);

        radio28.setText("28");
        radio28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio28ActionPerformed(evt);
            }
        });
        jMenu2.add(radio28);

        radio32.setText("32");
        radio32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio32ActionPerformed(evt);
            }
        });
        jMenu2.add(radio32);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu15x24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu15x24ActionPerformed
//        gridPanel.setQuantVert(15);
//        gridPanel.setQuantHoriz(24);
//        gridPanel.repaint();
    }//GEN-LAST:event_menu15x24ActionPerformed

    private void menu15x32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu15x32ActionPerformed
//        gridPanel.setQuantVert(15);
//        gridPanel.setQuantHoriz(28);
//        gridPanel.repaint();
    }//GEN-LAST:event_menu15x32ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
//        gridPanel.setQuantVert(15);
//        gridPanel.setQuantHoriz(32);
//        gridPanel.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void radio24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio24ActionPerformed
//        radio28.setSelected(false);
//        radio32.setSelected(false);
        chamaGrid();
    }//GEN-LAST:event_radio24ActionPerformed

    private void radio28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio28ActionPerformed
//        radio24.setSelected(false);
//        radio32.setSelected(false);
        chamaGrid();
    }//GEN-LAST:event_radio28ActionPerformed

    private void radio32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio32ActionPerformed
//        radio24.setSelected(false);
//        radio28.setSelected(false);
        chamaGrid();
    }//GEN-LAST:event_radio32ActionPerformed

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
            java.util.logging.Logger.getLogger(MainGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGrid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menu15x24;
    private javax.swing.JMenuItem menu15x32;
    private javax.swing.JPanel painelEsquerda;
    private javax.swing.JRadioButtonMenuItem radio24;
    private javax.swing.JRadioButtonMenuItem radio28;
    private javax.swing.JRadioButtonMenuItem radio32;
    // End of variables declaration//GEN-END:variables

    public void chamaGrid() {
        if (radio24.isSelected()) {
            gridPanel.setQuantVert(15);
            gridPanel.setQuantHoriz(24);
        } else if (radio28.isSelected()) {
            gridPanel.setQuantVert(10);
            gridPanel.setQuantHoriz(20);
        } else {
            gridPanel.setQuantVert(5);
            gridPanel.setQuantHoriz(10);
        }
        gridPanel.repaint();
    }
}
