package app;

import kirjasto.*;
import lejos.hardware.Button;
import lejos.utility.Stopwatch;

public class Kulkija extends Thread {
	/**
	 * Vaihdeluokan pohjustaminen
	 */
	Vaihde Data;
	VariSensori vs;
	UltraBra us;
	/**
	 * Havaittujen esteiden määrä, aluksi 0
	 */
	int Estelaskuri = 0;

	/**
	 * Alustaa Kulkija luokan, saa rakentajan aikaisemmasta luokasta
	 * 
	 * @param Data Vaihteen data
	 */
	public Kulkija(Vaihde Data) {
		this.Data = Data;
	}

	/**
	 * Ajometodi luokan ajamista varten
	 */
	public void run() {
		/**
		 * Luo uudet oliot Kello ja Moottoriluokka luokille
		 */
		Stopwatch kello = new Stopwatch();
		MoottoriLuokka motor = new MoottoriLuokka();
		/**
		 * Ajaa metodia loputtomalla loopilla
		 */
		while (true) {
			/**
			 * Tutkii onko Escape-nappia painettu ja pysäyttää robotin jos tosi
			 */
			if (Button.ESCAPE.isDown()) {
				motor.stop();
				vs.close();
				us.disable();
			}
			/**
			 * Tutkii Vaihdeluokan Komento muuttujan arvoa ja valitsee suoritettavan koodin
			 * Break komennolla tutkii uudestaan muuttujan arvon
			 */
			switch (Data.getKomento()) {

			case 1:
				/**
				 * Ajaa robottia suoraan
				 */
				motor.suoraan();
			case 2:
				/**
				 * Kääntää robottia vasemmalle
				 */
				motor.vasen(Data.getVariarvo());
				break;
			case 3:
				/**
				 * Kääntää robottia oikealle
				 */
				motor.oikea(Data.getVariarvo());
				break;
			case 4:
				/**
				 * Kääntää robottia jyrkästi vasemmalle
				 */
				motor.tiukkavasen(Data.getVariarvo());
				break;
			case 5:
				/**
				 * Kääntää robottia jyrkästi oikealle
				 */
				motor.tiukkaoikea(Data.getVariarvo());
				break;
			case 6:
				/**
				 * Tutkii havaittujen esteiden määrää, jos arvo 1 niin pysähtyy ja näyttää
				 * kierrosajan
				 */
				if (Estelaskuri == 1) {
					System.out.println("Aika oli: " + kello.elapsed() / 1000 + " sekuntia");
					motor.stop();
					vs.close();
					us.disable();
					
					
				}
				/**
				 * Ajaa väistöliikkeen metodin
				 */
				motor.VaistoOsa1();
				/**
				 * Tutkii väriarvoa ja ajaa väistöliikkeen metodia niin kauan kunnes viiva on
				 * havaittu
				 */
				while (Data.getVariarvo() > 0.11f) {
					motor.VaistoOsa2();
				}
				/**
				 * Ajaa väistöliikkeen metodin
				 */
				motor.VaistoOsa3();
				/**
				 * Lisää väistön jälkeen muuttujan arvoa yhdellä
				 */
				Estelaskuri++;
				break;
			}
		}
	}
}
