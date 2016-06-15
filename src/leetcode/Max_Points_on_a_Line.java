package leetcode;
import java.util.HashMap;
import java.util.Iterator;

public class Max_Points_on_a_Line {

	public int maxPoints(Point[] points) {
		if (points.length <= 2)
			return points.length;
		// y=ax+b
		double[][] a = new double[points.length][points.length];
		int[] horizon = new int[points.length];
		for (int i = 0; i < horizon.length; i++) {
			horizon[i] = 1;
		}
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			HashMap<Double, Integer> countHashMap = new HashMap<Double, Integer>();
			int repeat = 0;
			int parral = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						repeat++;
						horizon[i]++;
						if (max < horizon[i])
							max = horizon[i];
					} else {
						horizon[i]++;
						horizon[j]++;
						if (max < horizon[i])
							max = horizon[i];
					}
				} else {
					double result = (points[i].y - points[j].y) * 1.0
							/ (points[i].x - points[j].x);
					a[i][j] = result;
					if (Math.abs(result) == 0) {
						parral++;
					} else {
						if (countHashMap.containsKey(result)) {
							countHashMap.put(result,
									countHashMap.get(result) + 1);
						} else {
							countHashMap.put(result, 2);
						}
					}
				}
			}
			if (parral > max)
				max = parral;
			Iterator<Double> iterator = countHashMap.keySet().iterator();
			while (iterator.hasNext()) {
				double next = iterator.next();
				if (max < repeat + countHashMap.get(next)) {
					max = repeat + countHashMap.get(next);
				}
			}
		}

		return max;
	}
}
