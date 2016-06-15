package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> resultList = new ArrayList<String>();
		if (num.length()==0) return resultList;

		if (num.charAt(0) == '0') {
			createList(resultList, num.substring(1), 0, 0, target,num.substring(0, 1));
		} else {
			for (int i = 1; i <= num.length(); i++) {
				long prenum = Long.valueOf(num.substring(0, i));
				createList(resultList, num.substring(i), prenum, prenum, target,num.substring(0,i));
			}
		}
		return resultList;

	}

	private void createList(List<String> resultList, String string,
			long prenum, long curres, int target, String result) {
		// TODO Auto-generated method stub
		if (target == curres && string.length() == 0) {
			resultList.add(result);
			return;
		}
		if (string.length() == 0) {
			return;
		}
		if (string.charAt(0) == '0') {
			String curstr = string.substring(0, 1);
			createList(resultList, string.substring(1), 0, curres, target,
					result + "+" + curstr);
			createList(resultList, string.substring(1), 0, curres, target,
					result + "-" + curstr);
			createList(resultList, string.substring(1), 0, curres - prenum,
					target, result + "*" + curstr);
		} else {
			for (int i = 1; i <= string.length(); i++) {
				String curstr = string.substring(0, i);
				long currNum = Long.valueOf(curstr);
				createList(resultList, string.substring(i), currNum, curres
						+ currNum, target, result+"+"+curstr);
				createList(resultList, string.substring(i), -currNum, curres
						- currNum, target, result+"-"+curstr);
				createList(resultList, string.substring(i), prenum * currNum,
						curres - prenum + prenum * currNum, target, result+"*"+curstr);
			}
		}
	}
}