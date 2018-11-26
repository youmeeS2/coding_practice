package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class SW2819격자판의숫자이어붙이기 {

	public static int T;
	public static String[][] matrix;
	public static HashSet<String> hs;
	
	public static void make_number(int x, int y, String s){
		
		if(s.length()==7){
			hs.add(s);
			return;
		}
		if(y<3){ //동
			make_number(x,y+1,s+matrix[x][y+1]);
		}
		if(y>0){ //서
			make_number(x,y-1,s+matrix[x][y-1]);
		}
		if(x<3){ //남
			make_number(x+1,y,s+matrix[x+1][y]);
		}
		if(x>0){ //북
			make_number(x-1,y,s+matrix[x-1][y]);
		}
		
		
	}
	public static void main(String[] args) throws FileNotFoundException{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		T=sc.nextInt();

		int temp;
		for(int t=1;t<=T;t++){
			matrix=new String[4][4];
			hs=new HashSet<String>();
			
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					temp=sc.nextInt();
					matrix[i][j]=Integer.toString(temp);
				}
			}
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					make_number(i,j,matrix[i][j]);
				}
			}
			
			System.out.println("#"+t+" "+hs.size());
		}
	}
}
