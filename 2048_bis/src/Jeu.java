/**
 * 
 * @author bouali73
 *
 */
public class Jeu {
	protected Modele niveau ;
	protected int numN ;
	protected int type;
	/**
	 * le constructeur du jeu
	 * @param type du jeu 
	 */
	public Jeu(int type){
		this.type = type;
		if(this.type == 1){
			niveau = new Modele1(4,1,1024);
		}
		if(this.type == 2){
			niveau = new Modele2(4,0,1024);
		}
		numN = 1;
		DiskTools.saveJ(this);
	}
	/**
	 * constructeur pour charger un jeu  
	 * @param m le niveau 
	 * @param numN numero du niveau 
	 * @param type type du jeu
	 */
	public Jeu(Modele m,int numN,int type){
		this.niveau = m;
		this.numN = numN;
		this.type = type;
		DiskTools.saveJ(this);
	}
	/**
	 * permis de passer au niveau  suivant
	 * @param num le numero du niveau 
	 * @param typeJ le type du jeu 
	 */
	public void nextLevel(int num,int typeJ ){
		numN = num+1;
		niveau = null;
		if(type==1){
			switch (numN) {
				case 2:
					niveau = new Modele1(4,0,2048);
					break;
				case 3:
					niveau = new Modele1(4,2,2048);
					break;
				case 4:
					niveau = new Modele1(5,0,2048);
					break;
				case 5:
					niveau = new Modele1(5,3,2048);
					break;
				default: break;
			}
			DiskTools.saveJ(this);
		}
		if(type==2){
			switch (numN) {
				case 2:
					niveau = new Modele2(4,0,2048);
					break;
				case 3:
					niveau = new Modele2(4,2,2048);
					break;
				case 4:
					niveau = new Modele2(5,0,2048);
					break;
				case 5:
					niveau = new Modele2(5,3,2048);
					break;
				default: break;
			}
			DiskTools.saveJ(this);
		}
	}
	/**
	 * @return vrai c'est le jeu est fini ,faux sinon
	 */
	public boolean finJeu(){
		return numN > 5 ; 
	}
}
