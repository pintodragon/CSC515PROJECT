/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Input;

import Fangore.Engine.GameManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 *
 * @author justin.chrysler
 */
public class KeyInput extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        switch(GameManager.getGameManager().getGameState())
        {
            case PLAYING:
                processInGameEvent(keyEvent);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        switch(GameManager.getGameManager().getGameState())
        {
            case PLAYING:
                processInGameEvent(keyEvent);
                break;
            default:
                break;
        }
    }

    private void processInGameEvent(KeyEvent keyEvent)
    {
        switch(keyEvent.getKeyCode())
        {
            case (KeyEvent.VK_DOWN):
                break;
            default:
                break;
        }
    }
}
