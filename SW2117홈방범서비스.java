package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class matrix {
	int x;
	int y;
	int k;
}

public class SW2117홈방범서비스 {

	static int T, N, M;
	static int[][] home;
	static int[][] check;
	static int home_count = 0;
	static int max_k;
	static Queue<matrix> home_queue = new LinkedList<matrix>();
	static Queue<matrix> check_queue = new LinkedList<matrix>();

	public static void make_k(int x, int y) {


		matrix m = new matrix();
		m.x = x;
		m.y = y;
		m.k = 1;
		max_k = 0;
		check_queue.add(m);

		matrix temp;
		while (true) {
			if (check_queue.isEmpty())
				break;
			m = check_queue.poll();

			if (max_k < m.k)
				max_k = m.k;

			if (check[m.x][m.y] == 0) {
				check[m.x][m.y] = m.k;

				if (m.x > 0) {
					temp = new matrix();
					temp.x = m.x - 1;
					temp.y = m.y;
					temp.k = m.k + 1;
					check_queue.add(temp);
				}
				if (m.x < N - 1) {
					temp = new matrix();
					temp.x = m.x + 1;
					temp.y = m.y;
					temp.k = m.k + 1;
					check_queue.add(temp);
				}
				if (m.y > 0) {
					temp = new matrix();
					temp.x = m.x;
					temp.y = m.y - 1;
					temp.k = m.k + 1;
					check_queue.add(temp);
				}
				if (m.y < N - 1) {
					temp = new matrix();
					temp.x = m.x;
					temp.y = m.y + 1;
					temp.k = m.k + 1;
					check_queue.add(temp);
				}
			}
		}

	}

	public static int check_home(int k) {

		int count = 0;
		for (int i = 0; i < home_count; i++) {
			matrix temp = new matrix();
			temp = home_queue.poll();
			if (check[temp.x][temp.y] <= k)
				count++;

			home_queue.add(temp);
		}
		return count;

	}

	public static void delete_check() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				check[i][j] = 0;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			M = sc.nextInt();
			home = new int[N][N];

			home_queue.clear();
			home_count=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					home[i][j] = sc.nextInt();
					if (home[i][j] == 1) {
						matrix temp = new matrix();
						temp.x = i;
						temp.y = j;
						home_queue.add(temp);
						home_count++;
					}
				}
			}

			int max_count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check = new int[N][N];
					make_k(i, j);
					for (int c = 1; c <= max_k; c++) {
						int count = check_home(c);
						if ((count * M)-(c * c + (c - 1) * (c - 1))>= 0 && max_count < count) {
							max_count = count;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max_count);


		}
	}
}