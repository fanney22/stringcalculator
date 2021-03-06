package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testAnotherNumber(){
	assertEquals(3, Calculator.add("3"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testSameTwoNumbers(){
		assertEquals(10, Calculator.add("5,5"));
	}

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
	public void testALargeNumberOfNumbers(){
		assertEquals(21, Calculator.add("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"));
	}
	
	@Test
	public void testNewlineBetweenNumbers(){
		assertEquals(5, Calculator.add("2\n3"));
	}
	
	@Test
	public void testBothCommasAndNewline(){
		assertEquals(7, Calculator.add("1\n2,4"));
	}
	
	@Test
	public void testNewDelimeter(){
		assertEquals(7, Calculator.add("//k\n1k2k4"));
	}
	
	@Test
	public void testNewStringDelimiter(){
		assertEquals(7, Calculator.add("//DJAMM\n1DJAMM2DJAMM4"));
	}
	
	@Test
	public void testIconAsDelimiter(){
		assertEquals(7, Calculator.add("//;\n1;2;4"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeNumbers(){
		Calculator.add("1, -8");
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegitiveWithDelimeter(){
		Calculator.add("//u\n1u-1");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMultipleNegitives(){
		Calculator.add("-1,-2,-3,-4");
	}
	
	@Test
	public void testOverOnethousand(){
		assertEquals(7, Calculator.add("1001,3,4"));
	}
	
	@Test
	public void testOnethousand(){
		assertEquals(1001, Calculator.add("1000,1"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testBigAndSmall(){
		Calculator.add("2000,-7");
	}
	
	@Test
	public void testLongDelimeter(){
		assertEquals(8, Calculator.add("//;;;\n1;;;5;;;2"));
	}
	
	@Test
	public void testmultipleDelimeters(){
		assertEquals(8, Calculator.add("//[x][k]\n1k2x2k3"));
	}
	
	@Test
	public void testLongDelimeters(){
		assertEquals(8, Calculator.add("//[Fanney][Hrund]\n1Fanney2Hrund2Fanney3"));
	}
	
	@Test
	public void testManyDelimeters(){
		assertEquals(6, Calculator.add("//[D][I][S][C][O]\n1D1I1S1C1O1"));
	}
}