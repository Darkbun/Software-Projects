package snakegame;

import javax.swing.*;

public class SnakeGame extends JFrame
{
    SnakeGame() {
        super("Snake Game"); // super should be the first line of constructor
        add(new Board());
        pack(); //refresh screen

//        setLocation(100, 100);
//        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);


    }

    public static void main(String[] a)
    {
        new SnakeGame().setVisible(true); // same work as pack function, but we can call it once
    }
}
