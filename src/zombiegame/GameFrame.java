/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiegame;

import javax.swing.*;

/**
 *
 * @author barti
 */
public class GameFrame extends JFrame {
    
    public GameFrame()
    {
        setTitle("Game screen");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel());
        setResizable(false);
        setVisible(true);
    }    
}

