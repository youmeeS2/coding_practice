package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW1861정사각형방 {
	
	public static int T, N;
	public static int[][] room;
	public static int s, max;

	public static void search(int x, int y, int count, int start) {
		
		if(x-1>=0) {
			if(room[x][y]+1==room[x-1][y])
				search(x-1,y,count+1, start);
		}
		if(x+1<=N-1) {
			if(room[x][y]+1==room[x+1][y])
				search(x+1,y,count+1, start);
		}
		if(y-1>=0) {
			if(room[x][y]+1==room[x][y-1])
				search(x,y-1,count+1, start);
		}
		if(y+1<=N-1) {
			if(room[x][y]+1==room[x][y+1])
				search(x,y+1,count+1, start);
		}
		
		if(max<count) {
			max=count;
			s=start;
		}
		if(max==count && s>start) {
			s=start;
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		T=sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			N=sc.nextInt();
			
			room=new int[N][N];
			max=0;
			s=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					room[i][j]=sc.nextInt();
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					search(i,j,1,room[i][j]);
				}
			}
			
			System.out.println("#"+t+" "+s+" "+max);
			
			
		}
		

	}
}
