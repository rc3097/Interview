package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Valid_Anagram {
	public int sumChar(String s){
	    int sum=0;
	    for(int i=0;i<s.length();i++){
	        int temp=s.charAt(i);
	        sum=sum+temp;
	    }
	    return sum;
	}
	public boolean isAnagram(String s,String t){
	    HashSet<Character> aa=new HashSet<Character>();
	    HashSet<Character> bb=new HashSet<Character>();
	    char[] ss=s.toCharArray();
	    char[] tt=t.toCharArray();
	    if(ss.length!=tt.length){
	        return false;
	    }
	    if(sumChar(s)!=sumChar(t)){
	        return false;
	    }
	    for(int i=0;i<ss.length;i++){
	        aa.add(ss[i]);
	        bb.add(tt[i]);
	    }
	    for(int i=0;i<tt.length;i++){
	        if(aa.contains(tt[i])){
	            aa.remove(tt[i]);
	            bb.remove(tt[i]);
	        }else{
	            continue;
	        }
	    }
	    if(aa.size()==0&&bb.size()==0){
	        return true;
	    }
	    return false;
	}
}