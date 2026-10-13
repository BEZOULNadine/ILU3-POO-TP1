package Cartes;

public abstract class Carte {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		return obj != null && getClass() == obj.getClass();
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
