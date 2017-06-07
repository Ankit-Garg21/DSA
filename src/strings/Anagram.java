package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	public static int NUMBER_LETTERS = 26;
	public Anagram() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		System.out.println(numberNeeded(first, second));
	}

	private static int numberNeeded(String first, String second) {
		// TODO Auto-generated method stub
		int[] charCount1 = getCharCount(first);
		int[] charCount2 = getCharCount(second);
		
		return getDelta(charCount1, charCount2);
	}

	private static int[] getCharCount(String s) {
		// TODO Auto-generated method stub
		int[] charCount = new int[NUMBER_LETTERS];
		int offset = (int) 'a';
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			int code = c - offset;
			charCount[code]++;
		}
		return charCount;
	}

	private static int getDelta(int[] charCount1, int[] charCount2) {
		// TODO Auto-generated method stub
		if(charCount1.length != charCount2.length) {
			return -1;
		}
		int delta = 0;
		for(int i=0; i<charCount1.length; i++) {
			int diff = Math.abs(charCount1[i] - charCount2[i]);
			delta += diff;
		}
		return delta;
	}
}
