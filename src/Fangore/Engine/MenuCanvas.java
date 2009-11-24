package Fangore.Engine;

import Fangore.Input.MenuActionListener;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinto
 */
public class MenuCanvas extends JPanel {

    MenuCanvas()
    {
        this(new Dimension(100, 100));
    }

    MenuCanvas(Dimension appSize) {
        super(true);
        this.setSize(appSize);
        initialize();
    }

    private void initialize()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(createTitleImage());
        this.add(createStartButton());
        this.add(createCreditsButton());
    }

    private JLabel createTitleImage()
    {
        return new JLabel("Soon to be an image");
    }

    private JButton createStartButton()
    {
        JButton startButton = new JButton("Start");
        startButton.setActionCommand(MenuActionListener.START_GAME);
        startButton.addActionListener(new MenuActionListener());

        return startButton;
    }

     private JButton createCreditsButton()
    {
        JButton creditsButton = new JButton("Credits");
        creditsButton.setActionCommand(MenuActionListener.CREDITS);
        creditsButton.addActionListener(new MenuActionListener());

        return creditsButton;
    }
}
