package leetcode;

public class SmallestRectangleEnclosingBlackPixels {
	   public int minArea(char[][] image, int x, int y) {
	        int n = image.length;
	        int m = image[0].length;
	        int top = rbinarysearch(0,x,image, true);
	        int bottom = lbinarysearch(x,n,image, true);
	        int left = rbinarysearch(0,y,image,false);
	        int right = rbinarysearch(y,m,image, false);
	        int res = 0;
	        return (bottom-top+1)*(right-left+1);
	    }
	    
	    private int lbinarysearch(int start, int end ,char[][] image, boolean horizontal) {
	        int l = start;
	        int r = end-1;
	        while (l<=r) {
	            int mid = (l+r)/2;
	            if (horizontal && hhasblack(image, mid) || 
	                (!horizontal && vhasblack(image,mid) )) {
	                l = mid+1;
	            } else {
	                r = mid-1;
	            }
	        }
	        return r;
	    }
	    
	    private int rbinarysearch(int start, int end ,char[][] image, boolean horizontal) {
	        int l = start;
	        int r = end-1;
	        while (l<=r) {
	            int mid = (l+r)/2;
	            if (horizontal && hhasblack(image, mid) || 
	                (!horizontal && vhasblack(image,mid) )) {
	                r = mid-1;
	            } else {
	                l = mid+1;
	            }
	        }
	        return l;
	    }
	    private boolean hhasblack(char[][] image,int row) {
	        for (int i = 0; i<image[0].length;i++) {
	            if (image[row][i]=='1') return true; 
	        }
	        return false;
	    }
	    private boolean vhasblack(char[][] image, int col) {
	        for (int i = 0; i<image.length;i++) {
	            if (image[i][col]=='1') return true; 
	        }
	        return false;
	    }
	}