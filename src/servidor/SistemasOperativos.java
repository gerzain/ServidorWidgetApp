package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gerza
 */
public class SistemasOperativos {
    
   private static SistemasOperativos instance = null;
   public static final String LINUX = "Linux";
   public static final String WINDOWS = "WINDOWS";
   
   public SistemasOperativos getInstance() {
      if(instance == null) {
         instance = new SistemasOperativos();
         return instance;
      } else {
         return instance;
      }
   }


}
