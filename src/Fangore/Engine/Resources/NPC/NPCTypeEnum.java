/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.NPC;

/**
 *
 * @author justin.chrysler
 */
public enum NPCTypeEnum {
    FRIEND(1, "Friend"),
    FOE(2, "Foe");

    protected int id;
    protected String type;

    private NPCTypeEnum(int typeID, String typeName)
    {
        id = typeID;
        type = typeName;
    }

    public static NPCTypeEnum getIntType(int intType)
    {
        NPCTypeEnum npcType = NPCTypeEnum.FRIEND;

        switch(intType)
        {
            case 1:
                npcType = NPCTypeEnum.FRIEND;
                break;
            case 2:
                npcType = NPCTypeEnum.FOE;
                break;
            default:
                break;
        }

        return npcType;
    }
}
