/**
 * 
 * @author bouali73
 * 
 */
public abstract class Modele {
	protected Cellule [][] grille; 
	protected int score ;// le score de la partie
	protected int BestScore ;// le meilleur score dans le jeu
	protected int nbrObstacle ;
	protected  int objectif ;
	protected int nbrCelLibre ;
	
	/**
	 * 
	 * @param taille la taille de la grille 
	 * @param nbrObs nombre d'obstacle dans ce modele
	 * @param objectif l'objectif du jeu 
	 */
	public Modele(int taille,int nbrObs,int objectif){
		this.grille = new Cellule[taille][taille];
		this.BestScore = DiskTools.chargerBestScore();
		this.score = 0;
		this.objectif = objectif;
		this.nbrObstacle = nbrObs;
		this.nbrCelLibre = taille * taille;
		this.init();
		
	}
	/**
	 * constructeur pour charger le Modele
	 * @param taille de la grille
	 */
	public Modele(int taille){
		this.grille = DiskTools.chargerUneGrille(taille);
		this.nbrObstacle = DiskTools.chargerNbrObstacles();
		score = DiskTools.chargerScore();
		objectif = DiskTools.chargerObjectif();
		this.BestScore = DiskTools.chargerBestScore();
		this.nbrCelLibre = DiskTools.chargerNbrCelLibre();
		
	}
	
	/**
	 * initialisation du Modele 
	 */
	private void init(){
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				grille[i][j] = new Vide();
			}
		}
		int a = 2;
		while(a != 0){
			this.addVal();
			a--;
		}
		if(this.nbrObstacle != 0){
			int b = this.nbrObstacle;
			while(b!=0){
				this.addObs();
				b--;
			}
			
		}
		this.addHole();
		DiskTools.saveM(this);
	}
	/** 
	 * @return un objet valeur 2 ou 4
	 */
	private Valeur generateur(){
		int k = (int)(Math.random()*2);
		Valeur c = new Valeur(2) ;
		if(k<1){
			c = new Valeur(2);
		}
		if(k>=1){
			c = new Valeur(4);
		}
		return c;
	}
	/**
	 * @return renvoie un tableau de taille 2 (les indices d'une case vide dans la grille)
	 */
	private int[] cellVide(){
		int [] res = new int[2];
		int i,j;
		i = (int)(Math.random()*grille.length);
		j = (int)(Math.random()*grille.length);
		while(!(this.grille[i][j]instanceof Vide)){
			i = (int)(Math.random()*grille.length);
			j = (int)(Math.random()*grille.length);
		}
		res[0]=i;
		res[1]=j;
		return res;
	}
	/**
	 *  ajouter un  objet de valeur 2 ou 4 à la grille 
	 */
	private void addVal(){
		int [] t = this.cellVide();
		Cellule c = this.generateur();
		this.grille[t[0]][t[1]] = c;
		this.nbrCelLibre--;
	}
	/** 
	 * ajouter un obstacle à la grille 
	 */
	private void addObs(){
		int [] t = this.cellVide();
		Cellule c = new Obstacle();
		this.grille[t[0]][t[1]] = c;
		this.nbrCelLibre--;
	}
	/** 
	 * ajouter un trou à la grille 
	 */
	private void addHole(){
		int [] t = this.cellVide();
		Cellule c = new Hole();
		this.grille[t[0]][t[1]] = c;
		this.nbrCelLibre--;
	}
	/**
	 * @return vrai si il est possible de faire un mouvement dans la grille ,faux sinon
	 */
	private boolean movePossible(){
		if(this.nbrCelLibre !=0){
			return true;
		}
		else{
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[0].length; j++) {
					if(this.grille[i][j] instanceof Valeur){
						if(j<(grille[0].length-1)){
							if(((Valeur)grille[i][j]).val ==((Valeur)grille[i][j+1]).val ){
								return true;
							}
							
						}
						if(i<(grille.length-1)){
							if(((Valeur)grille[i][j]).val ==((Valeur)grille[i+1][j]).val ){
								return true;
							}
							
						}
					}
						
				}
			}
			return false;
			}
		
	}
	/**
	 * @return vrai si on ne peut plus faire du mouvement,faux sinon
	 */
	public boolean perdu(){
		return (!movePossible());
	}
	/**
	 * @return la valeur max dans la grille
	 */
	private int valMax(){
		int res = 0;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if(this.grille[i][j] instanceof Valeur){
					if(((Valeur)grille[i][j]).val > res ){
						res =((Valeur)grille[i][j]).val ;
					}
				}
			}
		}
		return res;
	}
	/**
	 * @return vrai c'est l'objectif est atteint,faux sinon
	 */
	public boolean gagner(){
		return this.valMax() == this.objectif;
	}
	/**
	 * la retation de la grille vers la droite 
	 */
	private void retation(){
		Cellule [][] t1 = new Cellule[grille.length][grille[0].length];
		for (int j = 0; j<grille.length; j++) {
  			for (int i = grille[0].length-1; i >= 0; i--){
  				t1[j][(grille.length-1)-i]=grille[i][j];
  			}		
		}
		grille=t1;
	}
	/**
	 * le glissement de toute la grille vers le bas 
	 */
	protected  void glissement(){
		for (int j = 0; j<grille.length; j++) {
  			for (int i = grille[0].length-1; i > 0; i--){
  				
  					int c = i-1;
					while( (c > 0) && (grille[c][j].getClass() == Vide.class) ){
						c--;
					}

					if(grille[i][j] instanceof Vide ){
						if(grille[c][j].getClass() != Obstacle.class && grille[c][j].getClass() != Hole.class ){
							grille[i][j] = grille[c][j];
							grille[c][j] = new Vide();
						}	
					}
				}		
			
		}
	}
	/**
	 * la fusion des cellule a la même valeur
	 */
	protected abstract void fusion();
	/**
	 * @return  copier la grille
	 */
	private Cellule[][] copierLaGrille(){
		Cellule[][] res = new Cellule[grille.length][grille.length];
		for (int i = 0; i <grille.length ; i++) {
			for (int j = 0; j<grille.length; j++) {
				res[i][j] = grille[i][j].copier();
			}
		}
		return res;
	}
	/**
	 * test si la grille dans le modele est égale a celle en argument
	 * @param g une grille 
	 * @return vrai si égale , faux sinon
	 */
	private boolean grilleEgale(Cellule[][] g){
		for (int i = 0;i<grille.length;i++) {
			for (int j = 0; j<grille.length; j++) {
				if(!(grille[i][j].egaleCel(g[i][j]))){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * permis de choisir notre direction du mouvement dans la grille et faire les operations
	 * @param direction du mouvement
	 */
	public void operation(int direction){
		Cellule[][] c = new Cellule[grille.length][grille.length];
		c=this.copierLaGrille();
		if(direction == 4){//bas
			this.fusion();
		}
		if(direction == 3){//haut
			this.retation();
			this.retation();
			this.fusion();
			this.retation();
			this.retation();
		}
		if(direction==1){// gauche
			this.retation();
			this.retation();
			this.retation();
			this.fusion();
			this.retation();
		}
		if(direction==2){// droite
			this.retation();
			this.fusion();
			this.retation();
			this.retation();
			this.retation();
		}
		if(!this.grilleEgale(c)){
			
				this.addVal();
			
		}
		DiskTools.saveM(this);
	}
	/**
	 * l'affichage
	 */
	public void affiche(){
		System.out.println();
		System.out.print("/------");
		for(int i = 1 ;i<grille.length;i++){
			System.out.print("+------");
		}
		System.out.print("\\");
		System.out.println();
		for (int i = 0; i < grille.length; i++) {
			System.out.print("|");
			for (int j = 0; j < grille[0].length; j++) {
				if(this.grille[i][j].getClass()!=Vide.class){
					int a = 6 -this.grille[i][j].toString().length();
					
					for(int jj =0 ;jj<a;jj++){
						System.out.print(" ");
					}
					System.out.print(this.grille[i][j].toString());
					System.out.print("|");
				}
				else{
					System.out.print("      |");
				}
			}
			System.out.println();
			if(i<grille.length-1){
				System.out.print("|------");
				for(int ii = 1 ;ii<grille.length;ii++){
					System.out.print("+------");
				}
				System.out.print("|");
				System.out.println();
			}
			else{
				System.out.print("\\------");
				for(int ii = 1 ;ii<grille.length;ii++){
					System.out.print("+------");
				}
				System.out.print("/");
				System.out.println();
			}
		}
	}
}
