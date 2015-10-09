/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Direction;
import battletank.utils.Point;

/**
 *
 * @author Tiago Vitrola
 */
public class Edge implements Tangible{
    
    Point position;
    int size;
    
    public Edge(int direction, int screenWeight, int screenHeight){
        switch(direction){
            case Direction.UP:
                position = new Point(0, 0-screenHeight);
                size = screenWeight;
            case Direction.DOWN:
                position = new Point(0, screenHeight);
                size = screenWeight;
            case Direction.LEFT:
                position = new Point(0-screenWeight, 0);
                size = screenHeight;
            case Direction.RIGHT:
                position = new Point(screenWeight, 0);
                size = screenHeight;
        }
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean hasImpact(Tangible target) {
        Point targetPosition = target.getPosition();
        int targetSize = target.getSize();
        
        return !(targetPosition.y+targetSize < position.y ||
                targetPosition.x > position.x+size ||
                targetPosition.x+targetSize < position.x ||
                targetPosition.y > position.y+size);
    }

    @Override
    public void wasStruck(Tangible obj) {
    }

    @Override
    public int causeDamage() {
        return 0;
    }
    
}
