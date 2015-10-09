/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Point;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tiago
 */
public abstract class Creature implements Drawable, Tangible{
    public Point position;
    public int size;
    public BufferedImage image;
    public int direction;
    
    public Creature(java.net.URL fileName, int x, int y, int cutSize, int initDirection) {
        try {
            image = ImageIO.read(fileName);
        }
        catch (IOException ex) {
            Logger.getLogger(Creature.class.getName()).log(Level.SEVERE, null, ex);
        }
        position = new Point(x, y);
        this.size = cutSize;
        direction = initDirection;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
		Graphics2D g = (Graphics2D) g2d.create();		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawImage(image, position.x, position.y,
                        position.x+size, position.y+size,
                        size*direction, 0, size*(direction+1), size,
                        null);
		g.dispose();
    }
    
    @Override
    public Point getPosition(){
        return position;
    }
    
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
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
    public abstract void wasStruck(Tangible obj);

    @Override
    public abstract int causeDamage();
    
}
