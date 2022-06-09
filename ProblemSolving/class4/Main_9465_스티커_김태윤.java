package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 123564kb
//시간 : 928ms

public class Main_9465_스티커_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[1][i] = Integer.parseInt(st.nextToken());
			}

			if (n >= 2) {
				arr[0][1] += arr[1][0];
				arr[1][1] += arr[0][0];
			}

			for (int i = 2; i < n; i++) {
				arr[0][i] += Math.max(arr[1][i - 1], Math.max(arr[0][i - 2], arr[1][i - 2]));
				arr[1][i] += Math.max(arr[0][i - 1], Math.max(arr[0][i - 2], arr[1][i - 2]));
			}

			System.out.println(Math.max(arr[0][n - 1], arr[1][n - 1]));

		}

	}

}
