package nelsoncca;

import java.util.concurrent.TimeUnit;

public class Timer {
	public static void main(String[] args) {

		int secondones = 0;
		int secondtens = 0;
		int minuteones = 0;
		int minutetens = 0;
		int milisecondones = 0;
		int milisecondtens = 0;
		int hourones = 0;
		int hourtens = 0;

		do {
			System.out.println("" + minutetens + minuteones + ":" + secondtens + secondones
					+ ":" + milisecondtens + milisecondones);

			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			milisecondones = milisecondones + 1;
			if (milisecondones == 10) {
				milisecondones = milisecondones - 10;
				milisecondtens = milisecondtens + 1;
				if (milisecondtens == 10) {
					milisecondtens = milisecondtens - 10;
					secondones = secondones + 1;
					if (secondones == 10) {
						secondones = secondones - 10;
						secondtens = secondtens + 1;
						if (secondtens == 6) {
							secondtens = secondtens - 6;
							minuteones = minuteones + 1;
							if (minuteones == 10) {
								minuteones = minuteones - 10;
								minutetens = minutetens + 1;
								if (minutetens == 6) {
									minutetens = minutetens - 6;
									hourones = hourones + 1;
									if (hourones == 10) {
										hourones = hourones - 10;
										hourtens = hourtens + 1;
									}
								}
							}

						}
					}
				}
			}
		} while (true);
	}
}