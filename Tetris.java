package jeu;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

import piece.*;
import plateau.*;
import gameOption.*;
import base.*;

public class Tetris extends JPanel {

	public Base base;
	public int score1;
	public int score2;
	public JFrame fenetre;
	public Grid grid;
	public Bloc bloc;
	public Score score;
	public Player player1;
	public Player player2;
	public Next next;
	
	// Creates a border around the grid.carre and initializes the dropping piece1
	public Tetris(JFrame f) 
	{
		base=new Base("postgres","tetris","pass");
		fenetre=f;
		bloc=new Bloc();
		int width=12;
		int heigth=24;
		grid=new Grid(width,heigth);
		player1=new Player(this,1,bloc,grid,new Color(0,64,64));
		player2=new Player(this,2,bloc,grid,new Color(64,128,64));
		score=new Score(grid,player1.score,player2.score);
		next=new Next(grid);
		//base.debutPartie();
	}

	public void lose() {
		System.out.println("Lose");
		fenetre.dispose();
		new Lose(player1.score,player2.score);
	}
	
	@Override 
	public void paintComponent(Graphics g)
	{
		// Paint the grid.carre
		grid.drawGrid(g);

		// Display the score
		score.setScore1(player1.score);
		score.setScore2(player2.score);
		score.display(g);
		// if(player1.update==true)
		// {
		// 	base.updateScore(player1.score,player2.score);
		// 	player1.update=false;
		// }
		// if(player2.update==true)
		// {
		// 	base.updateScore(player1.score,player2.score);
		// 	player2.update=false;
		// }
		//draw Next piece
		next.drawNext(g);
		// Draw the currently falling piece1
		if(player1.choix==true)
		{
			player1.piece.drawPiece(g);
		}
		if(player2.choix==true)
		{
			player2.piece.drawPiece(g);
		}
	}
}
