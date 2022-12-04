package contest.bc87;

import java.util.Arrays;

public class L6185 {
	public static void main(String[] args) {
		new L6185();
	}

	L6185() {

	}

	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int ans = 0;
		int p = players.length - 1;
		int t = trainers.length - 1;
		while (p >= 0 && t >= 0) {
			if (players[p] > trainers[t]) {
				p--;
			} else {
				ans++;
				p--;
				t--;
			}
		}
		return ans;
	}
}
