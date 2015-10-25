/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.core;

import battletank.models.Background;
import battletank.models.Boss;
import battletank.models.Tank;
import battletank.models.Drawable;
import battletank.models.Edge;
import battletank.models.Movable;
import battletank.utils.Direction;
import battletank.utils.Keyboard;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 *
 * @author Tiago
 */
public class BattleTank extends Game{
    
    public final Background background;
    public final Tank player1;
    public final Boss boss;
    public final Edge[] edges;
    public final Keyboard keyboard;
    public Drawable[] drawableObjects;
    public Movable[] movableObjects;

    public BattleTank() {
        super(30);
        int screenWidth = 800;
        int screenHeigth = 600;
        
        edges = new Edge[4];
        edges[Direction.DOWN] = new Edge(Direction.DOWN, screenWidth, screenHeigth);
        edges[Direction.UP] = new Edge(Direction.UP, screenWidth, screenHeigth);
        edges[Direction.LEFT] = new Edge(Direction.LEFT, screenWidth, screenHeigth);
        edges[Direction.RIGHT] = new Edge(Direction.RIGHT, screenWidth, screenHeigth);
        
        player1 = new Tank(getClass().getResource("/Imagens/tank1.png"),
                10, 10, 10, edges);
        
        boss = new Boss(getClass().getResource("/Imagens/tank1.png"),
                screenWidth-80, screenHeigth-80, 10, edges, player1.position);
        
        keyboard = new Keyboard();
        drawableObjects = new Drawable[3];
        drawableObjects[0] = player1;
        drawableObjects[1] = player1.missile;
        drawableObjects[2] = boss;
        
        movableObjects = new Movable[2];
        movableObjects[0] = player1.missile;
        movableObjects[1] = boss;
        
        player1.missile.targets.addAll(Arrays.asList(edges));
       
        background = new Background(
                getClass().getResource("/Imagens/background.jpg"),
                drawableObjects, screenWidth, screenHeigth);
        
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
        
        if (keyboard.isKeyPressed(KeyEvent.VK_SPACE)){
            player1.fire();
        }
        
        for(Movable m : movableObjects){
            m.move();
        }
        player1.missile.update();
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
