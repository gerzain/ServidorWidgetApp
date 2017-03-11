/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import  javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Gerza
 */
public class Principal extends  JFrame
{
    private JTextArea textField;
    private  Servidor servidor;
    private JLabel imagen;
    
    private void appendInformation() {
      this.textField.append(" Servidor en ejecución !");
   }
    
    public Principal()
    {
      super("Servidor para widget ");
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, 0));
      this.textField = new JTextArea();
      this.imagen=new JLabel();
      
      DefaultCaret caret = (DefaultCaret)this.textField.getCaret();
      caret.setUpdatePolicy(2);
      this.textField.setColumns(30);
      this.textField.setRows(10);
      this.textField.setBackground(Color.WHITE);
      this.textField.setForeground(Color.BLACK);
      this.textField.setFont(new Font("Verdana,", 1, 12));
      this.appendInformation();
      this.textField.setEditable(false);
      this.servidor = new Servidor(new MensajeRetorno() {

            @Override
            public void messageReceivedCallback(String var1) {
                Principal.this.textField.append("\n " + var1);
            }

            @Override
            public void messageSentCallback(String var1) {
              Principal.this.textField.append(var1);
            }
        });
      this.servidor.start();
      JScrollPane jScroll = new JScrollPane(this.textField);
      jScroll.setVerticalScrollBarPolicy(22);
      jScroll.setHorizontalScrollBarPolicy(31);
      panel.add(jScroll);
      this.getContentPane().add(panel);
      this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
      this.setSize(500, 170);
      this.setVisible(true);
}// Termina el constructor 
    


}// Termina la clase de Jframe
