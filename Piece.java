package piece;
import java.awt.*; 
public class Piece
{
	public Point pieceOrigin;
	public int currentPiece;
	public int rotation;
	public Bloc bloc;
	public Color c;
	public Piece(Bloc b,Color color)
	{
		c=color;
		bloc=b;
	}
	public void newPiece(int choice,int x,int y) 
	{
		pieceOrigin = new Point(x, y);
		rotation=0;
		currentPiece = choice;
	}

	public void drawPiece(Graphics g) {		
		g.setColor(c);
		for (Point p : bloc.model[currentPiece][rotation]) {
			g.fillRect((p.x + pieceOrigin.x) * 26+10, 
					   (p.y + pieceOrigin.y) * 26+10, 
					   25, 25);
		}
	}
}