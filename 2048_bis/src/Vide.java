/**
 * 
 * @author bouali73
 *
 */
public class Vide extends Cellule{

	public String toString(){
		return " ";
	}

	@Override
	public boolean egaleCel(Cellule c) {
		return (c instanceof Vide);
	}

	@Override
	public Cellule copier() {
		return new Vide();
	}
}
