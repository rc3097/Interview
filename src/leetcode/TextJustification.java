package leetcode;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		ArrayList<String> res = new ArrayList<String>();
		int start = 0;
		boolean islast = false;
		while (start + 1 < words.length) {
			int currlen = 0;
			int end = start - 1;
			while (end + 1 < words.length
					&& currlen + (end - start) <= maxWidth) {
				end++;
				currlen += words[end].length();
			}
			if (!(currlen + (end - start) <= maxWidth)) {
				currlen -= words[end].length();
			} else {
				islast = true;
				end++;
			}

			int[] spaceinfo = getSpacenum(maxWidth, currlen, (end - start),
					islast);
			int spacenum = spaceinfo[0];
			int extranum = spaceinfo[1];

			String spaces = createSpace(spacenum);
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < end; i++) {
				sb.append(words[i]);
				if (!(i == end - 1 && i != start))
					sb.append(spaces);
				if (extranum > 0) {
					sb.append(" ");
					extranum--;
				}
			}
			
			for (int i = sb.toString().length();i<maxWidth;i++) sb.append(" ");
			res.add(sb.toString());
			start = end;
		}
		if (start + 1 == words.length) {
			int[] spaceinfo = getSpacenum(maxWidth, words[start].length(), 1,
					true);
			int spacenum = spaceinfo[0];
			String spaces = createSpace(spacenum);
			StringBuilder sb = new StringBuilder();
			sb.append(words[start]).append(spaces);
			res.add(sb.toString());
		}
		return res;
	}

	private int[] getSpacenum(int maxWidth, int currlen, int wordnum,
			boolean islast) {
		int[] res = new int[2];
		if (wordnum == 1) {
			res[0] = maxWidth - currlen;
			res[1] = 0;
			return res;
		} else {
			if (islast) {
				res[0] = 1;
				res[1] = 0;
			} else {
				res[0] = (maxWidth - currlen) / (wordnum - 1);
				res[1] = (maxWidth - currlen) % (wordnum - 1);
			}
			return res;
		}

	}

	private String createSpace(int spacenum) {
		String res = "";
		for (int i = 0; i < spacenum; i++) {
			res += " ";
		}
		return res;
	}
}