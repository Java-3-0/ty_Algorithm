package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR_김태윤 {

	static class Pair {
		int num;
		String s;

		public Pair(int num, String s) {
			super();
			this.num = num;
			this.s = s;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			boolean[] isChecked = new boolean[10000];
			isChecked[A] = true;
//			System.out.println(A);
//			System.out.println(B);
			Queue<Pair> q = new ArrayDeque<Pair>();
			q.offer(new Pair(A, ""));

			while (!q.isEmpty()) {
				Pair pair = q.poll();
//				System.out.println(pair.num + " " + pair.s);
				if (pair.num == B) {
					sb.append(pair.s);
					sb.append("\n");
					break;
				}

				// D
				if (pair.num * 2 > 9999) {
					if (!isChecked[(pair.num * 2) % 10000]) {
						isChecked[(pair.num * 2) % 10000] = true;
						q.offer(new Pair((pair.num * 2) % 10000, pair.s + "D"));
					}
				} else if (!isChecked[pair.num * 2]) {
					isChecked[pair.num * 2] = true;
					q.offer(new Pair(pair.num * 2, pair.s + "D"));
				}

				// S
				if (pair.num == 0) {
					if (!isChecked[9999]) {
						isChecked[9999] = true;
						q.offer(new Pair(9999, pair.s + "S"));
					}
				} else if (!isChecked[pair.num - 1]) {
					isChecked[pair.num - 1] = true;
					q.offer(new Pair(pair.num - 1, pair.s + "S"));
				}

				// L
				String temp = Integer.toString(pair.num);
				if (temp.length() > 1) {
					temp = temp.substring(1, temp.length()) + temp.charAt(0);
					int num = Integer.parseInt(temp);
					if (!isChecked[num]) {
						isChecked[num] = true;
						q.offer(new Pair(num, pair.s + "L"));
					}
				}

				// R
				temp = Integer.toString(pair.num);
				if (temp.length() > 1) {
					temp = temp.charAt(temp.length() - 1) + temp.substring(0, temp.length() - 1);
					int num = Integer.parseInt(temp);
					if (!isChecked[num]) {
						isChecked[num] = true;
						q.offer(new Pair(num, pair.s + "R"));
					}
				}
			}
		}
		System.out.println(sb);
	}

}
