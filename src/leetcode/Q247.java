package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Q247 {
	private List<String> results= new ArrayList<String>();
	private boolean odds = true;
	 public List<String> findStrobogrammatic(int n) {
		 char[][] dict= {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

		 if (n%2!=0) {
			 odds=false;
		 }
		 return null;
	 }
	 
	 private void dfs(String result, int index) {
		 
	 }
}
