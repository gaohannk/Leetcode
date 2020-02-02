package leetcode.algo.g;

/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
*/

// Brute Force
public class GuessNumberHigherorLower2 extends GuessGame {
	public GuessNumberHigherorLower2(int target) {
		this.target = target;
	}

	public int guessNumber(int n) {
		for (int i = 1; i < n; i++) {
			if (guess(i) == 0)
				return i;
		}
		return n;
	}

	public int guess(int num) {
		return num < target ? 1 : num == target ? 0 : -1;
	}

	public static void main(String[] args) {
		GuessNumberHigherorLower2 guess = new GuessNumberHigherorLower2(10);
		System.out.println(guess.guessNumber(20));
	}
}
