package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 13688kb
//시간 : 104ms

public class Main_16953_A화살표B_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { A, 1 });

		if (A == B)
			System.out.println(1);

		boolean isAnswer = false;

		while (!q.isEmpty()) {
			int arr[] = q.poll();

//			System.out.println(arr[0] + " " + arr[1]);
			if (arr[0] <= 500000000) {
				if (arr[0] * 2 == B) {
					System.out.println(arr[1] + 1);
					isAnswer = true;
					break;
				}
				q.offer(new int[] { arr[0] * 2, arr[1] + 1 });
			}

			if (arr[0] <= (1000000000 - 1) / 10) {
				if (arr[0] * 10 + 1 == B) {
					System.out.println(arr[1] + 1);
					isAnswer = true;
					break;
				}
				q.offer(new int[] { arr[0] * 10 + 1, arr[1] + 1 });
			}

		}

		if (!isAnswer)
			System.out.println(-1);

	}

}
