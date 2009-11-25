/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources.Map;

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
public class MapResourceLoader implements ResourceLoader<Map> {

    protected static String lineSep = System.getProperty("file.separator");
    
    public LinkedHashMap<String, Map> loadResource(JApplet parent)
    {
        JAXBElement<MapListType> mlt = null;

        try
        {
            URL url = new URL(parent.getDocumentBase(), "Maps.xml");
            JAXBContext jc = JAXBContext.newInstance("Fangore.Engine.Resources.Map");
            Unmarshaller u = jc.createUnmarshaller();
            mlt = (JAXBElement<MapListType>) u.unmarshal(url);
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }

        return generateMapHashMap(mlt.getValue());
    }

    protected static LinkedHashMap<String, Map> generateMapHashMap(MapListType mlt)
    {
        LinkedHashMap<String, Map> mapHash = new LinkedHashMap<String, Map>();

        for (MapType currentMap : mlt.getMap())
        {
            Map newMap = new Map(currentMap.getName(),
                                 currentMap.getTileSize(),
                                 generateTiles(currentMap));
            mapHash.put(newMap.getName(), newMap);
        }

        return mapHash;
    }

    protected static Tile[][] generateTiles(MapType mapType)
    {
        Tile[][] mapTiles = new Tile[mapType.getHeight()][mapType.getWidth()];

        int y = 0;
        for (String currentRow : mapType.getTileRow())
        {
            String[] tileTypes = currentRow.split(",");
            for (int x = 0; x < tileTypes.length; x++)
            {
                mapTiles[y][x] = new Tile(TileType.getIntType(
                    Integer.parseInt(tileTypes[x])),
                    x, y,
                    mapType.getTileSize());
            }
            y++;
        }

        return mapTiles;
    }
}
