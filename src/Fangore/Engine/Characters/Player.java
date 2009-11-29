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

    protected Rectangle location;
    
    public Player()
    {
        super("Fangore", null, true);
        int tileSize = GameManager.getGameManager().getCurrentMap().getTileSize();
        location = new Rectangle(5, 2 * tileSize + 5, tileSize - 10, tileSize - 10);
    }

    @Override
    public Rectangle getLocation()
    {
        return location;
    }

    @Override
    public void updateLocation(int dx, int dy)
    {
        location.translate(dx * speed, dy * speed);
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
