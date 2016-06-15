package leetcode;
import java.util.ArrayList;
import java.util.HashSet;

public class Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator1, int denominator1) {
		boolean negativevalue = false;
		long denominator = (long) denominator1;
		long numerator = (long) numerator1;
		if (denominator < 0) {
			negativevalue = true;
			denominator = -denominator;
		}
		if (numerator < 0) {
			numerator = -numerator;
			negativevalue = !negativevalue;
		}
		HashSet<Long> remainder = new HashSet<Long>();
		ArrayList<Long> remainderArrayList= new ArrayList<Long>();
		String resultString = "";
		String resultString2 = "";
		remainder.add((long) 0);
		long result = numerator / denominator;
		long temp = numerator % denominator;
		resultString2 = String.valueOf(result);
		if (negativevalue)
			resultString2 = "-" + resultString2;
		while (!remainder.contains(temp)) {
			remainder.add(temp);
			remainderArrayList.add(temp);
			numerator = temp * 10;
			result = numerator / denominator;
			temp = numerator % denominator;
			resultString += String.valueOf(result);
		}
		if (temp == 0) {
			if (resultString.equals(""))
				return String.valueOf(Long.valueOf(resultString2));
			return resultString2 + "." + resultString;
		}
		int begin = resultString.length() - 1;
		for (int i = resultString.length() - 1; i >= 0; i--) {
			if (remainderArrayList.get(i) == temp) {
				begin = i;
				break;
			}
		}
		return (resultString2 + "." + resultString.substring(0, begin) + "("
				+ resultString.substring(begin) + ")");
	}
}