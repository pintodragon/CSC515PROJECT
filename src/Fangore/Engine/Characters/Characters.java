/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Characters;

import Fangore.Engine.GameManager;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public abstract class Characters {
    protected String name;
    protected Rectangle location;
    protected int speed = 0;

    public Characters(String newName, Rectangle startingLocation, boolean moves)
    {
        name = newName;
        location = startingLocation;
        if (moves)
        {
            speed = GameManager.getGameManager().getCurrentMap().getTileSize() / 3;
        }
    }

    public String getName()
    {
        return name;
    }

    public Rectangle getLocation()
    {
        return location;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void updateLocation(int dx, int dy)
    {
        System.out.println(location.x + " " + location.y);
        location.translate(dx * speed, dy * speed);
        System.out.println(dx + " " + dy);
        System.out.println(location.x + " " + location.y);
    }

    public abstract void draw(Graphics g);
}
