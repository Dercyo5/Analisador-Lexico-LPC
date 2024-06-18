package View;

import Controller.Controller;
import Controller.TextLineNumber;
import Model.AnalisadorLexico;
import Model.ErrosTokens;
import Model.Token;
import compilerTools.Functions;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dercio Custodio
 */
public class Compilador extends javax.swing.JFrame{
    private DefaultTableModel tokenTableModel;
    private JScrollPane tokenScrollPane;
    TextLineNumber textNumber; 
    private boolean salvo = false;
    private File arquivoSalvo;

    
    public Compilador() {
        initComponents();
        //Functions.setLineNumberOnJTextComponent(jCodicoFonte);
        textNumber = new TextLineNumber(jCodicoFonte);
        jScrollPane1.setRowHeaderView(textNumber);
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCodicoFonte = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        jNovo = new javax.swing.JButton();
        jCompilar = new javax.swing.JButton();
        jGuardar = new javax.swing.JButton();
        jAbrir = new javax.swing.JButton();
        jSobre = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jOutputConsole = new javax.swing.JTextArea();
        jScroll = new javax.swing.JScrollPane();
        tTokens = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        timeElapsed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(51, 102, 255));

        jCodicoFonte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCodicoFonteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jCodicoFonte);

        jNovo.setText("Novo");
        jNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNovoActionPerformed(evt);
            }
        });

        jCompilar.setText("Compilar");
        jCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCompilarActionPerformed(evt);
            }
        });
        jCompilar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCompilarKeyTyped(evt);
            }
        });

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        jAbrir.setText("Abrir");
        jAbrir.setToolTipText("");
        jAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirActionPerformed(evt);
            }
        });

        jSobre.setText("Sobre");
        jSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSobreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSobre)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNovo)
                    .addComponent(jCompilar)
                    .addComponent(jGuardar)
                    .addComponent(jAbrir)
                    .addComponent(jSobre))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jOutputConsole.setEditable(false);
        jOutputConsole.setColumns(20);
        jOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jOutputConsole);

        tTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token Class", "Posicao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTokens.setName(""); // NOI18N
        tTokens.getTableHeader().setReorderingAllowed(false);
        jScroll.setViewportView(tTokens);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tabela de Tokens");

        timeElapsed.setBackground(new java.awt.Color(255, 255, 255));
        timeElapsed.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        timeElapsed.setForeground(new java.awt.Color(255, 255, 255));
        timeElapsed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(127, 127, 127))))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNovoActionPerformed
        clearFields();
        salvo = false;
    }//GEN-LAST:event_jNovoActionPerformed

    private void jCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCompilarActionPerformed
         String codigoFonte = jCodicoFonte.getText();
                if (salvo== true && arquivoSalvo != null) {
                    // Se já está salvo e há um arquivo associado, atualiza o arquivo
                    Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
                    controller.atualizarPrograma(codigoFonte, arquivoSalvo);
                    controller.analiseCodigoFonte(codigoFonte);
                } else {
                    // Se não está salvo ou não há arquivo, apenas analisa o código fonte
                     Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
                    controller.analiseCodigoFonte(codigoFonte);
                }
    }//GEN-LAST:event_jCompilarActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        String codigoFonte = jCodicoFonte.getText();
                if (salvo==true && arquivoSalvo != null) {
                    // Se já está salvo e há um arquivo associado, atualiza o arquivo
                    Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
                    controller.atualizarPrograma(codigoFonte, arquivoSalvo);
                } else {
                    // Se não está salvo ou não há arquivo, exibe o diálogo de salvar
                    JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showSaveDialog(Compilador.this) == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
                        controller.GuardarPrograma(codigoFonte, file);
                        salvo = true;
                        arquivoSalvo = file;
                    }
                }
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirActionPerformed
              JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(Compilador.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
                    String sourceCode = controller.CarregarPrograma(file);
                    jCodicoFonte.setText(sourceCode);
                    salvo = true;
                    arquivoSalvo = file;
                }
    }//GEN-LAST:event_jAbrirActionPerformed

    private void jSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSobreActionPerformed
        JOptionPane.showMessageDialog(Compilador.this, "--------------------------"
                + "\n   Compilador Version 1.0"
                + "\n   Group Number: "
                + "\n   By: "
                + "\n            Dercio"
                + "\n            Oziel"
                + "\n            Ulan"
                + "\n "
                + "\n----------- LPC ----------"
                + "\n--------------------------");
    }//GEN-LAST:event_jSobreActionPerformed

    private void jCompilarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCompilarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jCompilarKeyTyped

    private void jCodicoFonteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCodicoFonteKeyReleased
       String codigoFonte = jCodicoFonte.getText();

    if (salvo && arquivoSalvo != null) {
        // Se já está salvo e há um arquivo associado, atualiza o arquivo
        Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
        controller.atualizarPrograma(codigoFonte, arquivoSalvo);
    } else {
        // Se não está salvo ou não há arquivo, apenas analisa o código fonte
        Controller controller = new Controller(new AnalisadorLexico(), Compilador.this);
        controller.analiseCodigoFonte(codigoFonte);
    }
    }//GEN-LAST:event_jCodicoFonteKeyReleased

    public void displayTokens(List<Token> tokens, long elapsedTime, List<ErrosTokens> erroTokens) {
        tokenTableModel = (DefaultTableModel) tTokens.getModel();
        tokenTableModel.setRowCount(0); // Limpa a tabela antes de adicionar os novos tokens

        for (Token token : tokens) {
            tokenTableModel.addRow(new Object[]{
                    token.getLexema(),
                    token.getTokenClass(),
                    token.getPosicao()
            });
        }

        // Exibir os erros de tokens no TextArea
        StringBuilder sb = new StringBuilder();
        for (ErrosTokens erro : erroTokens) {
            sb.append("Erro: ").append(erro.getErroLexema()).append(" na linha ").append(erro.getErroPosicao()).append(": ").append(erro.getErroTokenClass()).append("\n");
        }

        if (sb.isEmpty()) {
            String resultado = "Programa compilado com sucesso!";
            jOutputConsole.setText(resultado);
        } else {
            String resultado = "Falha na construção do programa!";
            jOutputConsole.setText(resultado + "\n" + sb.toString() + "\n" + elapsedTime + " ms");
        }

        timeElapsed.setText("Tempo decorrido: " + elapsedTime + " ms");
    }

    public void displayError(String message) {
        JOptionPane.showMessageDialog(Compilador.this, message, "Lexical Error", JOptionPane.ERROR_MESSAGE);
    }

    private void clearFields() {
        // Implemente a lógica para limpar os campos da interface
        jCodicoFonte.setText("");
        jOutputConsole.setText("");
        tokenTableModel.setNumRows(0);
        timeElapsed.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAbrir;
    private javax.swing.JTextPane jCodicoFonte;
    private javax.swing.JButton jCompilar;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jNovo;
    private javax.swing.JTextArea jOutputConsole;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSobre;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tTokens;
    private javax.swing.JLabel timeElapsed;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
         Compilador compilador = new Compilador();
         compilador.setVisible(true);
         compilador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

