/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


/**
 *
 * @author Gerza
 */
public class Servidor extends Thread
{

   public static final int SERVERPORT = 5000;
   private boolean running = false;
   private PrintWriter mOut;
   private BufferedReader in;
   private  MensajeRetorno messageListener;
   private  Comando apagar;
   private Intercambio switcher;
   private  Computadora computadora;
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        final Principal frame=new Principal();
        frame.setDefaultCloseOperation(3);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        System.out.println("Version de S.0 es:"+System.getProperty("os.name"));
    }// Termina método principal 
   
    public  Servidor(MensajeRetorno messageListener)
    {
         this.messageListener = messageListener;
         this.computadora=new Computadora();
         this.switcher=new Intercambio();
         this.apagar=new Apagar(this.computadora);

    }
    /*
      Metodo para enviar mensaje en el servidor al cliente 
    */
 public void sendMessage(String message) {
      if(this.mOut != null && !this.mOut.checkError()) 
      {
         this.mOut.println(message);
         this.mOut.flush();
         System.out.println("Mensaje enviado: " + message);
         this.messageListener.messageSentCallback("Respuesta " + message);
      }
 }
   
 @Override
   
    public void run() 
   {
      super.run();
      this.running = true;

      try 
      {
         this.messageListener.messageReceivedCallback(" Esperando conexion...");
         ServerSocket e = new ServerSocket(SERVERPORT);
         e.setReuseAddress(true);
         Socket client = e.accept();
         this.messageListener.messageReceivedCallback("Se ha conectado! Recibiendo información...");

         try 
         {
            this.mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while(this.running) 
          {
               String mensaje = this.in.readLine();
               
               if(mensaje!=  null && this.messageListener !=null)
               {
               
                  System.out.println("Recibi el mensaje"+"  "+ mensaje);
                  if(mensaje.equals("shutdown -s")) 
                  {
                     this.messageListener.messageReceivedCallback(" Mensaje recibido: apagar! Se empezara a apagar");
                     //this.switcher.setCommand(this.apagar);
                     //Runtime  runtime= Runtime.getRuntime();
                     
                      try 
                      {
                           //Runtime r=Runtime.getRuntime();
                            //r.exec("shutdown -s");
                          String mensajito="La computadora se apagara";
                          JOptionPane.showMessageDialog(null, mensajito);
                      } catch (Exception ex) 
                      {
                          System.out.println("e"+ex.getMessage());
                      }
                     
                     //this.switcher.switchCommand();
                     this.sendMessage("shutdown");
                     this.running = false;
                     
                 
                  } else if(mensaje.equals("test")) 
                  {
                     finalize();
                     this.running = false;
                  }
               }
               
            }// Termina la ejecución 
         } catch (Exception exception) 
         {
            this.messageListener.messageReceivedCallback("Error! Algo paso y no se apaga...");
            
             System.err.println("Error 1"+exception.getMessage());
             
         } catch (Throwable exThrowable) 
         {
            this.messageListener.messageReceivedCallback("Error! Esto es de throwable ...");
           System.err.println("Error 2"+"  "+ exThrowable.getMessage());
         } finally 
         {
            this.mOut.flush();
            this.mOut.close();
            this.in.close();
            client.close();
            e.close();
            Thread.sleep(2000L);
            System.out.println("S: Hecho.");
            this.run();
         }
      } catch (Exception var12) {
         this.messageListener.messageReceivedCallback("Error! Ya valio verde esto...");
         //var12.printStackTrace();
          System.out.println("No funciono"+var12);
        
      }

   }// Termina el metodo de hilo principal de  servidor

    
    
}// En este termina la clase
     
        
         

           
  
    

