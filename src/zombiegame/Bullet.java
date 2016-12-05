/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiegame;

/**
 *
 * @author barti
 */
public class Bullet extends Sprite {
    
    private final int GAMEFRAME_WIDTH = 800;
    private final int BULLET_SPEED = 2;
    
    public Bullet(int x, int y)
    {
        super(x,y);
        
        initBullet();
    }
    
    private void initBullet()
    {
        
        loadImage("src/images/bullet.png");
        getImageDimensions();
    }
    
    public void move()
    {
    
        x += BULLET_SPEED;
        
        if (x > GAMEFRAME_WIDTH)
        {
            vis = false;
        }
    }
}
