package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B14501น้มุ {

	public static int N;
	public static int[][] schedule;
	public static int[] benefit;

	public static int dp(int x){
		
		if(x+schedule[0][x]>N)
			return 0;
		return Math.max(benefit[x+1], schedule[1][x]+benefit[schedule[0][x]+x]);
		
	}
	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		N = sc.nextInt();
		schedule = new int[2][N];
		benefit = new int[N+1];


		for (int i = 0; i < N; i++) {
			schedule[0][i] = sc.nextInt();
			schedule[1][i] = sc.nextInt();
		}

		
		for(int i=N-1;i>=0;i--){
			benefit[i]=dp(i);
		}
		
		System.out.println(benefit[0]);

	}
}
