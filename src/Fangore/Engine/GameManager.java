package Fangore.Engine;

import Fangore.Engine.Characters.Player;
import Fangore.Engine.Resources.NPC.NPC;
import Fangore.Engine.Resources.Map.Map;
import Fangore.Engine.Resources.Map.MapResourceLoader;
import Fangore.Engine.Resources.ResourceLoader;
import Fangore.Input.KeyInput;
import Fangore.Input.MouseInput;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.LinkedHashMap;
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

    protected LinkedHashMap<String, Map> mapList;
    protected LinkedHashMap<String, NPC> npcList;
    protected Player player = null;
    protected String currentMapName = "";

    protected static GameManager gameManager = null;

    private GameManager()
    {
        this(null, new Dimension(100, 100));
    }

    private GameManager(JApplet parent, Dimension appSize)
    {
        ResourceLoader mapResourceLoader = new MapResourceLoader();
        mapList = mapResourceLoader.loadResource(parent);
        currentMapName = "OnlyMap";
        
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
            gameManager = new GameManager();
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

    public void gameInit()
    {
        gameManager.cardLayout.show(cardPanel, GAME_CARD);
        gameManager.setGameState(GameState.PLAYING);
        gameManager.player = new Player();
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

    public KeyInput getKeyInputHandler()
    {
        return new KeyInput();
    }

    public MouseInput getMouseInputHandler()
    {
        return new MouseInput();
    }

    public Player getPlayer()
    {
        return getGameManager().player;
    }
}
