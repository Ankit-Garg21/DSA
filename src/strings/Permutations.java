package strings;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

	public Permutations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations perm = new Permutations();
		Set<String> s = perm.generatePerm("ankit");
		
		for(String p : s) {
			System.out.println(p);
		}
	}

	public Set<String> generatePerm(String input) {
		Set<String> set = new HashSet<String>();
		if (input == "")
			return set;

		Character a = input.charAt(0);

		if (input.length() > 1) {
			input = input.substring(1);

			Set<String> permSet = generatePerm(input);

			for (String x : permSet) {
				for (int i = 0; i <= x.length(); i++) {
					set.add(x.substring(0, i) + a + x.substring(i));
				}
			}
		} else {
			set.add(a + "");
		}
		return set;
	}

}
