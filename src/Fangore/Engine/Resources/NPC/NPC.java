/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.NPC;

import Fangore.Engine.GameManager;
import Fangore.Engine.Characters.Characters;
import java.awt.Rectangle;

/**
 *
 * @author justin.chrysler
 */
public abstract class NPC extends Characters {
    protected NPCType npcType;

    public NPC(String newName, Rectangle startingLocation, boolean moves)
    {
        super(newName,
              startingLocation,
              moves);
    }

    public abstract NPCType getNPCType();
}
