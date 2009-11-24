/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;
import javax.swing.JApplet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author justin.chrysler
 */
public class ResourceLoader {

    protected static String lineSep = System.getProperty("file.separator");

    private ResourceLoader()
    {

    }

    public static LinkedHashMap<String, Map> getMapList(JApplet parent)
    {
        Document xmlDocument = null;

        try
        {
            DocumentBuilder docBuilder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();

           URL url = new URL(parent.getDocumentBase(), "Maps.xml");
           File mapFile = new File(new URI(url.toString()));

            xmlDocument = docBuilder.parse(mapFile);
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }

        return getMaps(xmlDocument.getElementsByTagName("Map"));
    }

    public static LinkedHashMap<String, NPC> getNPCList(JApplet parent)
    {
        Document xmlDocument = null;

        try
        {
            DocumentBuilder docBuilder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();

           URL url = new URL(parent.getDocumentBase(), "Npcs.xml");
           File mapFile = new File(new URI(url.toString()));

            xmlDocument = docBuilder.parse(mapFile);
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }

        return getNPCs(xmlDocument.getElementsByTagName("NPC"));
    }

    private static LinkedHashMap<String, Map> getMaps(final NodeList mapNodeList)
    {
        LinkedHashMap<String, Map> mapList = new LinkedHashMap<String, Map>();

        for (int index = 0; index < mapNodeList.getLength(); index++)
        {
            Element currentNode = (Element) mapNodeList.item(index);

            if (currentNode.getNodeName().equals("Map"))
            {
                NodeList childrenList = currentNode.getChildNodes();
                int tileSize = getMapTileSize(childrenList);
                Map currentMap = new Map(
                    getMapName(childrenList),
                    tileSize,
                    getMapTiles(childrenList, tileSize));

                mapList.put(currentMap.getName(), currentMap);
            }
        }

        return mapList;
    }

    private static String getMapName(final NodeList nodeList)
    {
        String name = "default";

        for (int index = 0; index < nodeList.getLength(); index++)
        {
            if (nodeList.item(index).getNodeName().equals("NameInfo"))
            {
                Element nameElement = (Element) nodeList.item(index);
                if (nameElement.hasAttributes())
                {
                    name = nameElement.getAttribute("name");
                    break;
                }
            }
        }

        return name;
    }

    private static int getMapTileSize(final NodeList nodeList)
    {
        int mapTileSize = 25;

        for (int index = 0; index < nodeList.getLength(); index++)
        {
            if (nodeList.item(index).getNodeName().equals("TileSize"))
            {
                Element nameElement = (Element) nodeList.item(index);
                if (nameElement.hasAttributes())
                {
                    mapTileSize = Integer.parseInt(nameElement.getAttribute("size"));
                    break;
                }
            }
        }

        return mapTileSize;
    }

    private static Tile[][] getMapTiles(final NodeList nodeList, final int tileSize)
    {
        Tile[][] tiles = null;

        for (int index = 0; index < nodeList.getLength(); index++)
        {
            if (nodeList.item(index).getNodeName().equals("Tiles"))
            {
                Element nameElement = (Element) nodeList.item(index);
                int width = 0;
                int height = 0;

                if (nameElement.hasAttributes())
                {
                    width = Integer.parseInt(nameElement.getAttribute("Width"));
                    height = Integer.parseInt(nameElement.getAttribute("Height"));
                    tiles = createTileArray(width, height, nameElement.getChildNodes(), tileSize);
                }
                break;
            }
        }

        return tiles;
    }

    private static Tile[][] createTileArray(final int width, final int height, final NodeList tileList, final int tileSize)
    {
        Tile[][] tiles = new Tile[height][width];

        int y = 0;
        for (int index = 0; index < tileList.getLength(); index++)
        {
            if (tileList.item(index).getNodeName().equals("Row"))
            {
                Element currentNode = (Element) tileList.item(index);
                if (currentNode.hasAttribute("values") && y < tiles.length)
                {
                    String[] tileValues = currentNode.getAttribute("values").split(",");
                    for (int x = 0; x < tiles[y].length; x++)
                    {
                        if (x < tileValues.length)
                        {
                            tiles[y][x] = new Tile(TileType.getIntType(Integer.parseInt(tileValues[x])), x * tileSize, y * tileSize, tileSize);
                        }
                        else
                        {
                            tiles[y][x] = new Tile(TileType.GRASS, x * tileSize, y * tileSize, tileSize);
                        }
                    }

                    y++;
                }
            }
        }
        return tiles;
    }

    private static LinkedHashMap<String, NPC> getNPCs(final NodeList npcNodeList)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
