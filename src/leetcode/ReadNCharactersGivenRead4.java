package leetcode;

public class ReadNCharactersGivenRead4 extends Reader4{
    public int read(char[] buf, int n) {
        int start=0;
        char[] buff4= new char[4];
        int len=0;
        while ((len=read4(buff4))!=0) {
            for (int i=0;i<len;i++) {
                buf[i+start] =  buff4[i];
            }
            start+=len;
        }
        return start;
    }
}