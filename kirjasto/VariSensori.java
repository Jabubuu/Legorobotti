package kirjasto;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;

public class VariSensori {
	/**
	 * Alustaa värisensorin
	 */
	public EV3ColorSensor color;
	/**
	 * Värisensorin väriarvo
	 */
	public float[] sample;
	/**
	 * Värisensorin rakentaja, ottaa parametriksi portin
	 * Luo värisensori-olion
	 * Asettaa värimoodiksi punaisen
	 * @param port värisensorin ja robotin välinen portti
	 */
	public VariSensori(Port port) {
		color = new EV3ColorSensor(port);
		color.setCurrentMode("Red");
		sample = new float[color.sampleSize()];
	}
	/**
	 * Get metodi sample muuttujalle
	 * @return väriarvo
	 */
	public float getVariArvo() {
		color.fetchSample(sample, 0);
		return sample[0];
	}
	/**
	 * Metodi sulkee värisensorin
	 */
	public void close() {
		color.close();
	}
}
