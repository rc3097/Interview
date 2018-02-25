package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by runpeng.chen on 5/18/17.
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> pidMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            int ppidNum = ppid.get(i);
            List<Integer> childList = (pidMap.containsKey(ppidNum)) ? pidMap.get(ppidNum) : new ArrayList<Integer>();
            childList.add(pid.get(i));
            pidMap.put(ppidNum, childList);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int killPid = queue.poll();
            res.add(killPid);
            if (pidMap.get(killPid)==null) continue;;
            for (int child : pidMap.get(killPid)) {
                queue.add(child);
            }
        }
        return res;
    }

}
