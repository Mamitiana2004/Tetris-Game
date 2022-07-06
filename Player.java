package jeu;
import java.awt.*;
import javax.swing.*;
import piece.*;
import plateau.*;
public class Player
{
	public Tetris tetris;
	public Thread falling;
	public Grid grid;
	public Bloc bloc;
	public int score;
	public Piece piece;		
	public Color colorPiece;
	public int numPlayer;
	public boolean update=false;
	public boolean choix=false;
	public boolean lose=false;
	//pilote auto
	public boolean pilot=false;
	public int rotatePilote=0;
	public int positionPilote=0;

	//
	boolean pSucces=false;

	public Player(Tetris t,int n,Bloc b,Grid g,Color c)
	{
		score=0;
		tetris=t;	
		bloc=b;
		grid=g;
		colorPiece=c;
		numPlayer=n;
		piece=new Piece(bloc,colorPiece);
		new Pilot(this);
		new Thread() {
			@Override 
			public void run() {
					while (true) {
						try {
							if(choix==true){
								Thread.sleep(800);
								dropDown();
							}
							else
							{
								Thread.sleep(0);
							}
						} catch ( InterruptedException e ) {}
					}
				
			}
		}.start();
	}

	public boolean colision(int x, int y, int rotation) {
		if(choix==true)
		{
			for (Point p : bloc.model[piece.currentPiece][rotation]) {
					if (grid.carre[p.x + x][p.y + y] != Color.LIGHT_GRAY) {
						return true;
					}
				}
		}
		return false;
	}

	public void rotate(int i) {
		int newRotation = (piece.rotation + i) % 4;
		if (newRotation < 0) {
			newRotation = 3;
		}
		if (!colision(piece.pieceOrigin.x, piece.pieceOrigin.y, newRotation)) {
			piece.rotation = newRotation;
		}
		tetris.repaint();
	}

	public void move(int i) {
		if (!colision(piece.pieceOrigin.x + i, piece.pieceOrigin.y, piece.rotation)) {
			piece.pieceOrigin.x += i;	
		}
		tetris.repaint();
	}

	public void dropDown() {
		if (!colision(piece.pieceOrigin.x, piece.pieceOrigin.y + 1, piece.rotation)) {
			piece.pieceOrigin.y += 1;
		} 
		
		else {
			while(colision(piece.pieceOrigin.x, piece.pieceOrigin.y, piece.rotation))
			{
				piece.pieceOrigin.y-=1;
			}
			putToGrid();
		}	
		tetris.repaint();
	}

	public void putToGrid() {
		for (Point p : bloc.model[piece.currentPiece][piece.rotation]) {
			grid.carre[piece.pieceOrigin.x + p.x][piece.pieceOrigin.y + p.y] =colorPiece;
		}
		clearRows();
		isLose();
		if(pilot==true)
		{
			pilot=false;
		}
	}

	public void isLose() {
				choix=false;
				for (int i = 1; i <grid.width-2 ; i++) 
				{
					if (grid.carre[i][0] != Color.LIGHT_GRAY) 
					{
						if(lose==false)
						{			
							tetris.lose();
							lose=true;
							break;
						}
					}
				}
	}

	public int placeLibreSuccessif(int y)
	{
			int place=0;
			for(int i=1;i < grid.width-1;i+=1) {
				if (grid.carre[i][y] == Color.LIGHT_GRAY) {
					place++;
					if(grid.carre[i+1][y] == Color.LIGHT_GRAY)
					{
						place++;
						i++;
						pSucces=true;
					}
					else{
						break;
					}

				}
			}
			return place;
			
	}

	public int placeLibre(int y)
	{
			int place=0;
			for(int i=1;i < grid.width-1;i+=1) {
				if (grid.carre[i][y] == Color.LIGHT_GRAY) {
					place++;
				}
			}
			return place;
			
	}

	public int positionLibre(int y)
	{
			int place=0;
			for (int i = 1; i < grid.width-1; i++) {
				if (grid.carre[i][y] == Color.LIGHT_GRAY) {
					place=i;
					break;
				}
			}
			return place;
			
	}

	public int placePiece(int rotation)
	{
		int place=bloc.placeBloc(bloc.model[piece.currentPiece][rotation]);
		return place;
	}

	public void setRotation(int rotation)
	{
		rotatePilote=rotation;
	}

	public void verification()
	{
		// System.out.println("#######################################");
		// for(int i=0;i<4;i++)
		// {
		// 	System.out.println("//////////////////////////////////////////////////");
		// 	System.out.println("Rotation :"+i);
		// 	int restePlace=placeLibreSuccessif(dernierColone());
		// 	int reste=placeLibre(dernierColone());
		// 	System.out.println("Place Successif"+restePlace);
		// 	System.out.println("Place :"+reste);
		// 	System.out.println("Place libre :"+restePlace);
		// 	int place=placePiece(i);
		// 	System.out.println("Place occupe par la piece :"+place);
		// 	int total=restePlace-place;
		// 	System.out.println("Total ="+total);
		// 	if(total==0)
		// 	{
		// 		System.out.println("On peut mettre cette piece a la position :"+positionLibre(dernierColone())+" et a la ligne :"+dernierColone());
		// 		System.out.println("On peut mettre cette piece a la rotation :"+i);
		// 		setRotation(i);
		// 		break;
		// 	}
		// }
		pilotConfirmer();
	}

	public void pilotConfirmer()
	{
		System.out.println("----------------NOUVELLE PIECE------------------"+piece.currentPiece);
		for (int i=0;i<4;i++) 
		{
			System.out.println("---ROTATION "+i+"---");
			int placeP=placePiece(i);
			int colone=dernierColone(placeP);
			System.out.println("Ligne :"+colone);
			int nbrPlaceS=placeLibreSuccessif(colone);
			System.out.println("Place libre succesif :"+nbrPlaceS);
			int place=placeLibre(colone);
			System.out.println("Place vide :"+place);
			if(nbrPlaceS==place) 
			{
				System.out.println("Place occupera la piece :"+placeP);
				int reste=nbrPlaceS-placeP;
				System.out.println("Place qui reste :"+reste);
				int origine=bloc.positionInitial(bloc.model[piece.currentPiece][i]);
				int pRemplir=positionLibre(dernierColone(placeP))+origine;
				System.out.println("pRemplir :"+pRemplir);
				System.out.println("Position 0:"+positionLibre(dernierColone(placeP)));
				int placeUp=bloc.placeX(bloc.model[piece.currentPiece][i]);
				System.out.println("place a liberer :"+placeUp);
				
				if(reste==0)
				{
							System.out.println("Pilote Activee");
							System.out.println("la position piece:"+origine);
							System.out.println("la position final:"+pRemplir);
							setRotation(i);
							positionPilote=pRemplir;
							pilot=true;
							break;
						
				}
			}
		}
	}

	public int dernierColone(int p)
	{
		int position=0;
		for (int j = 1; j<22; j++) {
			for (int i = 1; i < grid.width-1; i++) {
				if (grid.carre[i][j] != Color.LIGHT_GRAY) 
				{
					int place=placeLibre(j);
					if((placeLibreSuccessif(j)<=p)&&(place==placeLibreSuccessif(j)))
					{
						position=j;
						j=23;
						break;
					}
				}
			}
		}
		return position;
			
	}

	// public boolean peutEntrer(int ligne,int x,int place)
	// {
	// 	boolean gap=true;
		
	// 		for (int j = ligne-1; j>0; j--) {
	// 			for(int i=0;i<place;i++)
	// 			{
	// 				int pos=x+i;
	// 				System.out.println("La colone :"+pos);
	// 				System.out.println("ligne "+j);
	// 				if (grid.carre[pos][j] != Color.LIGHT_GRAY) 
	// 				{
	// 					gap=false;
	// 					break;
	// 				}
	// 			}
	// 	}
	// 	return gap;
	// }

	// public boolean peutPoser(int ligne,int x,int place,Color piece)
	// {
	// 	boolean gap=true;
	// 	if(ligne<21)
	// 	{
	// 		for(int i=0;i<place;i++)
	// 			{
	// 				int pos=x+i;
	// 				if (grid.carre[pos][ligne+1] != piece) 
	// 				{
	// 					gap=false;
	// 					break;
	// 				}
	// 			}
	// 	}
	// 	return gap;
	// }

	// public boolean peutPoser(int y)
	// {
	// 	boolean possible=true;
	// 	int position=positionLibre(y);
	// 	int depasse=(position-1)+bloc.placeBloc(bloc.model[piece.currentPiece][rotation]);
	// 	if(depasse<=10)
	// 	{
	// 		for(int i=position;i<bloc.placeX[piece.currentPiece][getRotation(placeLibreColone(y))][0];i++)
	// 		{
	// 			if (grid.carre[i][y] != Color.LIGHT_GRAY) {
	// 				possible=false;
	// 				break;
	// 			}
	// 		}
	// 	}
	// 	return possible;

	// }

	public void clearRows() {
		boolean gap;
		int numClears = 0;
		int s=score;
		boolean g=false;
		
		for (int j = 21; j > 0; j--) {
			gap = false;
			for (int i = 1; i < grid.width-1; i++) {
				if (grid.carre[i][j] == Color.LIGHT_GRAY) {
					gap = true;
					break;
				}
			}
			if (!gap) {
				deleteRow(j);
				s=0;
				g=true;
				j += 1;
				numClears += 1;
				update=true;
			}
		}
		switch (numClears) 
		{
			case 1:
				s += 100;
				break;
			case 2:
				s += (200*1.2);
				break;
			case 3:
				s += (300*1.3);
				break;
			case 4:
				s += (400*1.4);
				break;
		}
		if(g==true)
		{
			if(pilot==true) 
			{
				s=s/2;
				score+=s;
			}	
			else
			{
				score+=s;
			}
		}
		else if(g==false)
		{
			score+=0;
		}
	}


	public void deleteRow(int row) {
		for (int j = row-1; j > 0; j--) {
			for (int i = 1; i < grid.width-1; i++) {
				grid.carre[i][j+1] = grid.carre[i][j];
			}
		}
	}
}