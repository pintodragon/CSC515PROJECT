package Fangore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Fangore.Engine.GameState;
import Fangore.Engine.GameManager;
import javax.swing.BoxLayout;
import javax.swing.JApplet;

/**
 *
 * @author pinto
 */
public class FangoreMain extends JApplet{

    protected GameManager gameManager;
    protected boolean menuPanelDisplayed = false;
    
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        GameManager.getGameManager(this, this.getSize());
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(GameManager.getGameManager().getCardPanel());

        this.addKeyListener(GameManager.getGameManager().getKeyInputHandler());
        this.addMouseListener(GameManager.getGameManager().getMouseInputHandler());

        // Make sure the applet can get focus.  Needed to catch key strokes.
        setFocusable(true);
        
        GameManager.getGameManager().setGameState(GameState.MENU);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
