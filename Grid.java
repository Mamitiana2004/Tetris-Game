package plateau;
import java.awt.*;
public class Grid
{
	public Color[][] carre;
	public int width;
	public int height;
	public Grid(int w,int h)
	{
		width=w;
		height=h;
		carre = new Color[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height-1; j++) {
				if (i == 0 || i == width-1 || j == height-2) 
				{
					carre[i][j] = Color.BLACK;
				} 
				else 
				{
					carre[i][j] = Color.LIGHT_GRAY;
				}
			}
		}
	}	

	public void drawGrid(Graphics g)
	{
		g.fillRect(10, 10, 26*width, 26*height-1);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height-1; j++) 
			{
				g.setColor(carre[i][j]);
				g.fillRect(26*i+10, 26*j+10, 25, 25);
			}
		}
	}
}