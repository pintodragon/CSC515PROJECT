/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public class Player extends Characters {

    public Player(int tileSize)
    {
        super("Fangore", new Rectangle(5, 2 * tileSize + 5, tileSize - 10, tileSize - 10));
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.drawRoundRect(location.x, location.y, location.width, location.height, 5, 5);
        g.drawString("P", location.x + 4, location.y + location.height - 3);
    }
}
