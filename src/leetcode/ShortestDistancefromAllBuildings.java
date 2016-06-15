package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortestDistancefromAllBuildings {
	   private class Building {
	        int x,y;
	        public int[][] dist;
	        public Building(int x,int y, int n, int m) {
	            this.x = x;
	            this.y =y;
	            dist = new int[n][m];
	            Arrays.fill(dist, 1000);
	            dist[x][y]=0;
	        }
	    }
	    int[] dx=new int[]{-1,1,0,0};
	    int[] dy=new int[]{0,0,-1,1};
	    int n,m;
	    public int shortestDistance(int[][] grid) {
	        this.n = grid.length;
	        if (n==0) return 0;
	        this.m = grid[0].length;
	        if (m==0) return 0;
	        ArrayList<Building> buildings = new ArrayList<Building>();
	        for (int i =0; i<n;i++) {
	            for (int j =0;j<m;j++) {
	                if (grid[i][j]==1) {
	                    Building building = new Building(i,j,n,m);
	                    bfs(building, grid);
	                    buildings.add(building);
	                }
	            }
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for (int i =0; i<n; i++) {
	            for (int j=0;j<m;j++) {
	                int temp =0;
	                for (Building building: buildings) {
	                    temp+=building.dist[i][j];
	                }
	                if (temp!=0) {
	                    min = Math.min(min, temp);
	                }
	            }
	        }
	        return min;
	    }
	    
	    private void bfs(Building building, int[][] grid) {
	        Queue<Integer> queue = new LinkedList<Integer>();
	        queue.add(getidx(building.x,building.y));
	        while (!queue.isEmpty()) {
	            int pointidx = queue.poll();
	            int x = pointidx / m;
	            int y = pointidx % m;
	            int step = building.dist[x][y];
	            for (int i =0; i<4;i++) {
	                int nx = x+dx[i];
	                int ny = y+dy[i];
	                if (nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==0 &&building.dist[nx][ny]==Integer.MAX_VALUE) {
	                    building.dist[nx][ny] = step+1;
	                    queue.add(getidx(nx,ny));
	                }
	            }
	        }
	    }
	    
	    private int getidx(int x, int y) {
	        return x*m+y;
	    }
	}