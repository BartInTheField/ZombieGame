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
public class Zombie extends Sprite {
    
    private final int INITIAL_X = 800;
    
    public Zombie(int x, int y)
    {
        super(x,y);
        
        initZombie();
    }
    
    private void initZombie()
    {
    
        loadImage("src/images/zombie.png");
        getImageDimensions();
    }
    
    public void move()
    {
    
        if (x <0)
        {
            x = INITIAL_X;
        }
        
        x -= 1;
    }
}
