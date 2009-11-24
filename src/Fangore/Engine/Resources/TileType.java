/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources;

/**
 *
 * @author justin.chrysler
 */
public enum TileType {
    WALL(false, 1),
    WATER(false, 2),
    ROAD(true, 3),
    GRASS(true, 4);

    protected boolean canTravel = false;
    protected int intValue = 0;

    private TileType(boolean canTravel, int value)
    {
        this.canTravel = canTravel;
        intValue = value;
    }

    public static TileType getIntType(int type)
    {
        TileType tileType = TileType.GRASS;

        switch(type)
        {
            case 1:
                tileType = TileType.WALL;
                break;
            case 2:
                tileType = TileType.WATER;
                break;
            case 3:
                tileType = TileType.ROAD;
                break;
            default:
                break;
        }

        return tileType;
    }

    public boolean canTravel()
    {
        return canTravel;
    }
}
