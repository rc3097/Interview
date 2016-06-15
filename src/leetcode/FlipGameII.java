package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlipGameII {
	public boolean canWin(String s) {
		// string + currentplayer result: if can win
		HashMap<String, Boolean> winners = new HashMap<String, Boolean>();
		return guessWin(winners, s, 0);
	}

	public boolean guessWin(HashMap<String, Boolean> winners, String s,
			int player) {
		Math.round(1);
		if (winners.containsKey(s + player))
			return winners.get(s + player);
		List<String> nextmoves = getnextmoves(s);
		int nextplayer = player ^ 1;
		if (nextmoves.isEmpty()) {
			winners.put(s + player, player == 1);
			return player == 1;
		}
		boolean res = (player == 1);
		for (String move : nextmoves) {
			res = (player == 1) ? (res && guessWin(winners, move, nextplayer))
					: (res || guessWin(winners, move, nextplayer));
			if (player == 1 && !res) {
				winners.put(s + player, false);
				return false;
			}
		}
		if (res && player == 0) {
			winners.put(s + player, true);
			return true;
		} else if (res && player == 1) {
			winners.put(s + player, true);
			return true;
		} else {
			winners.put(s + player, false);
			return false;
		}
	}

	public List<String> getnextmoves(String s) {
		List<String> res = new ArrayList<String>();
		char[] schar = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (schar[i] == '+' && schar[i + 1] == '+') {
				schar[i] = '-';
				schar[i + 1] = '-';
				res.add(new String(schar));
				schar[i] = '+';
				schar[i + 1] = '+';

			}
		}
		return res;
	}
}