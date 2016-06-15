package leetcode;
public class Wildcard_Matching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		int slen = s.length();
		int plen = p.length();
		int posp = 0, poss = 0, posstar_p = -1, posstar_s = -1;
		while (slen > poss) {
			if (posp < plen
					&& (s.charAt(poss) == p.charAt(posp) || p.charAt(posp) == '?')) {
				posp++;
				poss++;
			} else if (posp < plen && p.charAt(posp) == '*') {
				posstar_p = posp;
				posstar_s = poss;
				posp++;
				continue;
			} else if (posstar_p != -1) {
				posp = posstar_p + 1;
				poss = posstar_s;
				posstar_s++;
			} else {
				return false;
			}
		}
		while (plen > posp && p.charAt(posp) == '*') {
			posp++;
		}

		if (posp == plen && poss == slen) {
			return true;
		}
		return false;
	}
}