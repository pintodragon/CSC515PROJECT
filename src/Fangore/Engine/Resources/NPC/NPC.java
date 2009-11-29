/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.NPC;

import Fangore.Engine.Characters.Characters;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author justin.chrysler
 */
public class NPC extends Characters {
    protected NPCTypeEnum npcTypeEnum;

    public NPC(String newName, List<NPCMapInfo> maps, NPCTypeEnum newNPCTypeEnum, boolean moves)
    {
        super(newName,
              maps,
              moves);

        npcTypeEnum = newNPCTypeEnum;
    }

    public NPCTypeEnum getNPCType()
    {
        return npcTypeEnum;
    }

    @Override
    public void draw(Graphics g) {
        Rectangle npcLocation = getLocation();
        String npcLetter = "" + getName().charAt(0);

        switch(npcTypeEnum)
        {
            case FOE:
                g.setColor(Color.yellow);
                break;
            case FRIEND:
                g.setColor(Color.WHITE);
                break;
            default:
                g.setColor(Color.yellow);
        }
        
        g.drawRoundRect(npcLocation.x, npcLocation.y, npcLocation.width, npcLocation.height, 5, 5);
        g.drawString(npcLetter, npcLocation.x + 4, npcLocation.y + npcLocation.height - 3);
    }
}
