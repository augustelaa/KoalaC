/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiladores_Interface;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import Biblioteca.StringUtils;
import Compiladores_Backend.LexicalError;
import Compiladores_Backend.Lexico;
import Compiladores_Backend.SemanticError;
import Compiladores_Backend.Semantico;
import Compiladores_Backend.Sintatico;
import Compiladores_Backend.SyntaticError;
import Compiladores_Backend.Token;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class InterfaceGrafica extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceGrafica
     */
    public InterfaceGrafica() {
        initComponents();

        //Posição da tela ao iniciar o programa
        this.setLocation(550, 300);

        // -- Colocando as linhas no editor
        jTextArea1.setBorder(new NumeredBorder());

        // -- Impedir editar texto na área de mensagens
        jTextArea2.setEditable(false);

        // -- Impedir editar texto na barra de status
        jTextArea3.setEditable(false);

        try {
            // -- botão novo
            Image img = ImageIO.read(getClass().getResource("img\\novo.png"));
            Image newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            ImageIcon NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton1.setIcon(NewIcon);

            // -- botão abrir
            img = ImageIO.read(getClass().getResource("img\\abrir.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton2.setIcon(NewIcon);

            // -- botão salvar
            img = ImageIO.read(getClass().getResource("img\\salvar.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton3.setIcon(NewIcon);

            // -- 
            img = ImageIO.read(getClass().getResource("img\\copiar.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton4.setIcon(NewIcon);

            // -- 
            img = ImageIO.read(getClass().getResource("img\\colar.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton5.setIcon(NewIcon);

            // -- 
            img = ImageIO.read(getClass().getResource("img\\recortar.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton6.setIcon(NewIcon);

            // -- 
            img = ImageIO.read(getClass().getResource("img\\compilar.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton7.setIcon(NewIcon);

            // -- 
            img = ImageIO.read(getClass().getResource("img\\equipe.png"));
            newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            NewIcon = new ImageIcon(newimg);
            //jButton1.setIcon(new ImageIcon(img));
            jButton8.setIcon(NewIcon);
        } catch (Exception ex) {
            System.out.println("Imagem não encontrada: " + ex);
        }

    }

    public void executaAcao() {
        /**
         * * pega o InputMap sempre que a janela atual está em foco
         */

        InputMap iMap = jPanel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap aMap = jPanel1.getActionMap();

        iMap.put(KeyStroke.getKeyStroke("0"), "painel.botao0apertado");
        iMap.put(KeyStroke.getKeyStroke("1"), "painel.botao1apertado");
        iMap.put(KeyStroke.getKeyStroke("2"), "painel.botao2apertado");

        aMap.put("painel.botao0apertado", new ZeroAction());
        //aMap.put("painel.botao1apertado", new UmAction());       
        //aMap.put("painel.botao2apertado", new DoisAction());    
    }

    class ZeroAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("funcionou");
            jTextArea2.setText("0");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(900, 400));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setMinimumSize(new java.awt.Dimension(900, 100));
        jScrollPane2.setViewportView(jTextArea2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setMinimumSize(new java.awt.Dimension(900, 30));
        jScrollPane3.setViewportView(jTextArea3);

        jToolBar1.setRollover(true);

        jButton1.setText("novo [Ctrl-n]");
        jButton1.setActionCommand("");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton2.setText("abrir [ctrl-o]");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton3.setText("salvar [ctrl-s]");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton4.setText("copiar [ctrl-c]");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        jButton5.setText("colar [ctrl-v]");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator5);

        jButton6.setText("recortar [ctrl-x]");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator6);

        jButton7.setText("compilar [F9]");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator7);

        jButton8.setText("equipe [F1]");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        System.out.println("Botão Equipe");
        jTextArea2.setText(" * Augusto Henrique da Conceição \n * Marcelo Luiz Jung");

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        System.out.println("Botão Compilar");
        jTextArea2.setText("");

        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        StringUtils.line = 0;

        String codigo = jTextArea1.getText();
        if (!codigo.trim().isEmpty()) {
            lexico.setInput(codigo);
            try {

                sintatico.parse(lexico, semantico);
                System.out.println("Compilado com sucesso!");
                jTextArea2.append("Compilado com sucesso!");

            } catch (LexicalError e) {
                jTextArea2.setText(e.getMessage());
            } catch (SyntaticError ex) {
                try {
                    int positionLexeme = Integer.parseInt(ex.toString().substring(ex.toString().lastIndexOf("@") + 2));
                    Token token;
                    lexico.setPosition(positionLexeme);
                    token = lexico.nextToken();
                    String trecho = codigo.substring(positionLexeme);
                    String mensagem = "Erro na linha " + StringUtils.getLine(trecho, codigo, positionLexeme) + " - ";
                    if (token != null) {
                        mensagem += "encontrando " + token.getLexeme() + " " + ex.getLocalizedMessage();
                    } else {
                        mensagem += "encontrando fim de arquivo " + ex.getLocalizedMessage();
                    }
                    this.jTextArea2.setText(mensagem);
                } catch (LexicalError ex1) {
                    jTextArea2.setText(ex1.getMessage());
                }
            } catch (SemanticError ex) {
                jTextArea2.setText("erro não tratado " + ex.getLocalizedMessage());
            }
        } else {
            this.jTextArea2.setText("nenhum programa para compilar");
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        System.out.println("Botão Recortar");

        jTextArea1.cut();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        System.out.println("Botão Colar");

        jTextArea1.paste();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        System.out.println("Botão Copiar");

        jTextArea1.copy();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        System.out.println("Botão Salvar");

        if (jTextArea3.getText().isEmpty()) {
            try {
                JFileChooser file = new JFileChooser();
                FileNameExtensionFilter FiltroExtensaoTxt = new FileNameExtensionFilter("Arquivos txt", "txt");
                file.addChoosableFileFilter(FiltroExtensaoTxt);
                file.setAcceptAllFileFilterUsed(false);
                file.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
                int i = file.showSaveDialog(null);

                if (i != 1) {
                    File arquivo = file.getSelectedFile();
                    String Path = arquivo.getPath() + ".txt";

                    FileWriter arq = new FileWriter(Path);
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.printf(jTextArea1.getText());
                    arq.close();

                    String diretorio[] = new String[20];
                    diretorio = Path.split("\\\\");
                    jTextArea3.setText("Pasta escolhida: " + Path + ". Arquivo salvo: " + diretorio[diretorio.length - 1] + ".");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            try {
                String Path = jTextArea3.getText();
                String diretorio[] = new String[5];
                diretorio = Path.split("\\.");

                diretorio = diretorio[0].split("\\:");
                String caminhoArquivo = diretorio[1] + ":" + diretorio[2] + ".txt";
                caminhoArquivo = caminhoArquivo.trim();

                FileWriter arq = new FileWriter(caminhoArquivo);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf(jTextArea1.getText());
                arq.close();

                // -- Comentado pois não precisa atualizar a linha, pois nesse momento já estará correto
                //diretorio = Path.split("\\\\");
                //jTextArea3.setText("Pasta escolhida: " + caminhoArquivo + ". Arquivo salvo: " + diretorio[diretorio.length - 1] + ".");
            } catch (IOException ex) {
                System.out.println("Erro ao salvar: " + ex.getMessage());
                Logger
                        .getLogger(InterfaceGrafica.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        System.out.println("Botão Abrir");

        JFileChooser arquivo = new JFileChooser();
        FileNameExtensionFilter FiltroExtensaoTxt = new FileNameExtensionFilter("Arquivos txt", "txt");
        arquivo.addChoosableFileFilter(FiltroExtensaoTxt);
        arquivo.setAcceptAllFileFilterUsed(false);

        if (arquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("ok");
            String ArquivoPath = arquivo.getSelectedFile().getAbsolutePath();

            if (!ArquivoPath.isEmpty()) {
                BufferedReader br;
                String CampoDeTexto = "";
                try {
                    br = new BufferedReader(new FileReader(ArquivoPath));
                    while (br.ready()) {
                        String linha = br.readLine();
                        CampoDeTexto += linha + "\n";
                    }
                    br.close();

                    jTextArea1.setText(CampoDeTexto);
                    jTextArea2.setText("");
                    //System.out.println(ArquivoPath);
                    String diretorio[] = new String[20];
                    diretorio = ArquivoPath.split("\\\\");
                    jTextArea3.setText("Pasta escolhida: " + ArquivoPath + ". Arquivo aberto: " + diretorio[diretorio.length - 1] + ".");

                } catch (FileNotFoundException ex) {
                    System.out.println("Arquivo não encontrado: " + ex.getMessage());
                    Logger
                            .getLogger(InterfaceGrafica.class
                                    .getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Erro ao ler arquivo: " + ex.getMessage());
                    Logger
                            .getLogger(InterfaceGrafica.class
                                    .getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.out.println("Botão Abrir");
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            jButton7ActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton8ActionPerformed(null);
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private String getToken(int tokenId) {

        switch (tokenId) {
            case 0:
                return "Epsilon               ";
            case 1:
                return "Dollar                ";
            case 2:
                return "Palavra               ";
            case 3:
                return "Identificador Int     ";
            case 4:
                return "Identificador Float   ";
            case 5:
                return "Identificador String  ";
            case 6:
                return "Identificador Bool    ";
            case 7:
                return "Identificador Composto";
            case 8:
                return "Constante Int         ";
            case 9:
                return "Constante Float       ";
            case 10:
                return "Constante String      ";
            case 11:
                return "Palavra reservada     ";
            case 12:
                return "Palavra reservada     ";
            case 13:
                return "Palavra reservada     ";
            case 14:
                return "Palavra reservada     ";
            case 15:
                return "Palavra reservada     ";
            case 16:
                return "Palavra reservada     ";
            case 17:
                return "Palavra reservada     ";
            case 18:
                return "Palavra reservada     ";
            case 19:
                return "Palavra reservada     ";
            case 20:
                return "Palavra reservada     ";
            default:
                return "Símbolo especial      ";
        }
    }

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
            java.util.logging.Logger.getLogger(InterfaceGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGrafica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGrafica().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
