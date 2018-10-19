package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SW4740밍이의블록게임 {

	static int T, N, M, Q;
	static String[][] block;
	static int max=0;
	static int count=1;
	static int[][] color_count;

	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(block[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void L() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!block[i][j].equals((String)"#")) {
					for(int k=0;k<j;k++) {
						if(block[i][k].equals((String)"#")) {
							String temp=block[i][j];
							block[i][j]=block[i][k];
							block[i][k]=temp;
							break;
						}
					}
				}
			}
		}
	}
	public static void R() {
		
		for(int i=0;i<N;i++) {
			for(int j=M-1;j>=0;j--) {
				if(!block[i][j].equals((String)"#")) {
					for(int k=M-1;k>j;k--) {
						if(block[i][k].equals((String)"#")) {
							String temp=block[i][j];
							block[i][j]=block[i][k];
							block[i][k]=temp;
							break;
						}
					}
				}
			}
		}
	}
	public static void U(String s) {
		
		for(int i=0;i<M;i++) {
			if(!block[0][i].equals((String)"#"))
			return;
		}
		String[][] temp=new String[N][M];
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++)
				temp[i-1][j]=block[i][j];
		}
		for(int i=0;i<M;i++)
			temp[N-1][i]=s.substring(i, i+1);
		
		block=temp;
		for(int i=0;i<M;i++) {
			if(block[N-1][i].equals((String)"#"))
				Down(N-1,i);
		}
	
		
	}
	
	private static void Down(int x, int number) {
		
		for(int i=x;i>0;i--) {
			String temp=block[i][number];
			block[i][number]=block[i-1][number];
			block[i-1][number]=temp;
		}
	}
	
	public static void D() {
		
		max=1;
		color_count=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!block[i][j].equals((String)"#")&&color_count[i][j]==0){
					count=1;
					dfs(i,j);
				}
			}
		}		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(color_count[i][j]==max)
					delete(i,j,block[i][j]);
			}
		}
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M;j++) {
				if(!block[i][j].equals((String)"#") && block[i+1][j].equals((String)"#"))
					Down(i+1,j);
			}
		}

	}
	
	private static void dfs(int x, int y) {
		
		if(max<count)
			max=count;
		
		color_count[x][y]=count;
		
		if(x>0) {
			if(block[x][y].equals((String)block[x-1][y]) && color_count[x-1][y]==0) {
				count++;
				dfs(x-1,y);
			}
		}
		if(x<N-1) {
			if(block[x][y].equals((String)block[x+1][y]) && color_count[x+1][y]==0) {
				count++;
				dfs(x+1,y);
			}
		}
		if(y>0) {
			if(block[x][y].equals((String)block[x][y-1]) && color_count[x][y-1]==0) {
				count++;
				dfs(x,y-1);
			}
		}
		if(y<M-1) {
			if(block[x][y].equals((String)block[x][y+1]) && color_count[x][y+1]==0) {
				count++;
				dfs(x,y+1);
			}
		}
			
	}
	private static void delete(int x, int y, String color) {
		
		block[x][y]="#";
		
		if(x>0) {
			if(block[x-1][y].equals((String)color))
				delete(x-1,y, color);
		}
		if(x<N-1) {
			if(block[x+1][y].equals((String)color))
				delete(x+1,y, color);
		}
		if(y>0) {
			if(block[x][y-1].equals((String)color))
				delete(x,y-1, color);
		}
		if(y<M-1) {
			if(block[x][y+1].equals((String)color))
				delete(x,y+1, color);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			M = sc.nextInt();
			Q = sc.nextInt();
			
			block=new String[N][M];
			
			for(int i=0;i<N;i++) {
				String s=sc.next();
				for(int j=0;j<M;j++) {
					block[i][j]=s.substring(j, j+1);
				}
			}

			for(int i=0;i<N-1;i++) {
				for(int j=0;j<M;j++) {
					if(!block[i][j].equals((String)"#") && block[i+1][j].equals((String)"#"))
						Down(i+1,j);
				}
			}

			for(int i=0;i<Q;i++) {
				String s=sc.next();
				if(s.equals((String)"L"))
					L();
				else if(s.equals((String)"R"))
					R();
				else if(s.equals((String)"D"))
					D();
				else if(s.equals((String)"U")) {
					U(sc.next());
				}
			}
			
			System.out.println("#"+t);
			print();
			System.out.println();

		}
	}
}
