/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.Map;

import Fangore.Engine.GameManager;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public class Map {
    protected Tile tiles[][];
    protected String name;
    protected int tileSize;

    public Map(String newName, int mapTileSize, Tile[][] newTiles)
    {
        name = newName;
        tileSize = mapTileSize;
        tiles = new Tile[newTiles.length][newTiles[0].length];

        for (int index = 0; index < newTiles.length; index++)
        {
            System.arraycopy(newTiles[index], 0, tiles[index], 0, newTiles[index].length);
        }
    }

    public String getName()
    {
        return name;
    }

    public int getTileSize()
    {
        return tileSize;
    }

    public int getNumRows()
    {
        return tiles[0].length;
    }

    public int getNumCols()
    {
        return tiles.length;
    }

    public Tile getTile(int col, int row)
    {
        return tiles[col][row];
    }

    public boolean isInvalidMovement(Rectangle playerRect) {
        boolean invalidMove = false;

        for (int y = 0; y < tiles.length; y++)
        {
            for (int x = 0; x < tiles[y].length; x++)
            {
                if (tiles[y][x].getLocation().intersects(playerRect)
                    && !tiles[y][x].canTravel())
                {
                    invalidMove = true;
                    break;
                }
            }
        }

        if (playerRect.x < 0 || playerRect.x + playerRect.width > GameManager.getGameManager().getGameCanvas().getWidth()
            || playerRect.y < 0 || playerRect.y + playerRect.height  > GameManager.getGameManager().getGameCanvas().getHeight())
        {
            invalidMove = true;
        }

        return invalidMove;
    }
}
