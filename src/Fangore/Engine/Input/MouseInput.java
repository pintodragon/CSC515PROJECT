/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Input;

import Fangore.Engine.GameManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 *
 * @author justin.chrysler
 */
public class MouseInput extends MouseAdapter {

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        switch(GameManager.getGameManager().getGameState())
        {
            case PLAYING:
                processInGameEvent(mouseEvent);
                break;
            default:
                break;
        }
    }

    private void processInGameEvent(MouseEvent mouseEvent)
    {
    }
}
