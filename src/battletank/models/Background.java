/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Tiago
 */
public class Background extends JFrame{
    private BufferedImage screen;
    private Drawable[] objects;
    
    public Background(java.net.URL fileName, Drawable[] objects, int x, int y){
        super("Tank Battle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(x, y);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.objects = objects;
        try {
            screen = ImageIO.read(fileName);
        } catch (Exception ex) {
            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void renderGraphics() {
        Graphics g = getBufferStrategy().getDrawGraphics();
     
        //Contexto gráfico que não leva em conta as bordas
        Graphics g2 = g.create(getInsets().left, 
               getInsets().top, 
               getWidth() - getInsets().right, 
               getHeight() - getInsets().bottom);
        
        g2.drawImage(screen, 0, 0, null);
        
        for(Drawable obj : objects){
            obj.draw((Graphics2D) g2);
        }
        g.dispose();
        g2.dispose();
    }
    
    public void paintScreen() {
        if (!getBufferStrategy().contentsLost())
            getBufferStrategy().show();
    }
}
