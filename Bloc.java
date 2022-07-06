package piece;
import java.awt.Point;
public class Bloc
{
	public final Point[][][] model = {
			// I-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O-Piece
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			
			// S-Piece
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-Piece
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-Piece
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			},

			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),new Point(2,0) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),new Point(1,2) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),new Point(-1,1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1),new Point(0,-1) }
			}
	};	

	public int placeBloc(Point[] p)
	{
		int place=0;
		//pour le bloc I
		if((p == model[0][0])||(p==model[0][2]))
		{
			place=4;
		}
		if((p == model[0][1])||(p==model[0][3]))
		{
			place=1;
		}

		//pour le bloc L
		if(p == model[1][0])
		{
			place=3;
		}
		if(p == model[1][1])
		{
			place=2;
		}
		if((p == model[1][2])||(p==model[1][3]))
		{
			place=1;
		}

		//pour le bloc J
		if(p == model[2][2])
		{
			place=3;
		}
		if(p == model[2][1])
		{
			place=2;
		}
		if((p == model[2][0])||(p==model[2][3]))
		{
			place=1;
		}

		//pour le bloc o
		if((p == model[3][0])||(p==model[3][1])||(p==model[3][2])||(p==model[3][3]))
		{
			place=2;
		}

		//pour le bloc s
		if((p == model[4][0])||(p==model[4][2]))
		{
			place=2;
		}
		if((p == model[4][1])||(p==model[4][3]))
		{
			place=1;
		}

		//pour le bloc z
		if((p == model[6][0])||(p==model[6][2]))
		{
			place=2;
		}
		if((p == model[6][1])||(p==model[6][3]))
		{
			place=1;
		}

		//pour le bloc T
		if((p == model[5][3])||(p == model[5][1])||(p==model[5][2]))
		{
			place=1;
		}
		if(p==model[5][0])
		{
			place=3;
		}

		//pour le nouveau model
		if(p == model[7][2])
		{
			place=3;
		}
		if(p == model[7][1])
		{
			place=1;
		}
		if((p == model[7][0])||(p==model[7][3]))
		{
			place=2;
		}
		
		return place;
	}

	public int positionInitial(Point[] p)
	{
		int position=0;
		//pour le bloc I
		if((p == model[0][0])||(p==model[0][2]))
		{
			position=0;
		}
		if((p == model[0][1])||(p==model[0][3]))
		{
			position=-1;
		}
		//pour le bloc L
		if((p == model[1][0])||(p==model[1][2]))
		{
			position=0;
		}
		if(p == model[1][1])
		{
			position=-1;
		}
		if(p == model[1][3])
		{
			position=-1;
		}
		//pour le bloc J
		if(p == model[2][3])
		{
			position=-1;
		}
		if(p == model[2][0])
		{
			position=-2;
		}
		if((p == model[2][2])||(p==model[2][1]))
		{
			position=0;
		}
		//pour le bloc o
		if((p == model[3][0])||(p==model[3][1])||(p==model[3][2])||(p==model[3][3]))
		{
			position=0;
		}
		//pour le bloc s
		if((p == model[4][0])||(p==model[4][2]))
		{
			position=0;
		}
		if((p == model[4][1])||(p==model[4][3]))
		{
			position=-1;
		}
		//pour le bloc T
		if((p == model[5][3])||(p == model[5][1])||(p==model[5][2]))
		{
			position=-1;
		}
		if(p==model[5][0])
		{
			position=0;
		}
		//pour le bloc z
		if((p == model[6][0])||(p==model[6][2]))
		{
			position=-1;
		}
		if((p == model[6][1])||(p==model[6][3]))
		{
			position=0;
		}

		//pour le nouveau model
		if(p == model[7][2])
		{
			position=1;
		}
		if(p == model[7][1])
		{
			position=-1;
		}
		if((p == model[7][0])||(p==model[7][3]))
		{
			position=0;
		}

		return position;
	}
	public int placeX(Point[] p)
	{
		int place=0;
		//pour le bloc I
		if((p == model[0][0])||(p==model[0][2]))
		{
			place=4;
		}
		if((p == model[0][1])||(p==model[0][3]))
		{
			place=1;
		}
		//pour le bloc L
		if((p == model[1][0])||(p==model[1][2]))
		{
			place=2;
		}
		if(p == model[1][1])
		{
			place=2;
		}
		if(p == model[1][3])
		{
			place=2;
		}
		//pour le bloc J
		if(p == model[2][2])
		{
			place=0;
		}
		if(p == model[2][0])
		{
			place=3;
		}
		if((p == model[2][3])||(p==model[2][1]))
		{
			place=2;
		}
		//pour le bloc o
		if((p == model[3][0])||(p==model[3][1])||(p==model[3][2])||(p==model[3][3]))
		{
			place=2;
		}
		//pour le bloc s
		if((p == model[4][0])||(p==model[4][2]))
		{
			place=3;
		}
		if((p == model[4][1])||(p==model[4][3]))
		{
			place=2;
		}
		//pour le bloc T
		if((p == model[5][3])||(p==model[5][1]))
		{
			place=2;
		}
		if((p==model[5][0])||(p == model[5][2]))
		{
			place=3;
		}
		//pour le bloc z
		if((p == model[6][0])||(p==model[6][2]))
		{
			place=3;
		}
		if((p == model[6][1])||(p==model[6][3]))
		{
			place=2;
		}

		//pour le nouveau model
		if(p == model[7][2])
		{
			place=2;
		}
		if(p == model[7][1])
		{
			place=2;
		}
		if((p == model[7][0])||(p==model[7][3]))
		{
			place=3;
		}

		return place;
	}
}