/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.NPC;

import Fangore.Engine.Resources.ResourceLoader;
import java.net.URL;
import java.util.LinkedHashMap;
import javax.swing.JApplet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author justin.chrysler
 */
@SuppressWarnings("unchecked")
public class NPCResourceLoader implements ResourceLoader<NPC> {

    protected static String lineSep = System.getProperty("file.separator");
    
    public LinkedHashMap<String, NPC> loadResource(JApplet parent)
    {
        JAXBElement<NPCListType> nlt = null;

        try
        {
            URL url = new URL(parent.getDocumentBase(), "NPCs.xml");
            JAXBContext jc = JAXBContext.newInstance("Fangore.Engine.Resources.NPC");
            Unmarshaller u = jc.createUnmarshaller();
            nlt = (JAXBElement<NPCListType>) u.unmarshal(url);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }

        return generateNPCHashMap(nlt.getValue());
    }

    protected static LinkedHashMap<String, NPC> generateNPCHashMap(NPCListType nlt)
    {
        LinkedHashMap<String, NPC> mapHash = new LinkedHashMap<String, NPC>();

        for (NPCType currentNPC : nlt.getNPC())
        {
            NPC newMap = new NPC(
                currentNPC.getName(),
                currentNPC.getMapInfo(),
                NPCTypeEnum.getIntType(currentNPC.getType()),
                currentNPC.isCanTravel());
            mapHash.put(newMap.getName(), newMap);
        }

        return mapHash;
    }
}
