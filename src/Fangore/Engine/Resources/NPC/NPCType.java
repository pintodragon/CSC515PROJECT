/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.NPC;

/**
 *
 * @author justin.chrysler
 */
public enum NPCType {
    FRIEND(1, "Friend"),
    FOE(2, "Foe");

    protected int id;
    protected String type;

    private NPCType(int typeID, String typeName)
    {
        id = typeID;
        type = typeName;
    }
}
