package Fangore.Engine;


import Fangore.Engine.Resources.Map.Map;
import Fangore.Input.KeyInput;
import Fangore.Input.MouseInput;
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
public class GameCanvas extends JPanel {

    GameCanvas(Dimension appSize)
    {
        super(true);
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
            case PLAYING:
                resetCanvas(g);
                paintsomething(g);
                break;
            case GAME_OVER:
                resetCanvas(g);
                paintsomething(g);
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

    private void paintsomething(Graphics g)
    {
        Map currentMap = GameManager.getGameManager().getCurrentMap();
        int tileSize = currentMap.getTileSize();

        for (int x = 0; x < getSize().width / tileSize; x++)
        {
            for (int y = 0; y < getSize().height / tileSize; y++)
            {
                currentMap.getTile(y, x).draw(g);
            }
        }

        GameManager.getGameManager().getPlayer().draw(g);
    }
}
