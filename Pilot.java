package jeu;
public class Pilot
{
	public Player p;
	public Pilot(Player player)
	{
		p=player;
		new Thread() {
			@Override 
			public void run() {
					while (true) {
						try {
							if(p.pilot==true)
							{
								int x=p.positionPilote;
								int rotation=p.rotatePilote;
								if(p.piece.pieceOrigin.x<x)
								{
									Thread.sleep(100);
									p.move(+1);
								}
								if(p.piece.pieceOrigin.x>x)
								{
									Thread.sleep(100);
									p.move(-1);
								}
								if(p.piece.pieceOrigin.x==x)
								{
									Thread.sleep(100);
									p.dropDown();
								}
								if(p.piece.rotation!=rotation)
								{
									Thread.sleep(100);
									p.rotate(+1);
								}
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
}