/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Characters;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public abstract class Characters {
    protected String name;
    protected Rectangle location;

    public Characters(String newName, Rectangle startingLocation)
    {
        name = newName;
        location = startingLocation;
    }

    public String getName()
    {
        return name;
    }

    public Rectangle getLocation()
    {
        return location;
    }

    public abstract void draw(Graphics g);
}
