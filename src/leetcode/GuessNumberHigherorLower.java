package leetcode;

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
abstract class GuessGame {
	int target;

	public abstract int guess(int num);
}

public class GuessNumberHigherorLower extends GuessGame {
	public GuessNumberHigherorLower(int target) {
		this.target = target;
	}

	public int guessNumber(int n) {
		// Should be n/2 not (n+1)/2 in case of n = 2147483647
		int res = n / 2;
		int start = 1;
		int end = n;
		while (guess(res) != 0) {
			if (guess(res) == 1) {
				start = res + 1;
			} else if (guess(res) == -1) {
				end = res - 1;
			}
			res = start + (end - start) / 2;
		}
		return res;
	}

	public int guess(int num) {
		return num < target ? 1 : num == target ? 0 : -1;
	}

	public static void main(String[] args) {
		GuessNumberHigherorLower guess = new GuessNumberHigherorLower(20);
		System.out.println(guess.guessNumber(20));
	}
}
