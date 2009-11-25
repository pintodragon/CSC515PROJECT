package Fangore.Engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinto
 */
public enum GameState {
    INIT (0),
    MENU (1),
    START (2),
    PLAYING (3),
    GAME_OVER (4),
    EXIT (5);
    
    private int currentState;

    GameState() {
        currentState = 0;
    }

    GameState(int state) {
        currentState = state;
    }

    public int getStateValue() {
        return currentState;
    }
}
