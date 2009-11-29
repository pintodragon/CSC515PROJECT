package Fangore.Engine;

import Fangore.Engine.Characters.Player;
import Fangore.Engine.Resources.NPC.NPC;
import Fangore.Engine.Resources.Map.Map;
import Fangore.Engine.Resources.Map.MapResourceLoader;
import Fangore.Engine.Resources.NPC.NPCResourceLoader;
import Fangore.Engine.Resources.ResourceLoader;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinto
 */
@SuppressWarnings("unchecked")
public class GameManager {

    public static final String MENU_CARD = "Menu Card";
    public static final String GAME_CARD = "Game Card";

    protected JPanel cardPanel = null;
    protected CardLayout cardLayout = null;
    protected GameCanvas gameCanvas = null;
    protected MenuCanvas menuCanvas = null;
    protected GameState currentState = GameState.INIT;
    protected JApplet parent = null;

    protected LinkedHashMap<String, Map> mapList;
    protected LinkedHashMap<String, NPC> npcList;
    protected Player player = null;
    protected String currentMapName = "";

    protected static GameManager gameManager = null;

    private GameManager(JApplet parentApplet, Dimension appSize)
    {
        parent = parentApplet;
        currentMapName = "OnlyMap";
        mapList = new MapResourceLoader().loadResource(parent);
        
        gameCanvas = new GameCanvas(appSize);
        menuCanvas = new MenuCanvas(appSize);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(menuCanvas, MENU_CARD);
        cardPanel.add(gameCanvas, GAME_CARD);

        cardLayout.show(cardPanel, MENU_CARD);
    }

    public static GameManager getGameManager()
    {
        if (gameManager == null)
        {
            throw new UnsupportedOperationException(
                    "GameManager must be initialized using\n getGameManager(" +
                    "JApplet parent, Dimension appSize) prior\n to using " +
                    "getGameManager() except when a refresh of the\n page occurs.");
        }

        return gameManager;
    }

    public static GameManager getGameManager(JApplet parent, Dimension appSize)
    {
        if (gameManager == null)
        {
            gameManager = new GameManager(parent, appSize);
        }

        return gameManager;
    }

    public void destroySelf()
    {
        gameCanvas.stopTimer();
        gameManager = null;
    }

    public void gameInit()
    {
        npcList = new NPCResourceLoader().loadResource(parent);
        gameManager.cardLayout.show(cardPanel, GAME_CARD);
        gameManager.setGameState(GameState.PLAYING);
        gameManager.player = new Player();
    }

    public void updateLocations()
    {
        
    }

    public Map selectMap(String name)
    {
        currentMapName = name;
        return mapList.get(currentMapName);
    }

    public Map getCurrentMap()
    {
        return mapList.get(currentMapName);
    }

    public JPanel getCardPanel()
    {
        return getGameManager().cardPanel;
    }

    public GameCanvas getGameCanvas()
    {
        return getGameManager().gameCanvas;
    }

    public MenuCanvas getMenuCanvas()
    {
        return getGameManager().menuCanvas;
    }

    public void setGameState(GameState gameState)
    {
        getGameManager().currentState = gameState;
    }

    public GameState getGameState()
    {
        return getGameManager().currentState;
    }

    public Player getPlayer()
    {
        return getGameManager().player;
    }

    public ArrayList<NPC> getCurrentMapNPCs()
    {
        ArrayList<NPC> returnNPCList = new ArrayList<NPC>();

        if (npcList != null)
        {
            for (NPC currentNPC : npcList.values())
            {
                if (currentNPC.onMap(currentMapName))
                {
                    returnNPCList.add(currentNPC);
                }
            }
        }

        return returnNPCList;
    }
}
