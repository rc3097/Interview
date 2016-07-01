package google;
import java.util.*;

public class RearrangeStringkDistanceApart {
	   class CharCount{
	        char ch;
	        int count;
	        public CharCount(char ch, int count) {
	            this.ch = ch;
	            this.count = count;
	        }
	    }
	 public String rearrangeString(String str, int k) {
	            if (k==0) k=1;
	            int[] charcount = new int[26];
		        for (int i =0 ; i<str.length();i++) 
		            charcount[str.charAt(i)-'a']++;
		        
		        PriorityQueue<CharCount> heap = new PriorityQueue<CharCount>(10, new Comparator<CharCount>() {
		          public int compare(CharCount o1, CharCount o2) {
		              if (o1.count==o2.count) return o1.ch-o2.ch;
		              return o2.count - o1.count;
		          }}  
		        );
		        
		        
		        for (int i = 0; i<26;i++) {
		            if (charcount[i]==0) continue;
		            heap.offer(new CharCount((char)(i+'a'), charcount[i]));
		        }
		        
		        String res ="";
		        int len = str.length();
		        while (!heap.isEmpty()) {
		          ArrayList<CharCount> cache = new ArrayList();
		          int cnt = Math.min(k,len);
		          for (int i =0;i<cnt;i++) {
		              if (heap.isEmpty()) return "";
		              CharCount temp = heap.poll();
		              res+=temp.ch;
		              temp.count--;
		              len--;
		              if (temp.count>0) cache.add(temp);
		          }
		          
		          for (CharCount ch: cache) heap.offer(ch);
		        }
		        
		        return res;
		    }
	}