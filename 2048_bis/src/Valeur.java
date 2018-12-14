/**
 * 
 * @author bouali73
 *
 */
public class Valeur extends Cellule {
	protected int val;
	
	
	public Valeur(int val){
		this.val = val;
	}
	public String toString(){
		return ""+this.val ;
	}
	public boolean egaleCel(Cellule c){
			if(c instanceof Valeur){
				if(this.val != ((Valeur)c).val){
					return false;
				}
				else{
					return true;
				}
			}
			else{
				return false;
			}
	}
	@Override
	public Cellule copier() {
		return new Valeur(val);
	}
}
