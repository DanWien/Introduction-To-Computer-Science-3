
import java.math.BigInteger;
import java.util.Random;

class Assignment3BigInteger {

	public static BigInteger sumSmaller(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		// If the input is smaller , or equal to zero we have no positive numbers to sum.
		if (n.compareTo(sum) <= 0) 
			sum = BigInteger.ZERO;
		else {
			// BigIntegers are immutable , so we need another BigInteger to add up to our sum.
			BigInteger Addition = BigInteger.ONE;
			while (Addition.compareTo(n) == -1) { // Until addition is equal to n
				sum = sum.add(Addition);
				Addition = Addition.add(BigInteger.ONE);
			}
		}
		return sum;
	}

	public static void printRandoms(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i = i + 1) {
			int r = random.nextInt();
			System.out.println(r);
		}
	}

	public static boolean isPrime(BigInteger n) {
		boolean ans = true;
		// Using the isPrime algorithm with relevant BigInteger methods.
		BigInteger divisor = BigInteger.TWO;
		if (n.compareTo(BigInteger.ONE) == 0 | n.compareTo(BigInteger.ZERO) == 0) // Declaring 0 and 1 are not primes.
			ans = false;
		else {
			while ((divisor.multiply(divisor)).compareTo(n) <= 0 & ans) {
				if (n.mod(divisor).equals(BigInteger.ZERO)) {
					ans = false;
				}
				divisor = divisor.add(BigInteger.ONE);
			}
		}
		return ans;
	}

	public static BigInteger randomPrime(int n) {
		BigInteger randBig = new BigInteger("0");
		Random random = new Random();
		// BigInteger 0 is not prime as stated in 1.3 , therefore we keep raffling Until we get a Prime number. 
		while (!isPrime(randBig)) {
			BigInteger randBigPrime = new BigInteger(n, random);
			if (isPrime(randBigPrime)) { // When we find one , we add it to our randBig and no longer enter the while loop.
				randBig = randBig.add(randBigPrime);
			}
		}
		return randBig;
	}
}