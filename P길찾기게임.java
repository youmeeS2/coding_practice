package coding;

class Solution{
	
	int max_x=0, max_y=0;
	int[][] node=new int[10000][10000];
	int[][] check=new int[10000][10000];
	int[][] answer= {};
	int count=0;
	public void preorder(int x, int miny, int maxy) {
			
		for(int i=x;i>=0;i--) {
			for(int j=miny;j<=maxy;j++) {
				if(node[i][j]!=0 && check[i][j]==1) {
					check[i][j]=2;
					//System.out.print(node[i][j]+" ");
					answer[0][count++]=node[i][j];
					preorder(i-1,miny,j);
					preorder(i-1,j,maxy);
				}
			}
		}
	}
	public void postorder(int x, int miny, int maxy) {
		
		for(int i=x;i>=0;i--) {
			for(int j=miny;j<=maxy;j++) {
				if(node[i][j]!=0 && check[i][j]==2) {
					check[i][j]=0;
					postorder(i-1,miny,j);
					postorder(i-1,j,maxy);
					//System.out.print(node[i][j]+" ");
					answer[1][count++]=node[i][j];
				}
			}
		}

	}
	public int[][] solution(int[][] nodeinfo){
		
		answer=new int[2][nodeinfo.length];		
		
		for(int i=0;i<nodeinfo.length;i++) {
			node[nodeinfo[i][1]][nodeinfo[i][0]]=i+1;
			check[nodeinfo[i][1]][nodeinfo[i][0]]=1;
			if(max_x<nodeinfo[i][1])
				max_x=nodeinfo[i][1];
			if(max_y<nodeinfo[i][0])
				max_y=nodeinfo[i][0];
		}
		
		for(int i=0;i<=max_y;i++) {
			if(node[max_x][i]!=0) {
				preorder(max_x,0,i);
				preorder(max_x,i+1,max_y);
			}
		}
		count=0;
		for(int i=0;i<=max_y;i++) {
			if(node[max_x][i]!=0) {
				postorder(max_x,0,i-1);
				postorder(max_x,i,max_y);
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<nodeinfo.length;j++)
				System.out.print(answer[i][j]+" ");
			System.out.println();
		}
		/*
		for(int i=0;i<=max_x;i++) {
			for(int j=0;j<=max_y;j++)
				System.out.print(node[i][j]+" ");
			System.out.println();
		}*/
		
		/*[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]*/
		return answer;
	}
}
public class P길찾기게임 {

	public static void main(String[] args) {
		
		int[][] nodeinfo= {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		Solution s=new Solution();
		s.solution(nodeinfo);
	}
}
