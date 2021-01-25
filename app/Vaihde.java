package app;

public class Vaihde {

	/**
	 * Moottorin käsky muuttuja, alkuarvona 1 (ajaa)
	 */
	public int Komento = 1;
	/**
	 * Värisensorin lukema arvolukema
	 */
	public float Variarvo = 0f; // VÄRIARVO

	/**
	 * Set metodi Komento muuttujalle
	 * 
	 * @param komento luokan moottorin komento
	 */

	public void setKomento(int komento) {
		Komento = komento;
	}

	/**
	 * Get metodi Komento muuttujalle
	 * 
	 * @return Komento moottorin komento
	 */
	public int getKomento() {
		return Komento;
	}

	/**
	 * Set metodi Variarvo muuttujalle
	 * 
	 * @param variarvo luokan värisensorin lukema
	 */
	public void setVariarvo(float variarvo) {

		Variarvo = variarvo;
	}

	/**
	 * Get metodi VariArvo muuttujalle
	 * 
	 * @return luokan värisensorin lukema
	 */
	public float getVariarvo() {
		return Variarvo;
	}

}
