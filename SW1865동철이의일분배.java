package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SW1865동철이의일분배 {

	public static int T, N;
	public static double[][] work;
	public static double max=0;

	private static void dfs(int person, double result, boolean[] visit) {
					
		
		if(person==N) {
			if(max <result)
				max=result;
			/*
			 * 마지막 사람까지 확인했으면 max와 비교
			 * */
		}
		if(result==0)
			return; /* 값이 0 이면 계속 곱해도 0 이므로 중단하기 */
		
		if(result<max)
			return; /* result는 소수이므로 계속 곱해도 작아짐
			 		   그래서 중간결과가 max보다 작으면(더 계산해도 커질 경우 X) 중단하기*/
		
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;	
				dfs(person+1, result*work[person][i], visit);
				visit[i]=false;
				/* 방문표시하고 다음사람 검사하기 */
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		T = sc.nextInt(); 
		boolean[] visit;

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			work = new double[N][N];
			visit = new boolean[N];
			max=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					work[i][j]=sc.nextDouble()/100;
				}
			}
			
			dfs(0,1,visit);
			
			DecimalFormat df=new DecimalFormat("#.000000");
			System.out.println("#"+t+" "+df.format(max*100));
		}

	}
}
