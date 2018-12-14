/**
 * 
 * @author bouali73
 *
 */
public class Modele2 extends Modele{
	//pushing
	public Modele2(int taille,int nbrObs,int objectif){
		super(taille,nbrObs,objectif);
	}
	
	public Modele2(int taille){
		super(taille);
	}
	protected void fusion(){
		this.glissement();
		for(int c=0; c<grille.length; c++){
    		for(int j=0; j<grille.length-1; j++){
    			if(grille[j][c] instanceof Valeur){
    				if(grille[j+1][c] instanceof Valeur){
        				if(((Valeur)grille[j][c]).val==((Valeur)grille[j+1][c]).val){
        					((Valeur)grille[j][c]).val=(2*((Valeur)grille[j][c]).val);
        					grille[j+1][c]= new Vide();
        					this.nbrCelLibre++;
        					this.BestScore += ((Valeur)grille[j][c]).val;
        					this.score += ((Valeur)grille[j][c]).val;
            			}
            		}
    				if(grille[j+1][c] instanceof Hole){
    					this.nbrCelLibre++;
    					this.BestScore -= ((Valeur)grille[j][c]).val;
    					this.score -= ((Valeur)grille[j][c]).val;
    					grille[j][c]= new Vide();
    				}
            	}	
            }	
        }
		this.glissement();
	} 
}
