package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018_체스판_다시_칠하기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();
		
		
		int answer = Integer.MAX_VALUE;
		
		
		for(int ii = 0; ii<=N-8; ii++) {
			for(int jj = 0; jj<=M-8; jj++) {
				int count = 0;
				boolean isWhite = true;
				for (int i = 0; i < 8; i++) {
						isWhite = !isWhite;
					for (int j = 0; j < 8; j++) {
						if (isWhite) {
							if (arr[ii+i][jj+j] == 'W') {
								count++;
							}
						} else {
							if (arr[ii+i][jj+j] == 'B') {
								count++;
							}
						}
						isWhite = !isWhite;
					}
				}


				int count_answer = 8 * 8 - count;
				answer = Math.min(answer,count_answer < count ? count_answer : count);
			}
		}
		System.out.println(answer);
	}

}
