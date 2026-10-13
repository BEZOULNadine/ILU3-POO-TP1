package Cartes;

public class Borne extends Carte {
	private Integer km;

	public Borne(Integer km) {
		this.km = km;
	}

	public Integer getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km + "km";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && km.equals(((Borne) obj).km);
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + km.hashCode();
	}

}
