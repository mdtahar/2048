/**
 * 
 * @author bouali73
 *
 */
public class Obstacle extends Cellule {

	public String toString(){
		return "Ob";
	}

	@Override
	public boolean egaleCel(Cellule c) {
		return (c instanceof Obstacle);
	}

	@Override
	public Cellule copier() {
		return new Obstacle();
	}
}
