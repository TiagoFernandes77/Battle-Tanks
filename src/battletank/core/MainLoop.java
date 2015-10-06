/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago
 */
public class MainLoop implements Runnable{
    private boolean isRunning;
    private final Game game;
    
    public MainLoop(Game game){
        this.isRunning = true;
        this.game = game;
    }
    
    @Override
    public void run() {
        final long FPS_TIME = 1000/game.FPS;
        while (isRunning) {
            long beforeTime = System.currentTimeMillis();
            game.processLogics();
            game.renderGraphics();
            game.paintScreen();
            long afterTime = System.currentTimeMillis();
            long sleepTime = afterTime - beforeTime;
 
   if (sleepTime < FPS_TIME)
      sleep((int) (FPS_TIME - sleepTime));
    }
   }
   
   public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            isRunning = false;
            Logger.getLogger(MainLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
