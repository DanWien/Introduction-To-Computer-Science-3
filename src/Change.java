
class Change {
	public static void main (String[] args) {
		
	}

	public static boolean change(int[] coins, int n) {
		return change(coins, n, 0, 0);
	}

	public static boolean change(int[] coins, int n, int sum, int Idx) {
		boolean ans;
		if (sum > n | Idx == coins.length | n == 0)
			ans = false;
		else if (sum == n)
			ans = true;
		else
		// Our options are : 1. Taking the coin in our current index and keep using all the coins there are to use.
		//                   2. Not taking the coin in our current index and move to the next index.
		// The double "|" Operator stops the function if we find a legal solution.
			ans = change(coins, n, sum + coins[Idx], Idx) ||
			      change(coins, n, sum, Idx + 1);
		return ans;
	}

	public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse) {
		return changeLimited(coins, n, numOfCoinsToUse, 0, 0, 0);
		// I chose to add an integer value that declares how many coins we have used up to a certain step,
		// Instead of subtracting from numOfCoinsToUse. Our options remain the same , but we add more base/stopping cases.
	}

	public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse, int numOfCoinsUsed, int sum, int Idx) {
		boolean ans;
	    if (numOfCoinsUsed <= numOfCoinsToUse & sum == n)
			ans = true;
		else if (numOfCoinsUsed > numOfCoinsToUse | sum > n | Idx == coins.length | n == 0 & numOfCoinsToUse > 0
				| numOfCoinsToUse == 0 & n > 0)
			ans = false;
		else
			ans = changeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed + 1, sum + coins[Idx], Idx) ||
				  changeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed, sum, Idx + 1);
		return ans;
	}

	public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
		printChangeLimited(coins, n, numOfCoinsToUse, 0, 0, 0, "");
	}
	
	// Using a boolean method so we can use || to only print one solution.
	// In every step in the recursion we want to concatenate every "coin" we have used so far. Once we have found 
	// A solution we print it , otherwise we print nothing ("")
	public static boolean printChangeLimited(int[] coins, int n, int numOfCoinsToUse, int numOfCoinsUsed, int sum,
			int Idx, String acc) {
		boolean ans;
		if (numOfCoinsUsed > numOfCoinsToUse | sum > n | Idx == coins.length | n == 0 & numOfCoinsToUse > 0
				| n > 0 & numOfCoinsToUse == 0) {
			System.out.print("");
			ans = false;
		} else if (numOfCoinsUsed <= numOfCoinsToUse & sum == n) {
			System.out.print(acc.substring(0, (acc.length() - 1)));
			ans = true;
		} else {
			ans = printChangeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed + 1, sum + coins[Idx], Idx,
					acc + coins[Idx] + ",") ||
			      printChangeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed, sum, Idx + 1, acc);
		}
		return ans;
	}

	public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
		return countChangeLimited (coins,n,numOfCoinsToUse,0,0,0,0);
	}
	// Instead of finding a solution or printing it , once we find one we count it and finally return our count.
	public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse, int numOfCoinsUsed, int sum, int Idx, int count) {
		if (numOfCoinsUsed > numOfCoinsToUse | sum > n | Idx == coins.length | n == 0 & numOfCoinsToUse > 0
				| n > 0 & numOfCoinsToUse == 0)
			count = 0;
		else if (numOfCoinsUsed <= numOfCoinsToUse & sum == n)
			count = 1;
		else {
			count = countChangeLimited(coins,n,numOfCoinsToUse,numOfCoinsUsed+1 , sum+coins[Idx], Idx, count) +
					countChangeLimited(coins,n,numOfCoinsToUse,numOfCoinsUsed,sum,Idx+1,count);
		}
		return count;
	}

	public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
		printAllChangeLimited(coins, n, numOfCoinsToUse, 0, 0, 0, "");
	}
	// Using a similar function to 2.3 , we now use a void method because we want ALL solutions.
	public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse, int numOfCoinsUsed, int sum,
			int Idx, String acc) {
		if (numOfCoinsUsed > numOfCoinsToUse | sum > n | Idx == coins.length | n == 0 & numOfCoinsToUse > 0
				| n > 0 & numOfCoinsToUse == 0) {
			System.out.print("");
		}
		else if (numOfCoinsUsed <= numOfCoinsToUse & sum == n) {
			System.out.println((acc.substring(0,acc.length()-1)));
			}
		    else {
			      printAllChangeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed + 1, sum + coins[Idx], Idx, acc + coins[Idx] + ",");
			      printAllChangeLimited(coins, n, numOfCoinsToUse, numOfCoinsUsed, sum, Idx + 1, acc);
		}
	}
}
