/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Characters;

import Fangore.Engine.GameManager;
import Fangore.Engine.Resources.NPC.NPCMapInfo;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author justin.chrysler
 */
public abstract class Characters {
    protected String name;
    protected LinkedHashMap<String, Rectangle> locationHashMap;
    protected int speed = 0;

    public Characters(String newName, List<NPCMapInfo> mapList, boolean moves)
    {
        locationHashMap = new LinkedHashMap<String, Rectangle>();
        name = newName;
        if (moves)
        {
            speed = 3;
        }

        if (mapList != null)
        {
            int tileSize = GameManager.getGameManager().getCurrentMap().getTileSize();
            for (NPCMapInfo mapInfo : mapList)
            {
                Rectangle currentRect = new Rectangle(
                    mapInfo.getInitialTileX() * tileSize + 5,
                    mapInfo.getInitialTileY() * tileSize + 5,
                    tileSize - 10,
                    tileSize - 10);
                locationHashMap.put(mapInfo.getMapName(), currentRect);
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public Rectangle getLocation()
    {
        return locationHashMap.get(GameManager.getGameManager().getCurrentMap().getName());
    }

    public int getSpeed()
    {
        return speed;
    }

    public void updateLocation(int dx, int dy)
    {
        locationHashMap.get(GameManager.getGameManager().getCurrentMap().getName()).translate(dx * speed, dy * speed);
    }

    public boolean onMap(String mapName)
    {
        return locationHashMap.keySet().contains(mapName);
    }

    public abstract void draw(Graphics g);
}
