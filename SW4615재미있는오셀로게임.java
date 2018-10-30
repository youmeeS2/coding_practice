package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class point {
   int x;
   int y;

   point() {

   }

   point(int x, int y) {
      this.x = x;
      this.y = y;
   }
}

public class SW4615재미있는오셀로게임 {

   public static int T, N, Q;
   public static int[][] matrix;
   public static int black, white;
   public static Stack<point> stack;

   public static void check(int x, int y, int c) {

      // 왼쪽
      point p = new point();
      for (int i = y - 1; i >= 0; i--) {
         if (matrix[x][i] == 0) {
            break;
         } else if (matrix[x][i] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x, i));
         }
      }
      stack.clear();

      // 오른쪽
      for (int i = y + 1; i <= N - 1; i++) {
         if (matrix[x][i] == 0) {
            break;
         } else if (matrix[x][i] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x, i));
         }
      }
      stack.clear();

      // 위
      for (int i = x - 1; i >= 0; i--) {
         if (matrix[i][y] == 0) {
            break;
         } else if (matrix[i][y] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(i, y));
         }
      }
      stack.clear();

      // 아래
      for (int i = x + 1; i <= N-1; i++) {
         if (matrix[i][y] == 0) {
            break;
         } else if (matrix[i][y] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(i, y));
         }
      }
      stack.clear();

      // 왼쪽 위
      int temp = 0;
      for (int i = (x < y) ? x-1 : y-1; i >= 0; i--) {
         temp++;
         if (matrix[x - temp][y - temp] == 0) {
            break;
         } else if (matrix[x - temp][y - temp] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x - temp, y - temp));
         }
      }
      stack.clear();

      // 왼쪽 아래
      temp = 0;
      for (int i = 0;; i++) {
         temp++;
         if(x+temp>N-1 || y-temp<0)
            break;
         if (matrix[x + temp][y - temp] == 0) {
            break;
         } else if (matrix[x + temp][y - temp] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x + temp, y - temp));
         }
      }
      stack.clear();

      // 오른쪽 위
      temp = 0;
      for (int i =0;;i++) {
         temp++;
         if(x-temp<0 || y+temp>N-1)
            break;
         if (matrix[x - temp][y + temp] == 0) {
            break;
         } else if (matrix[x - temp][y + temp] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x - temp, y + temp));
         }
      }
      stack.clear();

      // 오른쪽 아래
      temp = 0;
      for (int i = 0;; i++) {
         temp++;
         if(x+temp>N-1 || y+temp>N-1)
            break;
         if (matrix[x + temp][y + temp] == 0) {
            break;
         } else if (matrix[x + temp][y + temp] == c) {
            while (!stack.isEmpty()) {
               p = stack.pop();
               matrix[p.x][p.y] = c;
            }
            matrix[x][y] = c;
            break;
         } else {
            stack.push(new point(x + temp, y + temp));
         }
      }
      stack.clear();

   }

   public static void count() {
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if (matrix[i][j] == 1)
               black++;
            else if (matrix[i][j] == 2)
               white++;
         }
      }
   }

   public static void print() {
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++)
            System.out.print(matrix[i][j] + " ");
         System.out.println();
      }
      System.out.println("****************");
   }

   public static void main(String[] args) throws FileNotFoundException {
      // Scanner sc = new Scanner(System.in);
      Scanner sc = new Scanner(new FileInputStream("input.txt"));

      T = sc.nextInt();

      for (int t = 1; t <= T; t++) {

         N = sc.nextInt();
         Q = sc.nextInt();
         matrix = new int[N][N];

         matrix[N / 2][N / 2] = 2;
         matrix[N / 2 - 1][N / 2 - 1] = 2;
         matrix[N / 2 - 1][N / 2] = 1;
         matrix[N / 2][N / 2 - 1] = 1;

         black = 0;
         white = 0;

         stack = new Stack<point>();

         print();
         for (int i = 0; i < Q; i++) {

            int x, y, c;
            x = sc.nextInt();
            y = sc.nextInt();
            c = sc.nextInt();
            check(y - 1, x - 1, c);
            print();
         }
         count();
         System.out.println("#" + t + " " + black + " " + white);

      }

   }
}