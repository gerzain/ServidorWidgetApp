/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerza
 */
public class Computadora 
{
     public static String Apagar = "shutdown -s";
     private Runtime runtime = Runtime.getRuntime();
     private Process proceso;
    
     public void apagar()
  
  {
    try
    {
     this.proceso=runtime.exec("shutdown -s -t -0");
    }
    catch (IOException | RuntimeException e)
    {
        e.getMessage();
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
  
}

