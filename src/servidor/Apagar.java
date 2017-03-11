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
public class Apagar implements Comando{
    Computadora compu;
   public Apagar(Computadora computadora)
   {
       this.compu=computadora;
   }
    
    @Override
    public void execute() 
    {
       this.compu.apagar();
    }
    
}
