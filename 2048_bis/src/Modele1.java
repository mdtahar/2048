/**
 * 
 * @author bouali73
 *
 */
public class Modele1 extends Modele {
	// gravity
	public Modele1(int taille,int nbrObs,int objectif){
		super(taille,nbrObs,objectif);
	}
	public Modele1(int taille){
		super(taille);
	}
	
	protected void fusion(){
		this.glissement();
		for(int c=0; c<grille.length; c++){
    		for(int j=grille.length-2; j>=0; j--){
    			if(grille[j][c] instanceof Valeur){
    				if(grille[j+1][c] instanceof Valeur){
        				if(((Valeur)grille[j][c]).val==((Valeur)grille[j+1][c]).val){
        					((Valeur)grille[j+1][c]).val=(2*((Valeur)grille[j+1][c]).val);
        					grille[j][c]= new Vide();
        					this.nbrCelLibre++;
        					this.BestScore += ((Valeur)grille[j+1][c]).val;
        					this.score += ((Valeur)grille[j+1][c]).val;
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
