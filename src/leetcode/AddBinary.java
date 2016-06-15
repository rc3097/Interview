package leetcode;
import java.util.ArrayList;


public class AddBinary {
    public String addBinary(String a, String b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i =0;
        while (i<a.length() || i<b.length()) {
            int ia = a.length()-i-1;
            int ib = b.length()-i-1;
            int apos = ia<a.length()?a.charAt(ia)-'0':0;
            int bpos = ib<b.length()?b.charAt(ib)-'0':0;
            res.add(apos+bpos);
            i++;
        }
        
        for (i=0;i<res.size()-1;i++) {
            res.set(i+1,res.get(i+1)+res.get(i)/2);
            res.set(i, res.get(i) % 2);
        }
        
        if (res.get(res.size()-1)>1) {
            res.add(res.get(res.size()-1)/2);
            res.set(res.size()-2,res.get(res.size()-2)%2);
        }
        
        String ress = "";
        for (int num: res) {
            ress = num+ress;
        }
        return ress;
    }
}
