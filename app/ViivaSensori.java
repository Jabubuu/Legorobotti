package app;

import kirjasto.VariSensori;
import lejos.hardware.port.SensorPort;

public class ViivaSensori extends Thread {
	/**
	 * Vaihdeluokan pohjustaminen
	 */
	private Vaihde Data;
	/**
	 * Värisensorin pohjustaminen
	 */
	public VariSensori vs;

	/**
	 * Raja-arvo tiukalle käännökselle oikeaan
	 */
	float TokaMax = 0.15f;
	/**
	 * Raja-arvo oikealle kääntymiseen
	 */
	float Max = 0.11f; // 0.11f
	/**
	 * Raja-arvo vasemmalle kääntymiseen
	 */
	float Min = 0.09f; // 0.09f
	/**
	 * Raja-arvo tiukalle käännökselle vasempaan
	 */
	float TokaMin = 0.05f;

	/**
	 * Alustaa ja luo värisensorin, saa rakentajan aiemmasta luokasta
	 * 
	 * @param Data Vaihteen data
	 */
	public ViivaSensori(Vaihde Data) {
		this.Data = Data;
		vs = new VariSensori(SensorPort.S2);
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
			 * Asettaa Vaihdeluokkaan väriarvon hakemalla sen sensorin Get metodilla
			 */
			Data.setVariarvo(vs.getVariArvo());
			/**
			 * Kääntää oikealle jos väriarvo on yli Max arvon
			 */
			if (vs.getVariArvo() > Max) {
				Data.setKomento(3);
			}
			/**
			 * Kääntää vasemmalle jos väriarvo on alle Min arvon
			 */
			if (vs.getVariArvo() < Min) {
				Data.setKomento(2);
			}
			/**
			 * Kääntää tiukasti oikealle jos väriarvo on yli TokaMax arvon
			 */
			if (vs.getVariArvo() > TokaMax) {
				Data.setKomento(5);
			}
			/**
			 * Kääntää tiukasti vasemmalle jos väriarvo on alle TokaMin arvon
			 */
			if (vs.getVariArvo() < TokaMin) {
				Data.setKomento(4);
			}
			/**
			 * Ajaa suoraan jos väriarvo on arvojen Min ja Max välillä
			 */
			if (vs.getVariArvo() < Max && vs.getVariArvo() > Min) {
				Data.setKomento(1);
			}

		}

	}

}
