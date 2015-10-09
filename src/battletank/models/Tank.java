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
    private int speed;
    private final Edge[] edges;
    
    /**
     * @param fileName
     * @param x
     * @param y
     * @param speed
     * @param edges
     */
    public Tank(java.net.URL fileName, int x, int y, int speed, Edge []edges){
        super(fileName, x, y, 50, Direction.DOWN);
        
        this.speed = speed;
        life = 1;
        isActive = true;
        this.edges = edges;
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
        return edges[direction].hasImpact(this);
    }

    @Override
    public void wasStruck(Tangible obj) {
        int damage = obj.causeDamage();
        
    }

    @Override
    public int causeDamage() {
        return 0;
    }
}
