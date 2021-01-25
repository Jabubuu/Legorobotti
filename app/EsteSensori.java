package app;

import kirjasto.UltraBra;
import lejos.hardware.port.SensorPort;

public class EsteSensori extends Thread {
	/**
	 * Ultraäänisensorin pohjustaminen
	 */
	private UltraBra us;
	/**
	 * Vaihdeluokan pohjustaminen
	 */
	private Vaihde Data;
	/**
	 * Väistöetäisyyden minimiarvo
	 */
	private final float Min = 0.15f;

	/**
	 * Alustaa ja luo ultraäänisensorin, saa rakentajan aikaisemmasta luokasta
	 * 
	 * @param Data Vaihteen data
	 */
	public EsteSensori(Vaihde Data) {
		this.Data = Data;
		us = new UltraBra(SensorPort.S1);
	}

	/**
	 * Ajometodi luokan ajamista varten
	 */
	public void run() {
		/**
		 * Ajetaan metodia loputtomalla loopilla
		 */
		while (true) {
			/**
			 * Tutkii, onko etäisyys alle asetetun Min-arvon
			 */
			if (us.getRange() < Min) {
				/**
				 * Asettaa Vaihdeluokkan muuttujan Komento arvoksi 6 (väistöliike)
				 */
				Data.setKomento(6);
			}
		}
	}
}