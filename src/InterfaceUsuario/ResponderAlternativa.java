/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceUsuario;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import regrasNegocio.Formulario;
import regrasNegocio.Pergunta;
import regrasNegocio.PerguntaAberta;
import regrasNegocio.PerguntaAlternativa;
import regrasNegocio.PerguntaFechada;
import regrasNegocio.PerguntaLista;
import regrasNegocio.PerguntaOpcional;

/**
 *
 * @author Windows 10
 */
public class ResponderAlternativa extends javax.swing.JFrame {
    Formulario form;
    PerguntaAlternativa pergunta;
    int proxPergunta;
    
    /**
     * Creates new form ResponderAberta
     */
    public ResponderAlternativa(Formulario formR, int index) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        form = formR;
        pergunta = (PerguntaAlternativa)form.get(index);
        proxPergunta = index + 1;
        
        DefaultListModel<String> model = new DefaultListModel();
        
        for(int count = 0; count < pergunta.getNumeroAlternativas(); count++)
            model.addElement(pergunta.getAlternativa(count));
        
        taEnunciado.setText(formR.get(index).getTexto());
        jLista.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        taEnunciado = new javax.swing.JTextArea();
        bVoltar = new javax.swing.JButton();
        bAvançar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLista = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fóton - Responder Formulário");
        setResizable(false);

        taEnunciado.setEditable(false);
        taEnunciado.setColumns(20);
        taEnunciado.setLineWrap(true);
        taEnunciado.setRows(5);
        taEnunciado.setTabSize(4);
        jScrollPane2.setViewportView(taEnunciado);

        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        bAvançar.setText("Avançar");
        bAvançar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAvançarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jLista);

        jLabel1.setText("Escolha uma ou mais alternativas (segure ctrl para multipla escolha) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bAvançar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVoltar)
                    .addComponent(bAvançar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAvançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAvançarActionPerformed

        // If impede que a janela seja fechada se não houver alternativas escolhidas
        if(!jLista.isSelectionEmpty()){
            String aux = jLista.getSelectedValuesList().toString();
            String[] resposta = aux.split("\n");

            pergunta.setRespostas(resposta);

            dispose();

            if(proxPergunta < form.perguntasSize())
                MainWindow.responderPergunta(form, proxPergunta);

            else{
                JOptionPane optionPane = new JOptionPane("Formulario respondido!", JOptionPane.OK_OPTION);    
                JDialog dialog = optionPane.createDialog("");
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_bAvançarActionPerformed

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        int antePergunta = (proxPergunta - 2);
        
        dispose();
        
        if(antePergunta >= 0)
            MainWindow.responderPergunta(form, antePergunta);
    }//GEN-LAST:event_bVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAvançar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taEnunciado;
    // End of variables declaration//GEN-END:variables
}
