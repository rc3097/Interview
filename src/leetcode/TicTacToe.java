package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TicTacToe {
	List<HashSet<Integer>> winpattern = new ArrayList<HashSet<Integer>>();

	public TicTacToe() {
		generatewin(winpattern, 0, 1, 2);
		generatewin(winpattern, 3, 4, 5);
		generatewin(winpattern, 6, 7, 8);
		generatewin(winpattern, 0, 3, 6);
		generatewin(winpattern, 1, 4, 7);
		generatewin(winpattern, 2, 5, 8);
		generatewin(winpattern, 0, 4, 8);
		generatewin(winpattern, 2, 4, 6);
	}

	public void generatewin(List<HashSet<Integer>> winpattern, int o1, int o2,
			int o3) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(o1);
		set.add(o2);
		set.add(o3);
		winpattern.add(set);
	}

	private boolean checkVaild(char[][] map) {
		HashSet<Integer> playerSet1 = converttonum(map, 'O');
		HashSet<Integer> playerSet2 = converttonum(map, 'X');
		if (playerSet1.size()>playerSet2.size()) {
			return false;
		}
		return true;
		
	}
	
	private HashSet<Integer> converttonum(char[][] map, char player) {
		HashSet<Integer> set= new HashSet<Integer>();
		for (int i =0 ; i<3;i++) {
			for (int j =0; j<3;j++) {
				if (player==map[i][j]) {
					set.add(i*3+j);
				}
			}
		}
		return set;
	}
}
