package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//메모리 : 148104kb
//시간 : 948ms

public class Main_5430_AC_김태윤 {

	static int[] toggle_idx = { 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();

		for (int t = 0; t < T; t++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");

			Deque<Integer> deque = new LinkedList<Integer>();

			for (int i = 0; i < n; i++)
				deque.add(Integer.parseInt(st.nextToken()));

			int i = 0;
			boolean isForward = true; // 정방향이니?
			for (; i < p.length; i++) {

				if (deque.isEmpty() && p[i] == 'D')
					break;

				if (p[i] == 'R')
					isForward = !isForward;
				else { // 'D'
					if (isForward)
						deque.removeFirst();
					else
						deque.removeLast();
				}
			}

			if (i < p.length)
				sb.append("error\n");
			else {
				sb.append("[");

				if (!deque.isEmpty()) {
					if (isForward) {
						while (!deque.isEmpty())
							sb.append(deque.removeFirst() + ",");
					} else {
						while (!deque.isEmpty())
							sb.append(deque.removeLast() + ",");
					}
					sb.setLength(sb.length() - 1);
				}
				sb.append("]\n");
			}

		}
		System.out.println(sb);
	}
}
