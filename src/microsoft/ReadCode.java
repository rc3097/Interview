package microsoft;

/*
 * int question (int x){
 int i=0;
 while (x){
 x=x&(x-1); 
 i++
 }
 return i;
 }
 
 转成 01进制后有多少个1
 */
public class ReadCode {
	public int question(int x) {
		int i = 0;
		while (x!=0) {
			x = x & (x - 1);
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		ReadCode qCode = new ReadCode();
		System.out.println(qCode.question(1));
		System.out.println(qCode.question(2));
		System.out.println(qCode.question(3));
		System.out.println(qCode.question(4));
		System.out.println(qCode.question(8));
	}
}
