/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources;

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
}
