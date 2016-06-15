package leetcode;
import java.util.Arrays;

public class Q274 {
	public static int hIndex(int[] citations) {
		int h = 0;
		if (citations == null)
			return h;
		Arrays.sort(citations);
		for (int i = 0; i <citations.length; i++) {
			if (citations.length - i <= citations[i]) {
				return citations.length - i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}
}