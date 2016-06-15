package leetcode;
import java.util.ArrayList;
import java.util.List;


public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp=new ArrayList<Integer>();
        dp.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
        	
        	List<Integer> temp=new ArrayList<Integer>();
        	temp.add(dp.get(0)+triangle.get(i).get(0));
        	
        	for (int j = 1; j < triangle.get(i).size()-1; j++) {
        		temp.add(Math.min(dp.get(j-1), dp.get(j))+triangle.get(i).get(j));
			}
        	
        	temp.add(dp.get(dp.size()-1)+triangle.get(i).get(triangle.get(i).size()-1));
        	dp=temp;
		}
        
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < dp.size(); i++) {
			min=Math.min(min, dp.get(i));
		}
        
        return min;
    }
}