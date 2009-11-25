/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Characters;

import Fangore.Engine.GameManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public class Player extends Characters {
    
    public Player()
    {
        super("Fangore", new Rectangle(5, 
             2 * GameManager.getGameManager().getCurrentMap().getTileSize() + 5,
             GameManager.getGameManager().getCurrentMap().getTileSize() - 10,
             GameManager.getGameManager().getCurrentMap().getTileSize() - 10),
             true);
    }

    @Override
    public void draw(Graphics g)
    {
        // TODO Won't draw in a new location for some reason.
        g.setColor(Color.red);
        g.drawRoundRect(location.x, location.y, location.width, location.height, 5, 5);
        g.drawString("P", location.x + 4, location.y + location.height - 3);
    }
}
