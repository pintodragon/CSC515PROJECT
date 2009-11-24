package Fangore.Engine;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinto
 */
public class BattleCanvas extends JPanel {

    BattleCanvas()
    {
        super(true);
    }

    BattleCanvas(Dimension appSize) {
        this();
        this.setSize(appSize);
    }

    @Override
    public void paint(Graphics g)
    {
        switch(GameManager.getGameManager().getGameState())
        {
            case MENU:
                break;
            case INIT:
                resetCanvas(g);
                break;
            case PLAYING:
                resetCanvas(g);
                break;
            case GAME_OVER:
                resetCanvas(g);
                break;
            default:
                break;
        }
    }

    private void resetCanvas(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getSize().width, getSize().height);
    }
}
