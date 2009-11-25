/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fangore.Engine.Resources.Map;

import Fangore.Engine.Resources.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author justin.chrysler
 */
public class Tile
{

    protected TileType type;
    protected BufferedImage tileImage = null;
    protected Rectangle location;

    public Tile(TileType newType, int x, int y, int tileSize)
    {
        type = newType;
        tileImage = getTileImage();
        location = new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize);
    }

    public boolean canTravel()
    {
        return type.canTravel();
    }

    public BufferedImage getTileImage()
    {
        if (tileImage == null)
        {
            tileImage = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);

            switch (type)
            {
                case WALL:
                    tileImage.getGraphics().setColor(Color.GRAY);
                    break;
                case WATER:
                    tileImage.getGraphics().setColor(Color.BLUE);
                    break;
                case ROAD:
                    // new Color(68, 68, 0) is brown
                    tileImage.getGraphics().setColor(new Color(68, 68, 0));
                    break;
                case GRASS:
                    tileImage.getGraphics().setColor(Color.GREEN);
                    break;
                default:
                    break;
            }

            tileImage.getGraphics().fillRect(0, 0,
                tileImage.getWidth(),
                tileImage.getHeight());
        }

        return tileImage;
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
