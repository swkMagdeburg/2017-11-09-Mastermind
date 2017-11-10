package org.softwerkskammer.magdeburg.mastermind;

public class Mastermind {

    public EvaluationResult evaluate(PinColor[] secret, PinColor[] guess) {
    	if (secret.length != guess.length) {
    		throw new IllegalArgumentException();
    	}

		boolean[] usedColors = new boolean[secret.length];
    	int correctColors = countCorrectColors(secret, guess, usedColors);
    	int correctButMissplacedColors = countCorrectButMissplacedColor(secret, guess, usedColors);

    	EvaluationResult result = new EvaluationResult(correctColors, correctButMissplacedColors);
    	return result;
    }

	private int countCorrectColors(PinColor[] secret, PinColor[] guess, boolean[] usedColors) {
		int result = 0;
		for (int i = 0; i < secret.length; i++) {
			if (secret[i] == guess[i]) {
				usedColors[i] = true;
				result++;
			}
		}
		return result;
	}

	private int countCorrectButMissplacedColor(PinColor[] secret, PinColor[] guess, boolean[] usedColors) {
		int result = 0;
		for (PinColor color : guess) {
			if (isColorInArray(color, secret, usedColors)) {
				result++;
			}
		}	
		return result;
	}

	private boolean isColorInArray(PinColor color, PinColor[] secret, boolean[] usedColors) {
		for (int i = 0; i < secret.length; i++) {
			if (secret[i] == color && !usedColors[i]) {
				usedColors[i] = true;
				return true;
			}
		}
		return false;
	}
}
