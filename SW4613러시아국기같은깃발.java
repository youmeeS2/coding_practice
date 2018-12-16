package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW4613러시아국기같은깃발 {
   
   public static int T, N, M;
   public static String[][] matrix;
   public static int min;
   
   public static void check(int n, String color, int count){
      
      if(n==N-1 && color!="R")
         return;
      
      int c=0;
      for(int i=0;i<M;i++){
         if(!matrix[n][i].equals((String)color))
            c++;
      }
      if(n==N-1 && color=="R"){
         if(min>c+count)
            min=c+count;
         return;
      }
      
      if(color=="W"){
         check(n+1,"W",c+count);
         check(n+1,"B",c+count);
      }
      else if(color=="B"){
         check(n+1,"B",c+count);
         check(n+1,"R",c+count);
      }
      else
         check(n+1,"R",c+count);
   }
   public static void main(String[] args) throws FileNotFoundException{
      
      //Scanner sc = new Scanner(System.in);
      Scanner sc = new Scanner(new FileInputStream("input.txt"));
      
      T=sc.nextInt();
      
      for(int t=1;t<=T;t++){
         N=sc.nextInt();
         M=sc.nextInt();
         matrix=new String[N][M];
         min=N*M;
         
         for(int i=0;i<N;i++){
            String s=sc.next();
            for(int j=0;j<M;j++){
               matrix[i][j]=s.substring(j,j+1);
            }
         }

         check(0,"W",0);
         System.out.println("#"+t+" "+min);
      }
      
   }

}