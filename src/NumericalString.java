public class NumericalString {
	public static int toInt(char c) {
		String a = "0123456789";
		return a.indexOf(c);
	}

	public static boolean legalNumericString(String s, int b) {
		boolean ans = true;
		if (b < 2 | b > 10)
			throw new IllegalArgumentException("Invalid base Input");
		if (s == null || s.length() == 0 || s.charAt(s.length() - 1) == '0' & s.length() > 1)
			ans = false;
		// Both if's before the for loops are there to avoid invocation of string.length methods on input strings that are null.
		if (ans) {
			for (int i = 0; i < s.length(); i = i + 1) {
				if (s.charAt(i) < '0' | s.charAt(i) > '9')
					ans = false;
			}
		}
		if (ans) {
			for (int i = 0; i < s.length(); i = i + 1) {
				if (toInt(s.charAt(i)) >= b)
					ans = false;
			}
		}
		return ans;
	}

	public static String decimalIncrement(String s) {
		if (!legalNumericString(s, 10))
			throw new IllegalArgumentException("Invalid Input");
		return decimalIncrement(s, "");
	}

	// Our stopping points are strings with one digit. We only need to call the
	// Recursion if the first Digit is 9. Then we need to check if the next one is 9 as well ,
	// And so on. If the last digit is 9 , we add 01 to all the 0's we have concatenated to acc.
	public static String decimalIncrement(String s, String acc) {
		if (toInt(s.charAt(0)) != 9) {
			if (s.length() > 1) {
				acc = acc + (toInt(s.charAt(0)) + 1) + s.substring(1);
			} else
				acc = acc + (toInt(s.charAt(0)) + 1);
		} else if (toInt(s.charAt(0)) == 9) {
			if (s.length() > 1) {
				acc = '0' + decimalIncrement(s.substring(1), acc);
			} else
				acc = acc + "01";
		}
		return acc;
	}

	public static String decimalDouble(String s) {
		if (!legalNumericString(s, 10))
			throw new IllegalArgumentException("Invalid Input");
		return decimalDouble(s, "", 0);
	}

	// When we multiply a number bigger or equal to 5 , we want to keep the LSB from the multiplication. 
	// Then we Declare a carry , and our biggest carry is one Because 9*2 = 18 and 9 is the biggest digit.
	// Therefore , for every step we multiply one digit and pass on its carry.
	public static String decimalDouble(String s, String acc, int carry) {
		if (toInt(s.charAt(0)) < 5) {
			if (s.length() > 1)
				acc = acc + (toInt(s.charAt(0)) * 2 + carry) + decimalDouble(s.substring(1), acc, 0);
			else
				acc = acc + (toInt(s.charAt(0)) * 2 + carry);
		} else if (toInt(s.charAt(0)) >= 5) {
			if (s.length() > 1) {
				acc = acc + ((toInt(s.charAt(0)) * 2) % 10 + carry) + acc + decimalDouble(s.substring(1), acc, 1);
			} else
				acc = acc + ((toInt(s.charAt(0)) * 2 % 10 + carry)) + '1';
		}
		return acc;
	}

	public static String binary2Decimal(String s) {
		if (!legalNumericString(s, 2))
			throw new IllegalArgumentException("Invalid Input");
		return binary2Decimal(s, "0");
	}

	// We use our previous functions in a way that when we meet '0' , we multiply our decimal string by two.
	// When we meet '1' we first multiply it by two and then add one.
	public static String binary2Decimal(String s, String acc) {
		if (s.length() >= 1) {
			if (s.charAt(s.length() - 1) == '1') {
				acc = decimalDouble(acc);
				acc = decimalIncrement(acc);
				acc = binary2Decimal(s.substring(0, s.length() - 1), acc);
			} else {
				acc = decimalDouble(acc);
				acc = binary2Decimal(s.substring(0, s.length() - 1), acc);
			}
		}
		return acc;
	}
}
