package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point{
	int x;
	int y;
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class SW1249���޷� {
	
	public static int T, N;
	public static int[][] arr;
	public static int[][] sum;
	public static Queue<point> queue;

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		T=sc.nextInt();

		for(int t=1;t<=T;t++){
			
			N=sc.nextInt();
			arr=new int[N][N];
			sum=new int[N][N];
			queue=new LinkedList<point>();
			for(int i=0;i<N;i++){
				String s=sc.next();
				for(int j=0;j<N;j++){
					arr[i][j]=Integer.parseInt(s.substring(j, j+1));
					sum[i][j]=9*N*N; //�ִ밪 ����
				}
			}
	
			
			point p=new point(0,0);
			sum[0][0]=0;
			point temp;
			queue.add(p); //���� ��ġ ť�� ����
			while(true){
				
				if(queue.isEmpty()) //ť�� ��������� ����
					break;
				
				p=queue.poll();
				
				/* **���ʱ���**
				 * ���� �� ��ġ���� ���µ� �ɸ� ��� : sum[p.x][p.y]
				 * + �������� ���µ� �ɸ��� ��� : arr[p.x-1][p.y]
				 * ������ �������� ���µ� �ɸ� ��� : sum[p.x-1][p.y]
				 * */
				if(p.x-1>=0 && arr[p.x-1][p.y]+sum[p.x][p.y]<sum[p.x-1][p.y]){
					sum[p.x-1][p.y]=arr[p.x-1][p.y]+sum[p.x][p.y];
					temp=new point(p.x-1,p.y);
					queue.add(temp);
				}
				if(p.y-1>=0 && arr[p.x][p.y-1]+sum[p.x][p.y]<sum[p.x][p.y-1]){
					sum[p.x][p.y-1]=arr[p.x][p.y-1]+sum[p.x][p.y];
					temp=new point(p.x,p.y-1);
					queue.add(temp);
				}
				if(p.x+1<=N-1 && arr[p.x+1][p.y]+sum[p.x][p.y]<sum[p.x+1][p.y]){
					sum[p.x+1][p.y]=arr[p.x+1][p.y]+sum[p.x][p.y];
					temp=new point(p.x+1,p.y);
					queue.add(temp);
				}
				if(p.y+1<=N-1 && arr[p.x][p.y+1]+sum[p.x][p.y]<sum[p.x][p.y+1]){
					sum[p.x][p.y+1]=arr[p.x][p.y+1]+sum[p.x][p.y];
					temp=new point(p.x,p.y+1);
					queue.add(temp);
				}
				
				
			}
			System.out.println("#"+t+" "+sum[N-1][N-1]);

		}

	}

}
