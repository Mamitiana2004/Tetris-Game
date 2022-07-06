package gameOption;
import java.awt.*; 
import plateau.*;
public class Score
{
	int score1;
	int score2;
	public Grid grid;

	public Score(Grid g,int s1,int s2)
	{
		grid=g;
		score1=s1;
		score2=s2;
	}	

	public void display(Graphics g)
	{
		// Display the score
		Font myFont=new Font("arial",1,20);
        g.setFont(myFont);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect((26*grid.width)+40,10,350,200,19,19);
		g.setColor(new Color(0,68,68));
		g.drawString("PLAYER 1:" + score1, (26*grid.width)+70, 35);
		// Display the score
		g.setColor(new Color(64,128,64));
		g.drawString("PLAYER 2:" + score2, (26*grid.width)+70, 135);
	}

	public void setScore1(int i)
	{
		score1=i;
	}
	public void setScore2(int i)
	{
		score2=i;
	}
}