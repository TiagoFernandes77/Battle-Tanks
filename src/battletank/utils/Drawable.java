/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Tiago
 */
public abstract class Drawable {
    private Point position;
    private BufferedImage image;
    
    public Drawable(java.net.URL fileName, int x, int y) {
        try {
            image = ImageIO.read(fileName);
        }
        catch (IOException ex) {
            Logger.getLogger(Drawable.class.getName()).log(Level.SEVERE, null, ex);
        }
        position = new Point(x, y);
    }
    
    public void draw(Graphics2D g2d) {
		Graphics2D g = (Graphics2D) g2d.create();		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawImage(image, position.x, position.y, null);
		g.dispose();
    }
    
    public Point getPosition(){
        return position;
    }
    
    public void setPosition(int x, int y){
        position.x = x;
        position.y = y;
    }
    
}
