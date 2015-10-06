/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.utils;

/**
 *
 * @author Tiago
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Keyboard implements KeyListener{
    
    private static final Map<Integer, Boolean> keyBoard = new HashMap<>();
    
    public boolean isKeyPressed(int keyCode){
        if (keyBoard.containsKey(keyCode))
            return keyBoard.get(keyCode);
        else
            return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyBoard.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyBoard.put(e.getKeyCode(), false);
    }
}
