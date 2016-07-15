package  bloomberg;

import java.util.*;
public class MergeIntervalsParty{
	public class Interval implements Comparable<Interval> {
		int start,end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval o) {
			if (o.start == this.start) {
				return this.end - o.end;
			}
			return this.start - o.end;
		}
	}
	public int findParty(ArrayList<Interval> intervals, int party) {
		Collections.sort(intervals);
		int idx = 1;
		while (idx<intervals.size()) {
			Interval pre = intervals.get(idx-1);
			if (pre.end>=intervals.get(idx).start) {
				pre.end =  intervals.get(idx).end;
				intervals.remove(idx);
				idx--;
			}
			idx++;
		}

		for (int i=1; i<intervals.size();i++) {
			Interval pre = intervals.get(idx-1);
			if (pre.end-intervals.get(i).start>=party) {
				return pre.end;
			}
		}
		return intervals.get(intervals.size()-1).end;
	}
}