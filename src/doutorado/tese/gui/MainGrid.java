/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.visualizacao.glyph.Glyph;
import doutorado.tese.visualizacao.glyph.GlyphConcrete;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.color.Cor;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.letters.Letra;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.numbers.Numeral;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.FormaGeometrica;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.shapes.GeometryFactory;
import doutorado.tese.visualizacao.glyph.decorator.variaveisvisuais.texture.Textura;
import doutorado.tese.visualizacao.grid.Grid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainGrid.class.getName()).log(Level.SEVERE, null, ex);
        }
//        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//        setExtendedState(java.awt.Frame.MAXIMIZED_HORIZ);
//        setExtendedState(java.awt.Frame.MAXIMIZED_VERT);
        initComponents();

//        layerPane = new JLayeredPane();
//        layerPane.add(painelEsquerda, 0, 0);//penultimo é a ordem das camadas
//        layerPane.setBounds(painelEsquerda.getBounds());
//        painelEsquerda.add(layerPane);
        gridPanel = new Grid();
        painelEsquerda.add(gridPanel);
        gridPanel.setDoubleBuffered(true);

//        gridPanel = new Grid(painelEsquerda.getBounds());
//        painelEsquerda.add(gridPanel);
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
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        varVisuaisEscolidasList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        varVisuaisList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inserirButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        cimaButton = new javax.swing.JButton();
        baixoButton = new javax.swing.JButton();
        botaoConfiVarVisuais = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
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
            .addGap(0, 958, Short.MAX_VALUE)
        );
        painelEsquerdaLayout.setVerticalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        varVisuaisEscolidasList.setToolTipText("");
        jScrollPane2.setViewportView(varVisuaisEscolidasList);

        varVisuaisList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Texture", "Color", "Shape", "Letter", "Number" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(varVisuaisList);

        jLabel1.setText("Visual variables:");

        jLabel2.setText("Order:");

        inserirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaDir.png"))); // NOI18N
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });

        removerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaEsq.png"))); // NOI18N
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        cimaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaUp.png"))); // NOI18N
        cimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimaButtonActionPerformed(evt);
            }
        });

        baixoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaDown.png"))); // NOI18N
        baixoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baixoButtonActionPerformed(evt);
            }
        });

        botaoConfiVarVisuais.setText("OK");
        botaoConfiVarVisuais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfiVarVisuaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(baixoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cimaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfiVarVisuais, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)))
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(inserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cimaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(baixoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoConfiVarVisuais)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Set Up", jPanel2);

        jLabel3.setText("Texture:");

        jLabel4.setText("Color:");

        jLabel5.setText("Shape:");

        jLabel6.setText("Letter:");

        jLabel7.setText("Number:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jButton6.setText("View Glyphs");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(158, 158, 158))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Glyphs", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        jMenu1.setText("File");

        jMenuItem1.setText("Open File");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Set Up");

        radio24.setText("15x24");
        radio24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio24ActionPerformed(evt);
            }
        });
        jMenu2.add(radio24);

        radio28.setText("10x20");
        radio28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio28ActionPerformed(evt);
            }
        });
        jMenu2.add(radio28);

        radio32.setText("5x10");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        List<Object> newListaAtribTreemap = new ArrayList<>();
        List<Object> atributos = new ArrayList<>();

        for (int i = 0; i < varVisuaisList.getModel().getSize(); i++) {
            String elementAt = varVisuaisList.getModel().getElementAt(i);
            atributos.add(elementAt);
        }
        atributos.addAll(varVisuaisEscolidasList.getSelectedValuesList());
        atributos.sort(null);
        loadItensVarVisuais(atributos.toArray());

        //remover o conteudo da lista de hierarquia treemap
        ListModel<String> modelGlyphs = varVisuaisEscolidasList.getModel();
        List<String> selectedValuesList = varVisuaisEscolidasList.getSelectedValuesList();
        for (int i = 0; i < modelGlyphs.getSize(); i++) {
            if (!selectedValuesList.contains(modelGlyphs.getElementAt(i))) {
                newListaAtribTreemap.add(modelGlyphs.getElementAt(i));
            }
        }
        loadVariaveisEscolhidasList(newListaAtribTreemap.toArray(), varVisuaisEscolidasList);

        if (varVisuaisEscolidasList.getModel().getSize() == 0) {
            varVisuaisEscolidasList.setEnabled(false);
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    private void inserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirButtonActionPerformed
        List<Object> newListaAtribTreemap = new ArrayList<>();
        List<Object> atributosEscolhidos = new ArrayList<>();
        for (int i = 0; i < varVisuaisEscolidasList.getModel().getSize(); i++) {
            String elementAt = varVisuaisEscolidasList.getModel().getElementAt(i);
            atributosEscolhidos.add(elementAt);
        }
        atributosEscolhidos.addAll(varVisuaisList.getSelectedValuesList());
        atributosEscolhidos.sort(null);
        loadVariaveisEscolhidasList(atributosEscolhidos.toArray(), varVisuaisEscolidasList);
        varVisuaisEscolidasList.setEnabled(true);
        botaoConfiVarVisuais.setEnabled(true);

        //remover o conteudo da lista de atributos original
        ListModel<String> modelOriginal = varVisuaisList.getModel();
        List<String> selectedValuesList = varVisuaisList.getSelectedValuesList();
        for (int i = 0; i < modelOriginal.getSize(); i++) {
            if (!selectedValuesList.contains(modelOriginal.getElementAt(i))) {
                newListaAtribTreemap.add(modelOriginal.getElementAt(i));
            }
        }
        loadItensVarVisuais(newListaAtribTreemap.toArray());
    }//GEN-LAST:event_inserirButtonActionPerformed

    private void cimaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cimaButtonActionPerformed
        List<String> novaLista = new ArrayList<>();
        int[] selectedValuesList = varVisuaisEscolidasList.getSelectedIndices();
        for (int i = 0; i < varVisuaisEscolidasList.getModel().getSize(); i++) {
            for (int j = 0; j < selectedValuesList.length; j++) {
                if (i == selectedValuesList[j]) {
                    novaLista.add(i - 1, varVisuaisEscolidasList.getModel().getElementAt(i));
                } else {
                    novaLista.add(varVisuaisEscolidasList.getModel().getElementAt(i));
                }
            }
        }
        loadVariaveisEscolhidasList(novaLista.toArray(), varVisuaisEscolidasList);
    }//GEN-LAST:event_cimaButtonActionPerformed

    private void baixoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baixoButtonActionPerformed
        List<String> novaLista = new ArrayList<>(varVisuaisEscolidasList.getModel().getSize());
        for (int i = 0; i < varVisuaisEscolidasList.getModel().getSize(); i++) {
            novaLista.add(varVisuaisEscolidasList.getModel().getElementAt(i));
        }
        int[] selectedValuesList = varVisuaisEscolidasList.getSelectedIndices();
        for (int i = 0; i < novaLista.size(); i++) {
            for (int j = 0; j < selectedValuesList.length; j++) {
                if (i == selectedValuesList[j]) {
                    String caraFrente = novaLista.get(i + 1);
                    String caraAtual = novaLista.get(i);
                    novaLista.add(i + 1, caraAtual);
                    novaLista.add(i, caraFrente);
                    novaLista.remove(i + 2);
                    novaLista.remove(i + 2);
                    break;
                }
            }
        }
        loadVariaveisEscolhidasList(novaLista.toArray(), varVisuaisEscolidasList);
    }//GEN-LAST:event_baixoButtonActionPerformed

    private void botaoConfiVarVisuaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfiVarVisuaisActionPerformed
        String[] itensHierarquia = parseListString2Array(varVisuaisEscolidasList.getModel());

        gridPanel.setCofig(itensHierarquia);
        
        gridPanel.putGlyphs();
        
//        gridPanel.repaint();
        System.out.println(Arrays.toString(itensHierarquia));
    }//GEN-LAST:event_botaoConfiVarVisuaisActionPerformed

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
    private javax.swing.JButton baixoButton;
    private javax.swing.JButton botaoConfiVarVisuais;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cimaButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painelEsquerda;
    private javax.swing.JRadioButtonMenuItem radio24;
    private javax.swing.JRadioButtonMenuItem radio28;
    private javax.swing.JRadioButtonMenuItem radio32;
    private javax.swing.JButton removerButton;
    private javax.swing.JList<String> varVisuaisEscolidasList;
    private javax.swing.JList<String> varVisuaisList;
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

    private void loadVariaveisEscolhidasList(Object[] objs, JList<String> jList) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(objs);
        jList.setModel(model);
    }

    private void loadItensVarVisuais(Object[] objs) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(objs);
        varVisuaisList.setModel(model);
        varVisuaisList.setEnabled(true);
    }

    public String[] parseListString2Array(ListModel<String> lista) {
        String[] convertida = new String[lista.getSize()];
        for (int i = 0; i < convertida.length; i++) {
            convertida[i] = lista.getElementAt(i);
        }
        return convertida;
    }
}
