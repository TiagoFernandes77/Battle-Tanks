/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.core;

/**
 *
 * @author Tiago
 */
public abstract class Game {

    /**
     *
     */
    public final long FPS;
    
    public Game(long FPS){
        this.FPS = FPS;
    }
    
    public abstract void processLogics();
    
    public abstract void renderGraphics();
    
    public abstract void paintScreen();
}
