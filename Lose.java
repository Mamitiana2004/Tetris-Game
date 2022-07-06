package jeu;
import javax.swing.*;
import java.awt.*;
public class Lose extends JFrame
{
	public Lose(int score1,int score2)
	{
		super("Game Over");
		setSize(500,180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel(new GridLayout(2,1));
		String winner=" ";
		if(score1>score2)
		{
			winner="WINNER PLAYER 1";
		}
		if(score2>score1)
		{
			winner="WINNER PLAYER 2";
		}
		if(score2==score1)
		{
			winner="EGALITE";
		}
		JLabel gagnant=new JLabel(winner);
		JPanel scorePanel=new JPanel(new GridLayout(0,2));
		JLabel score1Aff=new JLabel("Score Player 1 :"+score1);
		JLabel score2Aff=new JLabel("Score Player 2 :"+score2);
		Font myFont=new Font("arial",1,20);
        gagnant.setFont(myFont);
        score1Aff.setFont(myFont);
        score2Aff.setFont(myFont);
		scorePanel.add(score1Aff);
		scorePanel.add(score2Aff);
		panel.add(gagnant);
		panel.add(scorePanel);
		add(panel);
	}	
}