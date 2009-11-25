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
        return null;
    }
}
