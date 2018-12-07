/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceUsuario;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Excecoes.RespostaException;
import regrasNegocio.Formulario;
import regrasNegocio.Pergunta;
import regrasNegocio.PerguntaAberta;
import regrasNegocio.PerguntaAlternativa;
import regrasNegocio.PerguntaLista;
import regrasNegocio.PerguntaOpcional;

/**
 *
 * @author Windows 10
 */
public class ResponderLista extends javax.swing.JFrame {
    Formulario form;
    PerguntaLista pergunta;
    int proxPergunta;
    /**
     * Creates new form ResponderAberta
     */
    public ResponderLista(Formulario formR, int index) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        form = formR;
        pergunta = (PerguntaLista)form.get(index);
        proxPergunta = index + 1;
        
        taEnunciado.setText(formR.get(index).getTexto());
        
        for(int count = 0; count < pergunta.getNumeroAlternativas(); count++)
            jLista.addItem(pergunta.getAlternativa(count));
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
        jLabel1 = new javax.swing.JLabel();
        jLista = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Escolha uma alternativa :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bAvançar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVoltar)
                    .addComponent(bAvançar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAvançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAvançarActionPerformed
        String aux = jLista.getSelectedItem().toString();
        String[] resposta = new String[1];
        
        resposta[0] = aux;

        try{
            form.get(proxPergunta - 1).setRespostas(resposta);
        }catch(RespostaException rex){
            System.out.println("Ocorreu um erro ao inserir a resposta: " + rex.getMessage());
        }

        dispose();
        
        if(proxPergunta < form.perguntasSize())
            MainWindow.responderPergunta(form, proxPergunta);
        
        else{
            JOptionPane optionPane = new JOptionPane("Formulario respondido!", JOptionPane.OK_OPTION);    
            JDialog dialog = optionPane.createDialog("");
            dialog.setVisible(true);
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
    private javax.swing.JComboBox<String> jLista;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taEnunciado;
    // End of variables declaration//GEN-END:variables
}
