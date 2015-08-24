package Test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Model.StringCalculator;

public class TestStringCalculator {

	StringCalculator calc = null;

	@Before
	public void init() {
		calc = new StringCalculator();

	}

	@Test
	public void addEmptyTest() throws Exception {

		int sumOfNumbers = calc.add("");

		Assert.assertEquals(0, sumOfNumbers);
	}

	@Test
	public void addOneTest() throws Exception {

		int sumOfNumbers = calc.add("1");

		Assert.assertEquals(1, sumOfNumbers);
	}

	@Test
	public void addTwoTest() throws Exception {

		int sumOfNumbers = calc.add("1,2");

		Assert.assertEquals(3, sumOfNumbers);
	}

	@Test
	public void addUnkownAmountTest() throws Exception {

		int sumOfNumbers = calc.add("1,2,3,4,5,6,7,8");

		Assert.assertEquals(36, sumOfNumbers);
	}

	@Test
	public void addNewLineTest() throws Exception {

		int sumOfNumbers = calc.add("1\n2,3");

		Assert.assertEquals(6, sumOfNumbers);
	}

	@Test
	public void addDifferentDelimitersTest() throws Exception {

		int sumOfNumbers = calc.add("//;\n1;2");

		Assert.assertEquals(3, sumOfNumbers);
	}

	@Test
	public void addUnknownAmountDifferentDelimitersTest() throws Exception {

		int sumOfNumbers = calc.add("//;\n1;2;3;4");

		Assert.assertEquals(10, sumOfNumbers);
	}

	@Test
	public void addNegativeTest() throws Exception {

		String messsage = "";
		try {
			int sumOfNumbers = calc.add("//;\n1;-2");

		} catch (Exception e) {
			messsage = e.getMessage();
		}
		Assert.assertEquals("Negative not allowed", messsage);
	}

	@Test
	public void addIgnoreTest() throws Exception {

		int sumOfNumbers = calc.add("2,1001");

		Assert.assertEquals(2,sumOfNumbers);
	}
	
	@Test
	public void addAnyLengthDelimitersTest() throws Exception {

		int sumOfNumbers = calc.add("//[***]\n1***2***3");

		Assert.assertEquals(6,sumOfNumbers);
	}

}
