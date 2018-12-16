package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SW4050재관이의대량할인 {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int T, N;
		
		T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			N=sc.nextInt();
			ArrayList<Integer> array=new ArrayList<Integer>();
			
			int sum=0;
			
			for(int i=0;i<N;i++) {
				array.add(sc.nextInt());
				sum+=array.get(i);
			}
			Collections.sort(array);
			
			for(int i=N-1;i>=0;) {
				if(i-2>=0)
					sum-=array.get(i-2);
				i-=3;
			}
			
			System.out.println("#"+t+" "+sum);
			
		}
	}
}
