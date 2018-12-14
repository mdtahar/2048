
public class Hole extends Cellule{
	
	
	
	public String toString(){
		return "T";
	}

	@Override
	public boolean egaleCel(Cellule c) {
		return (c instanceof Hole);
	}

	@Override
	public Cellule copier() {
		return new Hole();
	}

}
