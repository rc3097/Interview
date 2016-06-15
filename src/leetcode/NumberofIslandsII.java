package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
    int m,n;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        this.m =m; this.n =n ;
        List<Integer> res = new ArrayList<Integer>();
        int[] id = new int[m*n];
        Arrays.fill(id,-1);
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int count = 0;
        for (int[] pos: positions) {
            int x = pos[0];
            int y = pos[1];
            int ipos = getidx(x,y);
            count++;
            id[ipos]=ipos;
            
            for (int i= 0; i<4; i++) {
                int adjx = x + dx[i];
                int adjy = y + dy[i];
                if (adjx<0 || adjx>=m) continue;
                if (adjy<0 || adjy>=n) continue;
                int iadj = getidx(adjx,adjy);
                if (id[iadj]!=-1) {
                    int root = root(id,iadj);
                    if (root!=id[ipos]) {
                        count--;
                        id[root]= ipos; 
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private int root(int[] id, int i) {
        while (id[i]!=i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    private int getidx(int x, int y) {
        return x*n+y;
    }
    
}