//Given two binary strings, return their sum (also a binary string).
//The input strings are both non-empty and contains only characters 1 or 0.
//Each string consists only of '0' or '1' characters.
//1 <= a.length, b.length <= 10^4
//Each string is either "0" or doesn't contain any leading zero.

public class addBinaryString {

	public static void main(String[] args) {

		String abc = addBinary("11101", "101");

		System.out.println(abc);

	}

	public static String addBinary(String a, String b) {

		StringBuilder res = new StringBuilder();

		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		int diff = a.length() - b.length();

		int carry = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			int ValueAta = (a.charAt(i) - '0');

			int ValueAtb = 0;

			if (i - diff > -1) {
				ValueAtb = (b.charAt(i - diff) - '0');
			} else {
				ValueAtb = 0;
			}

			int sum = (ValueAta + ValueAtb + carry);
			if (sum == 3) {
				res.append(1);
				carry = 1;
			} else if (sum == 2) {
				res.append(0);
				carry = 1;
			} else if (sum == 1) {
				res.append(1);
				carry = 0;
			} else {
				res.append(0);
				carry = 0;
			}

		}
		if (carry == 1) {
			res.append(1);
		}

		return res.reverse().toString();
	}

}
