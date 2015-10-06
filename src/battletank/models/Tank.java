/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Direction;

/**
 *
 * @author Tiago
 */
public class Tank extends Creature{
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
        super(fileName, x, y, 50, Direction.DOWN);
        
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
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void turnUp(){
        if (!isEdge(Direction.UP)) {
            position.y -= speed;
            direction = Direction.UP;
        }
    }
    
    public void turnDown(){
        if (!isEdge(Direction.DOWN)) {
            position.y += speed;
            direction = Direction.DOWN;
        }
    }
    
    public void turnLeft(){
        if (!isEdge(Direction.LEFT)) {
            position.x -= speed;
            direction = Direction.LEFT;
        }
    }
    
    public void turnRigth(){
        if (!isEdge(Direction.RIGHT)) {
            position.x += speed;
            direction = Direction.RIGHT;
        }
    }
    
    public boolean isEdge(int direction){
        switch(direction){
            case Direction.DOWN:
                return position.y+size+(speed/2) >= yLimit;
            case Direction.UP:
                return position.y-(speed/2) <= 0;
            case Direction.LEFT:
                return position.x-(speed/2) <= 0;
            case Direction.RIGHT:
                return position.x+size+(speed/2) >= xLimit;
        }
        return false;
    }

    public void wasStruck(Tangible obj) {
        
    }

    public int causeDamage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
