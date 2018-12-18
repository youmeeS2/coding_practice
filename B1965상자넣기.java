package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B1965상자넣기 {
	
	public static int N;
	public static int[] box;
	public static int[] count;
	
	public static int max;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		N=sc.nextInt();
		max=0;
		box=new int[N+1];
		count=new int[N+1];
		
		for(int i=1;i<=N;i++)
			box[i]=sc.nextInt();
		
		for(int i=1;i<=N;i++){
			if(box[i-1]<box[i]){
				count[i]=count[i-1]+1;
			}
			else{
				for(int j=i-1;j>=0;j--){
					if(box[j]<box[i]){
						count[i]=count[j]+1;
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++)
			System.out.print(count[i]+" ");
		for(int i=1;i<=N;i++){
			if(max<count[i])
				max=count[i];
		}
		
		System.out.println(max);
	}

}
