/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Direction;
import battletank.utils.Point;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tiago Vitrola
 */
public class Missile implements Tangible, Drawable, Movable{

    public Point position;
    public int size;
    public boolean isActive;
    public int damage;
    public int direction;
    public BufferedImage image;
    public int speed;
    public ArrayList<Tangible> targets;
    
    public Missile(int damage, int speed){
        
        try {
            image = ImageIO.read(getClass().getResource("/Imagens/missile_1.png"));
        }
        catch (IOException ex) {
            Logger.getLogger(Creature.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        size = 20;
        this.damage = damage;
        this.speed = speed;
        isActive = false;
        position = new Point(0, 0);
        targets = new ArrayList<Tangible>();
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
        if (isActive){
            Point targetPosition = target.getPosition();
            int targetSize = target.getSize();

            return !(targetPosition.y+targetSize < position.y ||
                    targetPosition.x > position.x+size ||
                    targetPosition.x+targetSize < position.x ||
                    targetPosition.y > position.y+size);
        }
        return false;
    }

    @Override
    public void wasStruck(Tangible obj) {
        isActive = false;
    }

    @Override
    public int causeDamage() {
        return damage;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if(isActive){
            Graphics2D g = (Graphics2D) g2d.create();		
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawImage(image, position.x, position.y,
                    position.x+size, position.y+size,
                    size*direction, 0, size*(direction+1), size,
                    null);
            g.dispose();
        }
    }

    @Override
    public void move() {
        if(isActive)
            switch(direction){
                case Direction.UP:
                    position.y -= speed;
                    break;
                case Direction.DOWN:
                    position.y += speed;
                    break;
                case Direction.LEFT:
                    position.x -= speed;
                    break;
                case Direction.RIGHT:
                    position.x += speed;
                    break;
            }
    }
    
    public void start(int x, int y, int direction){
        position.set(x, y);
        isActive = true;
        this.direction = direction;
    }
    
    public void update(){
        for (int i = 0; i < targets.size(); i++){
            if (hasImpact(targets.get(i))){
                targets.get(i).wasStruck(this);
                this.wasStruck(targets.get(i));
            }
        }
    }
}
