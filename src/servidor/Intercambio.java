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
public class Intercambio {
    private Comando command;
    public void setCommand(Comando command)
  {
    this.command = command;
  }
     public void switchCommand()
  {
    this.command.execute();
  }
}
