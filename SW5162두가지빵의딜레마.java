package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW5162µÎ°¡Áö»§ÀÇµô·¹¸¶ {
	
	public static int T, A, B, C;
	public static int[] num;
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		//Scanner sc=new Scanner(System.in);
		
		T=sc.nextInt();
		
		for(int t=1;t<=T;t++){
			
			A=sc.nextInt();
			B=sc.nextInt();
			C=sc.nextInt();
			
			if(A>B){
				int temp=A;
				A=B;
				B=temp;
			}
			int max=0;
			
			int range=C/A;
			num=new int[range+1];
			
			for(int i=0;i<=range;i++){
				num[i]=(C-(i*A))/B;
				if(max<num[i]+i)
					max=num[i]+i;
			}
			System.out.println("#"+t+" "+max);
			
		}
		
	}

}
