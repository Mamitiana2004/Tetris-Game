package tetris;
import jeu.Tetris;
import gameOption.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Fenetre
{
	public Fenetre() 
	{
		JFrame f = new JFrame("Tetris");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1200,700);
		f.setVisible(true);
		KeyCode commende=new KeyCode();
		Tetris game = new Tetris(f);
		f.add(game);
		
		// Keyboard controls
		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if(game.player1.choix==true)
				{
					commende.touche1(e,game);
				}
				if(game.player1.choix==false)
				{
					commende.choix1(e,game);
				}
				if(game.player2.choix==true)
				{
					commende.touche2(e,game);
				}
				if(game.player2.choix==false)
				{
					commende.choix2(e,game);
				}
				if(game.player2.pilot==false)
				{
					commende.autoPilot2(e,game);
				}
				if(game.player1.pilot==false)
				{
					commende.autoPilot(e,game);
				}
			}
			
			public void keyReleased(KeyEvent e){
			}
		});
		
	}	
}