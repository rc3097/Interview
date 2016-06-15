package leetcode;
import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    int idx=0;
    List<List<Integer>> v= new ArrayList<List<Integer>>();
    int k;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v.add(v1);
        v.add(v2);
        k = 2;
    }

    public int next() {
        List<Integer> a = v.get(idx % k);
        while (v.get(idx % k).isEmpty()) {
            a = v.get(idx % k);
            idx++;
        }
        idx++;
        return a.remove(0);
    }

    public boolean hasNext() {
        int bound = idx+k;
        while (v.get(idx % k).isEmpty()) {
            if (bound==idx) return false;
            idx++;
        }
        return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */