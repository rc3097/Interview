package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        List<String> result = new ArrayList<String>();
        Set<String> visited = new HashSet();
        boolean hasvalid = false;
        queue.add(s);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (checkvalid(current)) {
                result.add(current);
                hasvalid = true;
            }
            if (!hasvalid) {
                for (int i = 0; i<current.length(); i++) {
                    if (current.charAt(i)=='(' || current.charAt(i)==')') {
                        String newstr = current.substring(0,i)+current.substring(i+1,current.length());
                        System.out.println(newstr);
                        if (!visited.contains(newstr)) {
                            queue.add(newstr);
                            visited.add(newstr);
                        }
                    }
                } 
            }
        }
        return result;
        
    }
    private boolean checkvalid(String s) {
        int bracket =0;
        for (int i=0; i<s.length();i++) {
            if (s.charAt(i)=='(') {
                bracket++;
            } else if (s.charAt(i)==')'){
                bracket--;
            }
            if (bracket<0) {
                return false;
            }
        }
        if (bracket!=0) return false;
        return true;
    }
    
}