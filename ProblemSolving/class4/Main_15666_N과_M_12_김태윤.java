package class4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_15666_N과_M_12_김태윤 {
	
	static int N, M;
	static int[] arr;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < N; i++)
			set.add(sc.nextInt());

		num = new int[set.size()];
		
		int i = 0;
		for(int t : set)
			num[i++] = t;
		
		
		Arrays.sort(num);

		arr = new int[M];

		dfs(0, 0, i);
	}

	static void dfs(int cur_cnt, int cur_idx, int max_cnt) {
		if (cur_cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = cur_idx; i < max_cnt; i++) {
				arr[cur_cnt] = num[i];
				dfs(cur_cnt + 1, i, max_cnt);
		}
	}

}
