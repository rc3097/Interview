package leetcode;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder mainString = new StringBuilder(A);
        int i=1;
        for(; mainString.length() < (B.length() + 2 * A.length()); i++ ){
            if( mainString.toString().contains(B)){
                return i;
            }else{
                mainString.append( A );
            }
        }

        return -1;
    }
}