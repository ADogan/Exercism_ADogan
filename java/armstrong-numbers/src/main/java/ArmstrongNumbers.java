import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class ArmstrongNumbers {
	int amountOfDigits;
	List<Integer> separatedDigits = new ArrayList<>();
	List<Integer> separatedDigitsToThePowerOfAmountOfDigits = new ArrayList<>();

	boolean isArmstrongNumber(int numberToCheck) {
		if(numberToCheck < 10){
			return true;
		} else {
			separateToDigits(numberToCheck);
			calculateDigitsToThePowerOfAmountOfDigits();
			int sumOfDigits = calculateSumOfDigits();
			return numberToCheck == sumOfDigits;
		}
	}

	private void separateToDigits(int numberToCheck){
		String numberAsString = numberToCheck + "";

		amountOfDigits = numberAsString.length();

		for(char c: numberAsString.toCharArray()){
			separatedDigits.add( Integer.parseInt("" + c) );
		}
	}

	private void calculateDigitsToThePowerOfAmountOfDigits() {
		ListIterator<Integer> iterator = separatedDigits.listIterator();

		while(iterator.hasNext()) {
			int next = iterator.next();
			separatedDigitsToThePowerOfAmountOfDigits.add((int)Math.pow(next, amountOfDigits));
		}
	}

	private int calculateSumOfDigits() {
		Integer sumOfDigits = 0;
		for( Integer digit : separatedDigitsToThePowerOfAmountOfDigits){
			sumOfDigits += digit;
		};
		return sumOfDigits;
	}

}
