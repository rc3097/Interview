package leetcode;



public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
    	if (height.length==0) return 0;
    	int n=height.length;
    	int[][] dp=new int[n][n];
    	
    	for (int i =0; i<n;i++){
    		for (int j = 0; j < dp.length; j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
    	}
    	
    	for (int i = 0; i < dp.length; i++) {
			dp[i][i]=height[i];
		}
    	for (int i = 0; i < dp.length-1; i++) {
			for (int j = i+1; j < dp.length; j++) {
				dp[i][j]=Math.min(dp[j][j], dp[i][j-1]);
			}
		}
    	
    	int max=0;
    	for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length-i; j++) {
				int area=dp[i][i+j]*(j+1);
//				if (area-prevoius<0) break;
//				prevoius=area;
				max=Math.max(max, area);
			}
		}
    	return max; 
    }
}