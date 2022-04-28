package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 13200kb
//시간 : 100ms

public class Main_2629_양팔저울_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int choo = Integer.parseInt(br.readLine());

		int choo_arr[] = new int[choo];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < choo; i++)
			choo_arr[i] = Integer.parseInt(st.nextToken());
		
		boolean dp[][] = new boolean[31][40001];
		dp[0][20000] = true;

		for (int i = 0; i <choo; i++) {
			
			for (int j = 0; j <= 40000; j++) {
				if (dp[i][j]) {
					dp[i + 1][j] = true;

					int isValid = j - choo_arr[i];

					if (isValid >= 0 && isValid <= 40000)
						dp[i + 1][isValid] = true;

					isValid = j + choo_arr[i];

					if (isValid >= 0 && isValid <= 40000) {
						dp[i + 1][isValid] = true;
					}
				}
				
			}

		}

		int testcase = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < testcase; i++) {
			int temp = Integer.parseInt(st.nextToken())+20000;
			if (temp<40001 && dp[choo][temp])
				sb.append("Y ");
			else
				sb.append("N ");
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb);
	}

}
