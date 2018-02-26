package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : -o1[1] + o2[1];
            }
        });

        int line1 = distSquare(points[0], points[1]);
        int line2 = distSquare(points[1], points[3]);
        int line3 = distSquare(points[2], points[3]);
        int line4 = distSquare(points[0], points[2]);

        int line5 = distSquare(points[0], points[3]);
        int line6 = distSquare(points[1], points[2]);

        return (line1 != 0 && line1 == line2 && line2 == line3 && line3 == line4) && (line5
                == line6);

    }

    private int distSquare(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        boolean b = new ValidSquare().validSquare(new int[]{1, 1}, new int[]{5, 3}, new int[]{3, 5},
                new int[]{5, 7});
        System.out.println(b);
    }
}
