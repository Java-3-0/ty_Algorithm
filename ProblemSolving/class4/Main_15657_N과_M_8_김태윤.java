package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15657_N과_M_8_김태윤 {

	static int N, M;
	static int[] arr;
	static int[] num;
	static boolean isChecked[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N];
		isChecked = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);

		arr = new int[M];

		dfs(0, 0);
	}

	static void dfs(int cur_cnt, int cur_idx) {
		if (cur_cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = cur_idx; i < N; i++) {
			arr[cur_cnt] = num[i];
			dfs(cur_cnt + 1, i);
		}
	}
}
