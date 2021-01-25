package kirjasto;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;

public class UltraBra implements RangeFinder {
	/**
	 * Alustaa ultraäänisensorin ja RangeFinderin SampleProvider
	 */
	EV3UltrasonicSensor sensori;
	SampleProvider sp;
	float[] sample;
	
	/**
	 * Rakennetaan metodi UltraBra ja ultraäänisensori ja annetaan sille
	 * getDistanceMode
	 * 
	 * @param port ultrasensorin portti
	 */
	public UltraBra(Port port) {
		sensori = new EV3UltrasonicSensor(port);
		sp = sensori.getDistanceMode();
		sample = new float[sp.sampleSize()];
		sensori.enable();
	}

	/**
	 * Get metodi joka palauttaa sensorin arvon (etäisyys)
	 *  @return sensorin arvo
	 */

	public float getRange() {
		sp.fetchSample(sample, 0);

		return sample[0];
	}

	/**
	 * Get metodi joka palauttaa sensorin arvot listana (etäisyys)
	 *  @return sensorin arvot
	 */
	public float[] getRanges() {
		sp.fetchSample(sample, 0);

		return sample;
	}

	/**
	 * Metodi joka aktivoi sensorin
	 */
	public void enable() {
		sensori.enable();
	}

	/**
	 * Metodi joka sulkee sensorin
	 */
	public void disable() {
		sensori.disable();
	}
	

	/**
	 * Metodi joka tutkii onko ultrasensori päällä
	 * 
	 * @return sensori onkopäällä
	 */
	public boolean isEnabled() {
		return sensori.isEnabled();
	}

}