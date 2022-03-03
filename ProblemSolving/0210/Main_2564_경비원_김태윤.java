package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 11600kb
//시간 : 80ms

public class Main_2564_경비원_김태윤 {
	static int R, C, N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());

		int[][] store = new int[N][2];

		for (int i = 0; i < N; i++) {

			str = new StringTokenizer(br.readLine());

			store[i][0] = Integer.parseInt(str.nextToken());
			store[i][1] = Integer.parseInt(str.nextToken());
		}

		str = new StringTokenizer(br.readLine());

		int[] dg = new int[2];

		dg[0] = Integer.parseInt(str.nextToken());
		dg[1] = Integer.parseInt(str.nextToken());
		
		/**
		 * 1북 2남 3서 4동
		 */
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (dg[0] == 1) { //동근 = 북
				if (store[i][0] == 1) { //북
					answer += Math.abs(store[i][1] - dg[1]);
				} else if (store[i][0] == 2) {//남
					answer += Math.min(C + store[i][1] + dg[1], 2 * (R + C) - (C + store[i][1] + dg[1]));
				} else if (store[i][0] == 3) {//서
					answer += store[i][1] + dg[1];
				} else if (store[i][0] == 4) {//동
					answer += R - dg[1] + store[i][1];
				}
			} else if (dg[0] == 2) {//동근 = 남
				if (store[i][0] == 1) {//북
					answer += Math.min(C + store[i][1] + dg[1], 2 * (R + C) - (C + store[i][1] + dg[1]));
				} else if (store[i][0] == 2) {//남
					answer += Math.abs(store[i][1] - dg[1]);
				} else if (store[i][0] == 3) {//서
					answer += dg[1] + C - store[i][1];
				} else if (store[i][0] == 4) {//동
					answer += R + C - store[i][1] - dg[1];
				}
			} else if (dg[0] == 3) {//동근 = 서
				if (store[i][0] == 1) {//북
					answer += dg[1] + store[i][1];
				} else if (store[i][0] == 2) {//남
					answer += C - store[i][1] + dg[1];
				} else if (store[i][0] == 3) {//서
					answer += Math.abs(store[i][1] - dg[1]);
				} else if (store[i][0] == 4) {//동
					answer += Math.min(R + store[i][1] + dg[1], 2 * (R + C) - (R + store[i][1] + dg[1]));
				}
			} else if (dg[0] == 4) {//동근 = 동
				if (store[i][0] == 1) {//북
					answer += R - store[i][1] + dg[1];
				} else if (store[i][0] == 2) {//남
					answer += C - dg[1] + R - store[i][1];
				} else if (store[i][0] == 3) {//서
					answer += Math.min(R + store[i][1] + dg[1], 2 * (R + C) - (R + store[i][1] + dg[1]));
				} else if (store[i][0] == 4) {//동
					answer += Math.abs(store[i][1] - dg[1]);
				}
			}
		}
		System.out.println(answer);

	}

}
