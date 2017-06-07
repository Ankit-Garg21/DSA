/* Find anagrams of a pattern into an input */

package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pattern {

	HashMap<Character, Integer> alphabetHash = new HashMap<Character, Integer>();

	public Pattern() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input");
		String input = scan.nextLine();

		System.out.println("Enter pattern");
		String pattern = scan.nextLine();

		Pattern patternObj = new Pattern();

		patternObj.generateAlphabetHash(input);

		int patternHash = patternObj.generateHash(pattern, true);
		
		int inputLength = input.length();
		int patternLength = pattern.length();
		int counter = 0;
		for (counter = 0; counter < inputLength; counter++) {

			int endIndex = counter + patternLength;

			if (endIndex <= inputLength) {
				String subString = input.substring(counter, endIndex);
				int subStringHash = patternObj.generateHash(subString, true);

				if (subStringHash == patternHash) {
					System.out.println("Match found at " + counter);
				}
			} else {
				break;
			}
		}
	}

	// Create a map of each alphabet in input to a prime number
	private void generateAlphabetHash(String input) {
		// TODO Auto-generated method stub
		int length = input.length();
		Integer[] primes = generatePrime(length);
		char[] alphabet = input.toCharArray();
		for (int i = 0; i < alphabet.length; i++) {
			alphabetHash.put(alphabet[i], primes[i]);
		}
	}

	// Generate hash of a given string. If ignoreOrder is true, generates same hash for anagrams.
	public int generateHash(String str, boolean ignoreOrder) {
		int hash = 7;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if(ignoreOrder) {
				hash += hash * alphabetHash.get(str.charAt(i));
			} else {
				hash += hash * 31 + str.charAt(i);
			}
		}
		return hash;
	}

	// Generate primes number array of length equals to input's length
	public Integer[] generatePrime(int length) {
		Integer[] primes = {};
		int arrayGrowth = 1;
		for (int i = 2;; i++) {
			if (primes.length < length) {
				if (isPrime(i)) {
					// Increase prime number array capacity
					primes = Arrays.copyOf(primes, primes.length + arrayGrowth);
					primes[primes.length - 1] = i;
				}
			} else {
				break;
			}
		}
		return primes;
	}

	// Check if a number is prime or not
	private boolean isPrime(int num) {
		// TODO Auto-generated method stub
		boolean isPrime = true;
		for (int i = 2; i * i < num; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
