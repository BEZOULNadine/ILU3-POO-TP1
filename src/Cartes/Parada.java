package Cartes;

public class Parada extends Bataille {

	public Parada(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getParade();}

}
