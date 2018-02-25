package leetcode;

public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int originRow = nums.length;
        int originCol = nums[0].length;
        if (r * c != originRow * originCol) return nums;
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i<originRow; i++) {
            for (int j = 0; j< originCol; j++) {
                int currentRow = index / c;
                int currentCol = index % c;
                res[ currentRow][currentCol] = nums[i][j];
                index++;
            }
        }
        return res;
    }
}