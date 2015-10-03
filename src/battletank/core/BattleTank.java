/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.core;

import battletank.objects.Background;
import battletank.objects.Tank;
import battletank.utils.Drawable;
import java.awt.EventQueue;

/**
 *
 * @author Tiago
 */
public class BattleTank extends Game{
    
    public final Background background;
    public final Tank player1;

    public BattleTank() {
        super(30);
        int screenWidth = 800;
        int screenHeigth = 600;
        System.out.println("Saida "+getClass().getResource("/Imagens/tank.jpg").toString());
        player1 = new Tank(getClass().getResource("/Imagens/tank.jpg"),
                10, 10, 10, screenWidth, screenHeigth);
        
        Drawable[] drawableObjects;
        drawableObjects = new Drawable[1];
        drawableObjects[0] = player1;
        
        background = new Background(
                getClass().getResource("/Imagens/background.jpg"),
                drawableObjects);
    }

    @Override
    public void processLogics() {
        int xx = 2; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void renderGraphics() {
        background.renderGraphics();
    }

    @Override
    public void paintScreen() {
        background.paintScreen();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                BattleTank bt = new BattleTank();
                bt.background.setVisible(true);
                new Thread(new MainLoop(bt), "Game Thread").start();
            }
        });
    }
}
