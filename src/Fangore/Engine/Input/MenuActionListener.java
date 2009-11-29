/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Input;

import Fangore.Engine.GameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author justin.chrysler
 */
public class MenuActionListener implements ActionListener {

    public static final String START_GAME = "Start Game";
    public static final String CREDITS = "Credits";

    public void actionPerformed(ActionEvent actionEvent)
    {
        if (START_GAME.equals(actionEvent.getActionCommand()))
        {
            GameManager.getGameManager().gameInit();
        }
        else if (CREDITS.equals(actionEvent.getActionCommand()))
        {
            String creditMessage = "<html>" +
                "<h1>Credits</h1>" +
                "<p>Creator: Justin Chrysler</p> </html>";
            JLabel creditLabel = new JLabel(creditMessage);

            JOptionPane.showMessageDialog(
                GameManager.getGameManager().getCardPanel(),
                creditLabel,
                CREDITS,
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
