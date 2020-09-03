package JavaDB;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavly
 */
public class Threading2 extends Thread{

    public Threading2(){
        //calling the super class "Thread class" constructor of the parameter String
        super("Demo Thread");
       
    }
    
    @Override
    public void run() {
        try {
            this.sleep(600);
            System.out.println("2nd threading example is done "+getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Threading2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
