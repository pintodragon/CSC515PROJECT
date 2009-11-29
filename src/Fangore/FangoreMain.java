package Fangore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Fangore.Engine.GameState;
import Fangore.Engine.GameManager;
import Fangore.Engine.Input.KeyInput;
import Fangore.Engine.Input.MouseInput;
import javax.swing.BoxLayout;
import javax.swing.JApplet;

/**
 *
 * @author pinto
 */
public class FangoreMain extends JApplet{
    
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() {
        GameManager.getGameManager(this, this.getSize());
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(GameManager.getGameManager().getCardPanel());

        // Make sure the applet can get focus.  Needed to catch key strokes.
        setFocusable(true);

        this.addKeyListener(new KeyInput());
        this.addMouseListener(new MouseInput());
    }

    @Override
    public void destroy()
    {
        GameManager.getGameManager().destroySelf();
    }
}
