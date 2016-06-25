package booking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/*
http://www.1point3acres.com/bbs/thread-143340-1-1.html
4. Implement a function sort_numerically() that will receive a list of numbers represented in English words 
and return the listed sorted by their numeric value, starting with the largest.

Input:
[
    "seventy five",                                                                                                     
    "two hundred forty one",                                                                                           
    "three thousand",                                                                                          
    "one million thirty five thousand twelve",
    "twenty", 
    "five hundred thousand",
    "two hundred", 
]

Output:

[. from: 1point3acres.com/bbs 
  "one million thirty five thousand twelve", 
  "five hundred thousand"
  "three thousand",
  "two hundred forty one",. 
  "two hundred",.
  "seventy five",. 
  "twenty",
]
*/
public class SortNumerically {
	public HashMap<String, Integer> numMap = new HashMap<>();
	public HashMap<String, Integer> unitMap = new HashMap();
	public SortNumerically () {
		numMap.put("zero",0);
		numMap.put("one",1);
		numMap.put("two",2);
		numMap.put("three",3);
		numMap.put("four",4);
		numMap.put("five",5);
		numMap.put("six",6);
		numMap.put("seven",7);
		numMap.put("eight",8);
		numMap.put("nine",9);
		numMap.put("ten",10);
		numMap.put("eleven",11);
		numMap.put("twelve",12);
		numMap.put("thirteen",13);
		numMap.put("fourteen",14);
		numMap.put("fifteen",15);
		numMap.put("sixteen",16);
		numMap.put("seventeen",17);
		numMap.put("eighteen",18);
		numMap.put("nineteen",19);
		numMap.put("twenty",20);
		numMap.put("thirty",30);
		numMap.put("forty",40);
		numMap.put("fifty",50);
		numMap.put("sixty",60);
		numMap.put("seventy",70);
		numMap.put("eighty",80);
		numMap.put("ninety",90);
		unitMap.put("thousand",1000);
		unitMap.put("million",1000000);
		unitMap.put("billion",1000000000);
	}

	public void sort_numerically(String[] strs) {
		Comparator<String> strComparator = new Comparator<String>()	 {
			public int compare(String o1, String o2) {
				if (str2num(o2)>str2num(o1)) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		str2num("two thousand billion");

		Arrays.sort(strs, strComparator);
		
	}

	public long str2num(String s) {
		String[] nums = s.split(" ");
		long res = 0;
		long unit = 0;
		for (String num:nums) {
			if (num.equals("hundred")) {
				unit = unit * 100;
			} else if (unitMap.containsKey(num)) {
				res = res+unit*unitMap.get(num);
				unit = 0;
			} else if (numMap.containsKey(num)) {
				unit += numMap.get(num);
			}

		}
		res +=unit;
		return res;
	}
	public static void main(String[] args) {
		String[] strs = new String[] { "seventy five","two hundred forty one", "three thousand","one million thirty five thousand twelve",
	 "twenty", "five hundred thousand", "two hundred","two hundred billion"};
	 	SortNumerically  q = new SortNumerically();
	 	q.sort_numerically(strs);
	 	System.out.println(Arrays.deepToString(strs));
	}

}
