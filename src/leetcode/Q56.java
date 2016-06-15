package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0)
			return new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.start, o2.start);
			}
		});

		List<Interval> results = new ArrayList<Interval>();
		results.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval newinterval = intervals.get(i);
			Interval lastinterval = results.get(results.size() - 1);
			if (newinterval.start <= lastinterval.end) {
				lastinterval.end = Integer.max(lastinterval.end,
						newinterval.end);
			} else {
				results.add(newinterval);
			}
		}
		return results;
	}
}
