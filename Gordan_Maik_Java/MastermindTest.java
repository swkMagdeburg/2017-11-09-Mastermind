package org.softwerkskammer.magdeburg.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {

	
	private Mastermind systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new Mastermind();
	}
	
	@Test
	public void oneCorrect() {
		EvaluationResult result = systemUnderTest.evaluate(new PinColor[] {PinColor.GREEN}, new PinColor[] {PinColor.GREEN});
		assertEquals(1, result.GetWellPlacedColors());
		assertEquals(0, result.GetCorrectButMissplacedColors());
	}
	
	@Test
	public void oneFalseAndOneColorMissplaced() {
		EvaluationResult result = systemUnderTest.evaluate(new PinColor[] {PinColor.GREEN, PinColor.YELLOW}, new PinColor[] { PinColor.PURPLE, PinColor.GREEN});
		assertEquals(1, result.GetCorrectButMissplacedColors());
		assertEquals(0, result.GetWellPlacedColors());
	}
	
	private static PinColor[] SECRET_COLORS = new PinColor[] {PinColor.GREEN, PinColor.BLUE, PinColor.RED, PinColor.PURPLE };
	
	@Test
	public void fourColorsGivenOnlyOneColorMissplaced() {
		EvaluationResult result = systemUnderTest.evaluate(SECRET_COLORS, new PinColor[] {PinColor.YELLOW, PinColor.YELLOW, PinColor.BLUE, PinColor.BLUE});
		assertEquals(0, result.GetWellPlacedColors());
		assertEquals(1, result.GetCorrectButMissplacedColors());
	}
	
	@Test
	public void fourColorsGivenOneCorrectAndOneColorMissplaced() {
		EvaluationResult result = systemUnderTest.evaluate(SECRET_COLORS, new PinColor[] {PinColor.PURPLE, PinColor.RED, PinColor.RED, PinColor.YELLOW});
		assertEquals(1, result.GetWellPlacedColors());
		assertEquals(1, result.GetCorrectButMissplacedColors());
	}

}
