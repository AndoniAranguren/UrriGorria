package negozioLogika;

public class Mapa {
	//Atributuak
	public static int zut=10;
	public static int erren=10;
	private Tile[][] jokalariMapa;
	String jabea;
	
	//Eraikitzailea
	public Mapa(String pIzena){
		jabea= pIzena;
		jokalariMapa= new Tile[zut][erren];
		this.urezBete(jokalariMapa);
	}
		
	//Metodoak
	private void urezBete(Tile[][] pMap){
		for(int Y=0;Y<zut; Y++){
			for(int X=0;X<erren; X++){
				pMap[Y][X]=TileFactory.getTileFactory().createUraTile(jabea, X, Y);
			}
		}
	}

	public boolean kokatuDaiteke(int pX, int pY, char pNorabidea, int pLuzeera){// throws IndepXOutOfBoundsEpXception{
		boolean libre = true, amaituta=false;
		Tile t;
		while(libre&&!amaituta){ //Lehenengoaren eta azkenengoaren ondoko posizioak begiratu baita, urez inguratua egon behar baitu
			for (int i=0;i<pLuzeera;i++){
				if(pX<erren&&pX>=0&&pY<zut&&pY>=0){
					t=jokalariMapa[pX][pY];
					if(pNorabidea=='N'){pY--;}
					if(pNorabidea=='E'){pX++;}
					if(pNorabidea=='W'){pX--;}
					if(pNorabidea=='S'){pY++;}
					
					libre=t.kokatuDaiteke();
//					System.out.println("X:"+pX+" Y:"+pY+" Librea:"+libre);
				}
				else libre=false;
			}
			amaituta=true;
		}
		return libre;
	}

	public Itsasontzia itsasontziaJarri(String pJabea, Itsasontzia pItsasontzia, int pX, int pY, char pNorabidea, boolean pZer) {
		// TODO Auto-generated method stub
			ItsasontziTile tile;
			for (int i=0;i<=pItsasontzia.luzeera;i++){
				if(pZer){
					tile= new ItsasontziTile(pJabea, pX, pY, pItsasontzia);
					jokalariMapa[pX][pY]= tile;
				}
				else{
					tile=((ItsasontziTile)jokalariMapa[pX][pY]);				
					jokalariMapa[pX][pY]=new UraTile(pJabea, pX, pY);
				}
				if(pNorabidea=='N'){pY--;}
				if(pNorabidea=='E'){pX++;}
				if(pNorabidea=='W'){pX--;}
				if(pNorabidea=='S'){pY++;}
				//Izan ahal da, tile bateri erasotzean itsasontzi nagusia ez jasotzea
				//Honela tilak itsasontzi atributu ezberdina duelako. Itsason1[Tile(Itsason2)]
				pItsasontzia.tileGehitu(tile,pZer);							
				jokalariMapa[pX-1][pY].kokatzekoGaitasunaEman(!pZer);	//Itsasontzia jartzen bada(pZer=t) ->Gaitasuna kentzen zaio	(pZer=f)
				jokalariMapa[pX+1][pY].kokatzekoGaitasunaEman(!pZer);
				jokalariMapa[pX][pY-1].kokatzekoGaitasunaEman(!pZer);
				jokalariMapa[pX][pY+1].kokatzekoGaitasunaEman(!pZer);
			}
		return pItsasontzia;
	}

	public boolean erasoSinpleaJaso(String pNork,int pX, int pY, int pIndarra, boolean pZer) {
		// TODO Auto-generated method stub
		if(pX<=zut && pY<=erren){
			jokalariMapa[pX][pY].jo(pNork, pIndarra, pZer);
			return true;
		}else return false;
	}

	public String[][] mapaInterpretatu(String pNork){
		String[][] mapa= new String[zut][erren];
		
		for(int indX=0;indX<zut;indX++){
			for(int indY=0;indY<erren;indY++){
				mapa[indX][indY]=jokalariMapa[indX][indY].erakutsi(pNork);
			}
		}
		return mapa;
	}
	public void ezkutuaJarri(String pNork, int pX, int pY, boolean pZer){
		if (!jokalariMapa[pX][pY].jabeaDa(pNork));
		else if(jokalariMapa[pX][pY] instanceof ItsasontziTile);
		else ((ItsasontziTile)jokalariMapa[pX][pY]).ezkutuaJarri(pZer);
	}
	
	public void radarraErabili(String pNork,int pX, int pY, boolean pZer){//al encontrar hazle un jokalariMapa[x][y].jo(pNork,0,pZer)
//		error
	}
}