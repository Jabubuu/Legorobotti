package kirjasto;

import lejos.hardware.Button;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MoottoriLuokka {
	/**
	 * Alustaa ja luo moottorit
	 */
	UnregulatedMotor Rightmotor = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor Leftmotor = new UnregulatedMotor(MotorPort.B);

	/**
	 * Raja-arvo oikealle kääntymistä varten
	 */
	float Max = 0.11f; // 0.11f
	/**
	 * Raja-arvo vasemmalle kääntymistä varten
	 */
	float Min = 0.09f; // 0.09f
	/**
	 * Moottoreiden teho prosenteissa
	 */
	int Speed = 80;
	/**
	 * Moottorin hidastusarvo
	 */
	float ReduceSpeed;

	/**
	 * Metodi kääntää robottia vasemmalle, saa väriarvon ja vähentää sillä nopeutta
	 * 
	 * @param arvo värisensorin arvo
	 */
	public void vasen(float arvo) {

		ReduceSpeed = ((Min - arvo) * 600);
		Leftmotor.setPower(Speed - Math.round(ReduceSpeed));
		Rightmotor.setPower(Speed);
	}

	/**
	 * Metodi kääntää robottia tiukasti vasemmalle, saa väriarvon ja vähentää sillä
	 * nopeutta
	 * 
	 * @param arvo värisensorin arvo
	 */
	public void tiukkavasen(float arvo) {

		ReduceSpeed = ((Min - arvo) * 1000);
		Leftmotor.setPower(Speed - Math.round(ReduceSpeed));
		Rightmotor.setPower(Speed);
	}

	/**
	 * Metodi kääntää robottia oikealle, saa väriarvon ja vähentää sillä nopeutta
	 * 
	 * @param arvo värisensorin arvo
	 */
	public void oikea(float arvo) {

		ReduceSpeed = ((arvo - Max) * 600);
		Rightmotor.setPower(Speed - Math.round(ReduceSpeed));
		Leftmotor.setPower(Speed);
	}

	/**
	 * Metodi kääntää robottia tiukasti oikealle, saa väriarvon ja vähentää sillä
	 * nopeutta
	 * 
	 * @param arvo värisensorin arvo
	 */
	public void tiukkaoikea(float arvo) {

		ReduceSpeed = ((arvo - Max) * 1000);
		Rightmotor.setPower(Speed - Math.round(ReduceSpeed));
		Leftmotor.setPower(Speed);
	}

	/**
	 * Metodi ajaa robottia suoraan
	 */
	public void suoraan() {
		Rightmotor.setPower(Speed);
		Leftmotor.setPower(Speed);
	}

	/**
	 * Metodi pysäyttää robotin ja sulkee moottorit
	 */
	public void stop() {

		Rightmotor.stop();
		Leftmotor.stop();
		Rightmotor.close();
		Leftmotor.close();

		Button.waitForAnyPress();
		System.exit(0);
	}

	/**
	 * Kääntää robottia vasemmalle
	 */
	public void VaistoOsa1() {

		Leftmotor.setPower(-40);
		Rightmotor.setPower(+55);
		Delay.msDelay(300);

	}

	/**
	 * Asettaa tehon robotin kaartamista varten
	 */
	public void VaistoOsa2() {

		Leftmotor.setPower(90);
		Rightmotor.setPower(60);
	}

	/**
	 * Kääntää robottia vasemmalle
	 */
	public void VaistoOsa3() {

		Leftmotor.setPower(-50);
		Rightmotor.setPower(+50);
		Delay.msDelay(200);

	}
}
