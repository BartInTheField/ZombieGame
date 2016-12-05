/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiegame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author barti
 */
public class Player extends Sprite {
    
    private int dx;
    private int dy;
    private ArrayList<Bullet> bullets;

    
    public Player(int x, int y)
    {
        super(x,y);
        
        initPlayer();
    }
    
    private void initPlayer()
    {
    
        bullets = new ArrayList<>();
        loadImage("src/images/player.png");
        getImageDimensions();
    }
    
    public void move()
    {
        x += dx;
        y += dy;
    }

    public ArrayList getBullets() {
        return bullets;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        if (key == KeyEvent.VK_A)
        {
            dx = -1;
        }
        
        if (key == KeyEvent.VK_D)
        {
            dx = 1;
        }
        
        
        if (key == KeyEvent.VK_W)
        {
            dy = -1;
        }

        
        if (key == KeyEvent.VK_S)
        {
            dy = 1;
        }
    }
    
    public void fire() {
        bullets.add(new Bullet(x + width, y + height / 2));
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_A)
        {
            dx = 0;
        }
        
        if (key == KeyEvent.VK_D)
        {
            dx = 0;
        }
        
        if (key == KeyEvent.VK_W)
        {
            dy = 0;
        }
        
        if (key == KeyEvent.VK_S)
        {
            dy = 0;
        }
       
    }
}
