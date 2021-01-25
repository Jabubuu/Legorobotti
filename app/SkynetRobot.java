package app;

import java.io.File;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class SkynetRobot {

	public static void main(String[] args) {

		/**
		 * Luo uudet oliot luokista
		 */
		Vaihde Data = new Vaihde();
		EsteSensori Este = new EsteSensori(Data);
		Kulkija Ajo = new Kulkija(Data);
		ViivaSensori Viiva = new ViivaSensori(Data);
		
		/**
		 * Introtekstiä ja valoja robotin käynnistyksessä
		 */
		System.out.println("Skynet activated");
		System.out.println("Paina jotain.....");
		Button.LEDPattern(4);
		Sound.beepSequenceUp();



		/**
		 * Käynnistää sensori thread luokat
		 */
		Viiva.start();
		Este.start();
		/**
		 * Odottaa napin painallusta, ennenkuin aloittaa robotin ajon + 5 sekunnin delay
		 */
		Button.waitForAnyPress();
		Button.LEDPattern(0);
		Delay.msDelay(3000);
		/**
		 * Ajaa Robotin
		 */
		Ajo.start();
		/**
		 * Taustamusiikkien käynnistys
		 */
		File file = new File("totoo.wav");
		/**
		 * Toistaa musiikkia niin kauan kun Escape nappi on painamatta
		 */
		while (Button.ESCAPE.isUp()) {
			Sound.playSample(file, Sound.VOL_MAX);
		}

	}

}
