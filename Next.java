package piece;
import java.awt.*;
import javax.swing.*;
import plateau.*;
public class Next extends JPanel
{
	public Bloc bloc;
	public Grid grid;
	public Piece piece;

	public Next(Grid g)
	{
		grid=g;
		bloc=new Bloc();
		piece=new Piece(bloc,new Color(150,150,100));
	}	

	public void drawNext(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect((26*grid.width)+40,220,700,400,10,10);
		g.setColor(piece.c);

		//L model
		for (Point p : bloc.model[1][2]) {
			g.fillRect(p.x * 26+(26*grid.width)+60, 
					   p.y * 26+250, 
					   25, 25);
		}
		//J model
		for (Point p : bloc.model[2][0]) {
			g.fillRect(p.x * 26+(26*grid.width)+60, 
					   p.y * 26+370, 
					   25, 25);
		}
		//O model
		for (Point p : bloc.model[3][0]) {
			g.fillRect(p.x * 26+(26*grid.width)+60, 
					   p.y * 26+490, 
					   25, 25);
		}
		//S model
		for (Point p : bloc.model[4][0]) {
			g.fillRect(p.x * 26+(26*grid.width)+280, 
					   p.y * 26+250, 
					   25, 25);
		}
		//T model
		for (Point p : bloc.model[5][1]) {
			g.fillRect(p.x * 26+(26*grid.width)+280, 
					   p.y * 26+370, 
					   25, 25);
		}
		//Z model
		for (Point p : bloc.model[6][0]) {
			g.fillRect(p.x * 26+(26*grid.width)+280, 
					   p.y * 26+490, 
					   25, 25);
		}
		//I model
		for (Point p : bloc.model[0][3]) {
			g.fillRect(p.x * 26+(26*grid.width)+490, 
					   p.y * 26+250, 
					   25, 25);
		}

		//nouveau model
		for (Point p : bloc.model[7][1]) {
			g.fillRect(p.x * 26+(26*grid.width)+490, 
					   p.y * 26+450, 
					   25, 25);
		}

		///les touches pour L
		g.setColor(Color.BLACK);
		g.drawString("Player 1: R",(26*grid.width)+160,270);
		g.drawString("Player 2: 1",(26*grid.width)+160,300);
		///les touches pour L
		g.drawString("Player 1: F",(26*grid.width)+160,390);
		g.drawString("Player 2: 2",(26*grid.width)+160,420);
		///les touches pour L
		g.drawString("Player 1: C",(26*grid.width)+160,510);
		g.drawString("Player 2: 3",(26*grid.width)+160,540);
		///les touches pour L
		g.drawString("Player 1: T",(26*grid.width)+360,270);
		g.drawString("Player 2: 4",(26*grid.width)+360,300);
		///les touches pour L
		g.drawString("Player 1: G",(26*grid.width)+360,390);
		g.drawString("Player 2: 5",(26*grid.width)+360,420);
		///les touches pour L
		g.drawString("Player 1: V",(26*grid.width)+360,510);
		g.drawString("Player 2: 6",(26*grid.width)+360,540);
		///les touches pour I
		g.drawString("Player 1: X",(26*grid.width)+550,290);
		g.drawString("Player 2: 0",(26*grid.width)+550,320);
		///les touches pour la nouvelle 
		g.drawString("Player 1: W",(26*grid.width)+550,490);
		g.drawString("Player 2: 7",(26*grid.width)+550,520);



	}
}