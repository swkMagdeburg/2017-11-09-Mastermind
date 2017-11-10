package org.softwerkskammer.magdeburg.mastermind;

public class EvaluationResult {

	private final int wellPlacedColors;
	private final int correctButMissplacedColors;

	public EvaluationResult(int wellPlacedColors, int correctButMissplacedColors) {
		this.wellPlacedColors = wellPlacedColors;
		this.correctButMissplacedColors = correctButMissplacedColors;
	}
	
	
	public int GetWellPlacedColors() {
		return wellPlacedColors;
	}
	
	public int GetCorrectButMissplacedColors() {
		return correctButMissplacedColors;
	}
}
