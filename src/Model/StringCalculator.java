package Model;

public class StringCalculator {

	private void temporaryMethod(String numbers) {

		String regx1 = "\\d\\D\\d";

	}
	
	
	public int add(String numbers) throws Exception {

		temporaryMethod(numbers);

		int sum = 0;
		String[] splitString;
		final int ignoredNumber = 1000;

		if (!numbers.equals("")) {

			if (numbers.startsWith("//")) {

				String delimiter = numbers.substring(2, 3);
				int indexOfFirstNumber = 5;

				if (delimiter == "\\") {

					delimiter = ";";
					indexOfFirstNumber = 4;

				}

				String newNumbers = numbers.substring(indexOfFirstNumber - 1);
				splitString = newNumbers.split(delimiter);

			} else {

				if (numbers.contains("\n")) {

					numbers = numbers.replaceAll("\n", ",");

				}

				splitString = numbers.split(",");
			}

			for (String str : splitString) {

				int number = Integer.parseInt(str);

				if (number >= ignoredNumber)
					number = 0;

				if (number < 0) {
					throw new Exception("Negative not allowed");
				}

				sum += number;
			}

		}

		return sum;
	}

	
}
