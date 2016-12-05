/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiegame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author barti
 */
public class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private boolean ingame;
    private ArrayList<Zombie> zombies;
    private final int DELAY = 10;
    private final int PLAYER_X = 40;
    private final int PLAYER_Y = 60;
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    
    private final int[][] pos = {
        {2380, 529}, {2500, 324}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 355}, {790, 150},
        {980, 209}, {560, 296}, {510, 381},
        {930, 159}, {590, 80}, {530, 500},
        {940, 30}, {990, 380}, {920, 200},
        {900, 259}, {660, 450}, {540, 231},
        {810, 220}, {860, 325}, {740, 180},
        {820, 128}, {490, 170}, {700, 333}
    };
       
    public GamePanel ()
    {
        initGamePanel();
    }

    private void initGamePanel() {
        
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        ingame = true;
        
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        player = new Player(PLAYER_X,PLAYER_Y);
        
        initZombies();
        
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initZombies()
    {
    zombies = new ArrayList<>();
    
        for (int[] p : pos) {
            zombies.add(new Zombie(p[0], p[1]));
        }
    }
    
    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent(g);
        
        if (ingame) {
            drawObjects(g);
        }
        else{
            drawGameOver(g);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects( Graphics g )
    {
        
        if (player.isVis()){
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }
        
        ArrayList<Bullet> bs = player.getBullets();

        for (Bullet b : bs) {
            if (b.isVis()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }    
        
        for (Zombie z : zombies) {
            if (z.isVis()) {
                g.drawImage(z.getImage(), z.getX(), z.getY(), this);
            }
        }
        
        g.setColor(Color.BLACK);
        g.drawString("Zombies left: " + zombies.size(), 5, 15);
    }
    
    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateZombies();
        updateBullets();
        updatePlayer();
        
        checkCollisions();
        
        repaint();
    }
    
    private void updateZombies() {

        if (zombies.isEmpty()) {

            ingame = false;
            return;
        }
        
        for (int i = 0; i < zombies.size(); i++) {

            Zombie z = zombies.get(i);
            if (z.isVis()) {
                z.move();
            } else {
                zombies.remove(i);
            }
        }
    }
    
    
    private void updateBullets()
    {
        ArrayList bs = player.getBullets();
        
        for (int i = 0; i < bs.size(); i++) 
        {
          Bullet b = (Bullet) bs.get(i);  
        
        if (b.isVis())
        {
            b.move();
        }
        else
        {
            bs.remove(i);
        }
        
        }
    }
    
    private void updatePlayer()
    {
        player.move();
    }
    
    public void checkCollisions() {

        Rectangle r3 = player.getBounds();

        for (Zombie zombie : zombies) {
            Rectangle r2 = zombie.getBounds();

            if (r3.intersects(r2)) {
                player.setVis(false);
                zombie.setVis(false);
                ingame = false;
            }
        }
        ArrayList<Bullet> bs = player.getBullets();

        for (Bullet b : bs) {

            Rectangle r1 = b.getBounds();

            for (Zombie zombie : zombies) {

                Rectangle r2 = zombie.getBounds();

                if (r1.intersects(r2)) {
                    b.setVis(false);
                    zombie.setVis(false);
                }
            }
        }
    }    
    private class TAdapter extends KeyAdapter
    {
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            player.keyPressed(e);
        }
    }
}
