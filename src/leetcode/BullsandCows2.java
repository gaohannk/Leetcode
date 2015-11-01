package leetcode;

public class BullsandCows2 {
	public String getHint(String secret, String guess) {
		int[] amap = new int[10];
		int[] bmap = new int[10];
		int atimes = 0, btimes = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				atimes++;
			} else {
				amap[secret.charAt(i) - '0']++;
				bmap[guess.charAt(i) - '0']++;
			}
		}
		for (int i = 0; i < 10; i++) {
			btimes += Math.min(amap[i], bmap[i]);
		}
		return atimes + "A" + btimes + "B";
	}
}
