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
    public int speed;
    private final Edge[] edges;
    public Missile missile;
    
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
        missile = new Missile(1, 15);
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
        direction = Direction.UP;
        if (!isEdge(Direction.UP)) {
            position.y -= speed;
            
        }
    }
    
    public void turnDown(){
        direction = Direction.DOWN;
        if (!isEdge(Direction.DOWN)) {
            position.y += speed;
            
        }
    }
    
    public void turnLeft(){
        direction = Direction.LEFT;
        if (!isEdge(Direction.LEFT)) {
            position.x -= speed;
            
        }
    }
    
    public void turnRigth(){
        direction = Direction.RIGHT;
        if (!isEdge(Direction.RIGHT)) {
            position.x += speed;
            
        }
    }
    
    public boolean isEdge(int direction){
        boolean ret = hasImpact(edges[direction]);
        return ret;
    }

    @Override
    public void wasStruck(Tangible obj) {
        int damage = obj.causeDamage();
        
    }

    @Override
    public int causeDamage() {
        return 0;
    }
    
    public void fire(){
        int x = 0, y = 0;
        if (!missile.isActive){
            switch(direction){
                case Direction.UP:
                    x = position.x + size/3;
                    y = position.y - 2;
                    break;
                case Direction.DOWN:
                    x = position.x + size/3;
                    y = position.y + size + 2;
                    break;
                case Direction.LEFT:
                    x = position.x - 2;
                    y = position.y + size/3;
                    break;
                case Direction.RIGHT:
                    x = position.x + size + 2;
                    y = position.y + size/3;
                    break;
            }
            missile.start(x, y, direction);
        }
    }
}
