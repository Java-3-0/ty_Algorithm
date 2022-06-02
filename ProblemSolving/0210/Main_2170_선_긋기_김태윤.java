package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 : 335736kb
//시간 : 2824ms

public class Main_2170_선_긋기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

		int x = -1000000001;
		int y = -1000000001;

		int answer = 0;

		for (int i = 0; i < N; i++) {
			if ( x <= arr[i][0] && arr[i][0] <= y) {
				y = Math.max(y, arr[i][1]);
			}else {
				answer += y-x;
				x = arr[i][0];
				y = arr[i][1];
			}
		}
		answer += y-x;
		System.out.println(answer);
	}

}
