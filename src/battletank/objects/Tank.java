/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.objects;

import battletank.utils.Drawable;
import java.net.URI;

/**
 *
 * @author Tiago
 */
public class Tank extends Drawable{
    private int life;
    private boolean isActive;
    private int xLimit;
    private int yLimit;
    private int speed;
    
    /**
     * @param fileName
     * @param x
     * @param y
     * @param speed
     * @param screenWidth 
     * @param screenHeigth
     */
    public Tank(java.net.URL fileName, int x, int y, int speed, int screenWidth, int screenHeigth){
        super(fileName, x, y);
        
        this.speed = speed;
        life = 1;
        isActive = true;
        xLimit = screenWidth;
        yLimit = screenHeigth;
        
    }

    public int getLife() {
        return life;
    }
    
    public int getSpeed(){
        return speed;
    }

    public boolean isIsActive() {
        return isActive;
    }   


    public void setLife(int life) {
        this.life = life;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setxLimit(int xLimit) {
        this.xLimit = xLimit;
    }

    public void setyLimit(int yLimit) {
        this.yLimit = yLimit;
    }
    
}
