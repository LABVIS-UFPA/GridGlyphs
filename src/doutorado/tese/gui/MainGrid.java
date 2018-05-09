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
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        initComponents();
        gridPanel = new Grid();
        painelEsquerda.add(gridPanel);
        gridPanel.setDoubleBuffered(true);
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
        jLabel8 = new javax.swing.JLabel();
        radio5x10 = new javax.swing.JRadioButton();
        radio10x20 = new javax.swing.JRadioButton();
        radio15x24 = new javax.swing.JRadioButton();
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

        buttonGroup1.add(radio5x10);
        buttonGroup1.add(radio10x20);
        buttonGroup1.add(radio15x24);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelEsquerdaLayout = new javax.swing.GroupLayout(painelEsquerda);
        painelEsquerda.setLayout(painelEsquerdaLayout);
        painelEsquerdaLayout.setHorizontalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
        );
        painelEsquerdaLayout.setVerticalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        varVisuaisEscolidasList.setToolTipText("");
        varVisuaisEscolidasList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                varVisuaisEscolidasListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(varVisuaisEscolidasList);

        varVisuaisList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Texture", "Color", "Shape", "Letter", "Number" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        varVisuaisList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                varVisuaisListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(varVisuaisList);

        jLabel1.setText("Visual variables:");

        jLabel2.setText("Order:");

        inserirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaDir.png"))); // NOI18N
        inserirButton.setEnabled(false);
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });

        removerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaEsq.png"))); // NOI18N
        removerButton.setEnabled(false);
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        cimaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaUp.png"))); // NOI18N
        cimaButton.setEnabled(false);
        cimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cimaButtonActionPerformed(evt);
            }
        });

        baixoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/setaDown.png"))); // NOI18N
        baixoButton.setEnabled(false);
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

        jLabel8.setText("Grid:");

        radio5x10.setText("5x10");
        radio5x10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio5x10ActionPerformed(evt);
            }
        });

        radio10x20.setText("10x20");
        radio10x20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio10x20ActionPerformed(evt);
            }
        });

        radio15x24.setText("15x24");
        radio15x24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio15x24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoConfiVarVisuais, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio5x10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio10x20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radio15x24)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cimaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(baixoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(151, 151, 151))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(radio5x10)
                    .addComponent(radio10x20)
                    .addComponent(radio15x24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cimaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(baixoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(inserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 79, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, 79, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, 79, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(52, Short.MAX_VALUE))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        jMenu1.setText("File");

        jMenuItem1.setText("Open File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        gridPanel.loadMatrizGlyphs();
        gridPanel.setCofig(itensHierarquia);
        gridPanel.repaint();
    }//GEN-LAST:event_botaoConfiVarVisuaisActionPerformed

    private void varVisuaisEscolidasListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_varVisuaisEscolidasListValueChanged
        if (varVisuaisEscolidasList.getSelectedValuesList().size() >= 1) {
            removerButton.setEnabled(true);
            if (varVisuaisEscolidasList.getSelectedIndex() > 0) {
                cimaButton.setEnabled(true);
            } else {
                cimaButton.setEnabled(false);
            }
            if (varVisuaisEscolidasList.getSelectedIndex() < varVisuaisEscolidasList.getModel().getSize() - 1) {
                baixoButton.setEnabled(true);
            } else {
                baixoButton.setEnabled(false);
            }
        } else {
            removerButton.setEnabled(false);
            cimaButton.setEnabled(false);
            baixoButton.setEnabled(false);
        }
    }//GEN-LAST:event_varVisuaisEscolidasListValueChanged

    private void varVisuaisListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_varVisuaisListValueChanged
        if (varVisuaisList.getSelectedValuesList().size() >= 1) {
            inserirButton.setEnabled(true);
        } else {
            inserirButton.setEnabled(false);
        }
    }//GEN-LAST:event_varVisuaisListValueChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "TXT & CSV Files", "txt", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            limparResquiciosBasesAnteriores();
//            checkGlyph.setEnabled(false);
//            selectedFile = chooser.getSelectedFile();
//            progressoBarra.setVisible(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//            logger.info("Arquivo selecionado: " + selectedFile);
            //Instances of javax.swing.SwingWorker are not reusuable, so
            //we create new instances as needed.
//            task = new Task();
//            task.addPropertyChangeListener(this);
//            task.execute();
        } else {
            JOptionPane.showMessageDialog(null, "The file type can not be read.", "Erro!", JOptionPane.ERROR_MESSAGE);
//            logger.error("The file type can not be read. - Did it again!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void radio5x10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio5x10ActionPerformed
        configGrid();
    }//GEN-LAST:event_radio5x10ActionPerformed

    private void radio10x20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio10x20ActionPerformed
        configGrid();
    }//GEN-LAST:event_radio10x20ActionPerformed

    private void radio15x24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio15x24ActionPerformed
        configGrid();
    }//GEN-LAST:event_radio15x24ActionPerformed

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
                JFrame mainFrame = new MainGrid();
                mainFrame.setVisible(true);
                mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_HORIZ);
                mainFrame.setLocationRelativeTo(null);
//                new MainGrid().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
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
    private javax.swing.JRadioButton radio10x20;
    private javax.swing.JRadioButton radio15x24;
    private javax.swing.JRadioButton radio5x10;
    private javax.swing.JButton removerButton;
    private javax.swing.JList<String> varVisuaisEscolidasList;
    private javax.swing.JList<String> varVisuaisList;
    // End of variables declaration//GEN-END:variables

    public void configGrid() {
        if (radio15x24.isSelected()) {
            gridPanel.setQuantVert(15);
            gridPanel.setQuantHoriz(24);
        } else if (radio10x20.isSelected()) {
            gridPanel.setQuantVert(10);
            gridPanel.setQuantHoriz(20);
        } else {
            gridPanel.setQuantVert(5);
            gridPanel.setQuantHoriz(10);
        }
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

    private void limparPainelEsquerda() {
        painelEsquerda.removeAll();
        painelEsquerda.repaint();
    }
}
