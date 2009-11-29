/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Input;

import Fangore.Engine.GameManager;
import java.awt.Rectangle;
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

    private void processInGameEvent(KeyEvent keyEvent)
    {
        int dx = 0, dy = 0;

        switch(keyEvent.getKeyCode())
        {
            case (KeyEvent.VK_DOWN):
                dy = 1;
                break;
            case (KeyEvent.VK_UP):
                dy = -1;
                break;
            case (KeyEvent.VK_LEFT):
                dx = -1;
                break;
            case (KeyEvent.VK_RIGHT):
                dx = 1;
                break;
            default:
                break;
        }

        movePlayer(dx, dy);
    }

    private void movePlayer(int dx, int dy)
    {
        Rectangle playerRect =
                GameManager.getGameManager().getPlayer().getLocation();

        playerRect.translate(dx, dy);

        if (!GameManager.getGameManager().getCurrentMap().isInvalidMovement(playerRect))
        {
            GameManager.getGameManager().getPlayer().updateLocation(dx, dy);
        }
    }
}
