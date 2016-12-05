/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiegame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author barti
 */
public class Sprite {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
    
    public Sprite(int x, int y)
    {
        this.x = x;
        this.y = y;
        vis = true;
        
    }
    
    protected void loadImage(String imageName)
        {
        ImageIcon bulletImage = new ImageIcon(imageName);
        image = bulletImage.getImage();
        }
    
    protected void getImageDimensions()
    {
    
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVis() {
        return vis;
    }

    public Image getImage() {
        return image;
    }

    public void setVis(boolean visible) {
        vis = visible;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
}
