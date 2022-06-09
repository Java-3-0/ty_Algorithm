package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 300916kb
//시간 : 1012ms

public class Main_9466_텀_프로젝트_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());

			int answer = 0;
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken()) - 1;
			
			int[] isChecked = new int[n];
			for (int i = 0; i < n; i++) {
				
				if(isChecked[i] > 0) //이미 계산 끝난 친구
					continue;
				
				int next = i;
				
				int cnt = 0;
				
				while (true) {
					if(isChecked[next] != 0 && isChecked[next] <= i) //내가 아닌 다른 흐름이 이미 지나갔으면 그만 돈다
						break;
					
					if(isChecked[next] == i+1) { //내 사이클이라면
						answer += cnt-arr[next];
						break;
					}
					
					int temp = next;
					isChecked[temp] = i+1;
					next = arr[temp];
					arr[temp] = cnt++;
				}
			}
			System.out.println(n-answer);
		}
	}
}
