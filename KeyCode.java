package gameOption;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jeu.Tetris;
public class KeyCode
{
	public void touche1(KeyEvent e,Tetris game)
    {   
				switch (e.getKeyCode()) {
				case KeyEvent.VK_Z:
					game.player1.rotate(-1);
					game.player1.pilot=false;
					break;
				case KeyEvent.VK_Q:
					game.player1.move(-1);
					game.player1.pilot=false;
					break;
				case KeyEvent.VK_D:
					game.player1.move(+1);
					game.player1.pilot=false;
					break;
				case KeyEvent.VK_S:
					game.player1.dropDown();
					game.player1.pilot=false;
					break;
		}
    }public void touche2(KeyEvent e,Tetris game)
    {   
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_UP:
					game.player2.rotate(-1);
					game.player2.pilot=false;
					break;
				case KeyEvent.VK_LEFT:
					game.player2.move(-1);
					game.player2.pilot=false;
					break;
				case KeyEvent.VK_RIGHT:
					game.player2.move(+1);
					game.player2.pilot=false;
					break;
				case KeyEvent.VK_DOWN:
					game.player2.dropDown();
					game.player2.pilot=false;
					break;
		}
    }
    public void choix2(KeyEvent e,Tetris game)
    {   
				switch (e.getKeyCode()) {
					case KeyEvent.VK_NUMPAD1:
						game.player2.piece.newPiece(1,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD2:
						game.player2.piece.newPiece(2,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD3:
						game.player2.piece.newPiece(3,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD4:
						game.player2.piece.newPiece(4,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD5:
						game.player2.piece.newPiece(5,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD6:
						game.player2.piece.newPiece(6,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD0:
						game.player2.piece.newPiece(0,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_NUMPAD7:
						game.player2.piece.newPiece(7,5,1);
						
						game.player2.choix=true;
						game.repaint();
						break;
		}
    }public void choix1(KeyEvent e,Tetris game)
    {   
				switch (e.getKeyCode()) {
					case KeyEvent.VK_R:
						game.player1.piece.newPiece(1,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_F:
						game.player1.piece.newPiece(2,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_C:
						game.player1.piece.newPiece(3,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_T:
						game.player1.piece.newPiece(4,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_G:
						game.player1.piece.newPiece(5,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_V:
						game.player1.piece.newPiece(6,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_X:
						game.player1.piece.newPiece(0,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
					case KeyEvent.VK_W:
						game.player1.piece.newPiece(7,2,1);

						game.player1.choix=true;
						game.repaint();
						break;
		}
    }
    public void autoPilot(KeyEvent e,Tetris game)
    {
    	switch (e.getKeyCode()) 
    	{
    		case KeyEvent.VK_A:
				game.player1.verification();
				break;	
    	}
    }
    public void autoPilot2(KeyEvent e,Tetris game)
    {
    	switch (e.getKeyCode()) 
    	{
    		case KeyEvent.VK_ENTER:
				game.player2.verification();
				break;	
    	}
    }
}