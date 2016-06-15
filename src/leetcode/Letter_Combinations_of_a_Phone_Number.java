package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Letter_Combinations_of_a_Phone_Number {
	private HashMap<Character, String[]> keypad;
    public List<String> letterCombinations(String digits) {
    	if (digits.contains("0") || digits.contains("1") || digits.length()==0) {
    			return new ArrayList<String>();
    	}
        keypad = new HashMap<Character, String[]>();

        keypad.put('2', new String[]{"a","b","c"});
        keypad.put('3', new String[]{"d","e","f"});
        keypad.put('4', new String[]{"g","h","i"});
        keypad.put('5', new String[]{"j","k","l"});
        keypad.put('6', new String[]{"m","n","o"});
        keypad.put('7', new String[]{"p","q","r","s"});
        keypad.put('8', new String[]{"t","u","v"});
        keypad.put('9', new String[]{"w","x","y","z"});
        List<String> results = new ArrayList<String>();
        creatallstring(digits, 0, results, "");
        return results;
    }
    
    private void creatallstring(String digits,int index,List<String> results,String current) {
		if (digits.length()==index) {
			results.add(current);
		} else {
			String[] sets = keypad.get(digits.charAt(index));
			for (int i = 0; i < sets.length; i++) {
				creatallstring(digits, index+1, results, current+sets[i]);
			}
		}
	}
}