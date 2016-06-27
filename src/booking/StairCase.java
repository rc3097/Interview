package booking;

import java.util.Scanner;

public class StairCase {
    static void StairCase(int n) {
        for (int i=0; i<n; i++) {
            for (int j = 0; j<n-i-1; j++) System.out.print(" ");
            for (int j = 0; j<i+1; j++) System.out.print("#");
            System.out.println();
        }

    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = Integer.parseInt(in.nextLine().trim());
		
		StairCase(n);
	}
}
