/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fangore.Engine.Resources.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public class Tile
{

    protected TileType type;
    protected Rectangle location;

    public Tile(TileType newType, int x, int y, int tileSize)
    {
        type = newType;
        location = new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize);
    }

    public Rectangle getLocation()
    {
        return location;
    }

    public boolean canTravel()
    {
        return type.canTravel();
    }

    public void draw(Graphics g)
    {
        switch (type)
        {
            case WALL:
                g.setColor(Color.GRAY);
                break;
            case WATER:
                g.setColor(Color.BLUE);
                break;
            case ROAD:
                // new Color(68, 68, 0) is brown
                g.setColor(new Color(68, 68, 0));
                break;
            case GRASS:
                g.setColor(Color.GREEN);
                break;
            default:
                break;
        }

        g.fillRect(location.x, location.y, location.width, location.height);
    }
}
