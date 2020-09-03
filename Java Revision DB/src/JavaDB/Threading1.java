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
public class Threading1 implements Runnable{

    public Thread thread;
    public Threading1(){
        thread=new Thread(this,"Demo Thread");
    }
    @Override
    public void run() {
        try {
            thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threading1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("welcome to threading");
    }
    
}
