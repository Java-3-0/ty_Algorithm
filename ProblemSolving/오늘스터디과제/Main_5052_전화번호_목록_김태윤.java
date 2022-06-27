package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//메모리 : 33004kb
//시간 : 600ms
public class Main_5052_전화번호_목록_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] phoneNum = new String[N];
			for (int i = 0; i < N; i++) {
				phoneNum[i] = br.readLine();
			}

			Arrays.parallelSort(phoneNum);

			LOOP: while (true) {
				for (int i = 0; i < N-1; i++) {
					if (phoneNum[i+1].startsWith(phoneNum[i])) {
						System.out.println("NO");
						break LOOP;
					}
				}
				System.out.println("YES");
				break;
			}
		}
	}

}
