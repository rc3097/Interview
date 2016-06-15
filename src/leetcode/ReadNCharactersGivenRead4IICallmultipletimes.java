package leetcode;

public class ReadNCharactersGivenRead4IICallmultipletimes extends Reader4 {
    char[] buff4 = new char[4];
    int buff4len=0;
    public int read(char[] buff, int n) {
        int start =0;
        if (buff4len!=0) {
            for (int i=4-buff4len;i<4 && start<n;i++) {
                buff[start] = buff4[i];
                start++;
            }
            buff4len=buff4len - start;
            if (buff4len!=0) return start;
        }
        while ((buff4len=read4(buff4))>0 && n>start) {
            for (int i=0;i<buff4len && n>start+i;i++) {
                buff[i+start] =  buff4[i];
            }
            start+=buff4len;
        }
        buff4len = (start>n)?start-n:0;
        return (start>n)?n:start;
    }
}