/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Gerza
 */
public interface MensajeRetorno {
   void messageReceivedCallback(String var1);
   void messageSentCallback(String var1);

}
