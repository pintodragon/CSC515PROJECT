package Fangore.Engine;


import Fangore.Engine.Characters.Player;
import Fangore.Engine.Resources.Map.Map;
import Fangore.Engine.Resources.NPC.NPC;
import Fangore.Engine.Resources.NPC.NPCTypeEnum;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinto
 */
public class GameCanvas extends JPanel implements ActionListener {

    protected Timer timer;
    
    GameCanvas(Dimension appSize)
    {
        super(true);
        this.setSize(appSize);
        this.addFocusListener(null);

        //Set up timer to drive animation events.
        timer = new Timer(100, this);
        timer.setInitialDelay(1000);
        timer.start();

    }

    @Override
    public void paint(Graphics g)
    {
        switch (GameManager.getGameManager().getGameState())
        {
            case PLAYING:
                resetCanvas(g);
                drawMap(g);
                drawNPCs(g);
                break;
            case GAME_OVER_BAD:
                resetCanvas(g);
                drawGameOver(g, "You lose!");
                break;
            case GAME_OVER_GOOD:
                resetCanvas(g);
                drawGameOver(g, "You win!");
                break;
            default:
                break;
        }
    }

    private void resetCanvas(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getSize().width, getSize().height);
    }

    private void drawMap(Graphics g)
    {
        Map currentMap = GameManager.getGameManager().getCurrentMap();
        int tileSize = currentMap.getTileSize();
        
        for (int x = 0; x < getSize().width / tileSize; x++)
        {
            for (int y = 0; y < getSize().height / tileSize; y++)
            {
                currentMap.getTile(y, x).draw(g);
            }
        }
    }

    private void drawNPCs(Graphics g)
    {
        GameManager.getGameManager().getPlayer().draw(g);

        for (NPC currentNPC : GameManager.getGameManager().getCurrentMapNPCs())
        {
            currentNPC.draw(g);
        }
    }

    private void drawGameOver(Graphics g, String message)
    {
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.drawString("GAME OVER!", 100, 100);
        g.drawString(message, 120, getSize().height - 30);
    }

    private void updateMapNPCs()
    {
        for (NPC currentNPC : GameManager.getGameManager().getCurrentMapNPCs())
        {
            int speed = currentNPC.getSpeed();

            if (speed > 0)
            {
                Rectangle npcRect = new Rectangle(currentNPC.getLocation());
                int dx = 0;
                int dy = 0;

                switch((int) (Math.random() * 4))
                {
                    case 0:
                        dx = 1;
                        break;
                    case 1:
                        dx = -1;
                        break;
                    case 2:
                        dy = 1;
                        break;
                    default:
                        dy = -1;
                        break;
                }

                npcRect.translate(dx * speed, dy * speed);

                if (!GameManager.getGameManager().getCurrentMap().isInvalidMovement(npcRect))
                {
                    currentNPC.updateLocation(dx, dy);
                }
            }
            checkPlayerCollision(currentNPC);
        }
    }

    protected void stopTimer()
    {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (GameManager.getGameManager().getGameState() == GameState.PLAYING)
        {
            updateMapNPCs();
            this.repaint();
        }
    }

    private void checkPlayerCollision(NPC currentNPC)
    {
        Player player = GameManager.getGameManager().getPlayer();
        if (currentNPC.getLocation().intersects(player.getLocation())
                && currentNPC.getNPCType() == NPCTypeEnum.FOE)
        {
            GameManager.getGameManager().setGameState(GameState.GAME_OVER_BAD);
        }

        if (currentNPC.getLocation().intersects(player.getLocation())
                && currentNPC.getNPCType() == NPCTypeEnum.FRIEND)
        {
            GameManager.getGameManager().setGameState(GameState.GAME_OVER_GOOD);
        }
    }
}
