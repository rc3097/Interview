package booking;

import java.util.Scanner;

public class Polygons {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		String line;
		int square = 0;
		int rect = 0;
		int poly = 0;
		while (in.hasNextLine()) {
			line = in.nextLine();
			int[] nums = new int[4];
			if (line.split(" ").length != 4) {
				poly++;
				continue;
			}

			String[] snum = line.split(" ");
			if (Integer.valueOf(snum[0]) <= 0 || Integer.valueOf(snum[1]) <= 0
					|| Integer.valueOf(snum[2]) <= 0
					|| Integer.valueOf(snum[3]) <= 0) {
				poly++;
				continue;
			}

			if (snum[0].equals(snum[1]) && snum[1].equals(snum[2])
					&& snum[2].equals(snum[3])) {
				square++;
				continue;
			}
			if (snum[0].equals(snum[2]) && snum[1].equals(snum[3])) {
				rect++;
				continue;
			}
			poly++;
		}

		System.out.println(square + " " + rect + " " + poly);
	}
}
