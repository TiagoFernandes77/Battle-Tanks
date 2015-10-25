/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Point;
import java.net.URL;
import javafx.scene.CacheHint;

/**
 *
 * @author Tiago
 */
public class Boss extends Tank implements Movable{
    
    public Point enemyPosition;
    
    public Boss(URL fileName, int x, int y, int speed, Edge[] edges, Point ePosition) {
        super(fileName, x, y, speed/2, edges);
        enemyPosition = ePosition;
    }

    @Override
    public void move() {
        if (position.x + 5 > enemyPosition.x)
            turnLeft();
        else
            turnRigth();
        
        if (position.y + 5 > enemyPosition.y)
            turnUp();
        else
            turnDown();
    }
    
}
