/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.core;

import battletank.models.Background;
import battletank.models.Tank;
import battletank.models.Creature;
import battletank.utils.Keyboard;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tiago
 */
public class BattleTank extends Game{
    
    public final Background background;
    public final Tank player1;
    public final Keyboard keyboard;

    public BattleTank() {
        super(30);
        int screenWidth = 800;
        int screenHeigth = 600;
        player1 = new Tank(getClass().getResource("/Imagens/tank1.png"),
                10, 10, 10, screenWidth, screenHeigth);
        keyboard = new Keyboard();
        Creature[] drawableObjects;
        drawableObjects = new Creature[1];
        drawableObjects[0] = player1;
        
        background = new Background(
                getClass().getResource("/Imagens/background.jpg"),
                drawableObjects);
        
        background.addKeyListener(keyboard);
    }

    @Override
    public void processLogics() {
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
            player1.turnUp();
        }
        
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
            player1.turnDown();
        }
        
        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
            player1.turnLeft();
        }
        
        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
            player1.turnRigth();
        }
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
