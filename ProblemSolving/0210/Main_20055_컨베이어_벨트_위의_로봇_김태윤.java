package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//메모리 : 40664kb
//시간 : 1260ms

public class Main_20055_컨베이어_벨트_위의_로봇_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		LinkedList<Integer> front_row = new LinkedList<Integer>();
		LinkedList<Integer> back_row = new LinkedList<Integer>();

		for (int i = 0; i < N; i++)
			front_row.add(Integer.parseInt(st.nextToken()));
		for (int i = 0; i < N; i++)
			back_row.add(Integer.parseInt(st.nextToken()));

		int robot = 10000;
		int zero_cnt = 0;

		int stage = 0;
		while (true) {
			stage++;
			
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			front_row.addFirst(back_row.removeLast()); // 1234 -> 4123 front_row F__L
			back_row.addFirst(front_row.removeLast()); // 4321 -> 3214 back_row L__F

			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
			// - 만약 이동할 수 없다면 가만히 있는다.
			// - 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			for (int i = N-1; i >= 0; i--) {
				if (i == N-1) {
					if (front_row.get(i) >= robot) {
						front_row.set(i, front_row.get(i) - robot);
					}
				} else if (front_row.get(i) >= robot) {// 로봇이 있다면,
					if (front_row.get(i + 1) < robot && front_row.get(i + 1) >= 1) { //앞칸이 움직이는 조건을 만족한다면
						front_row.set(i, front_row.get(i)-robot);
						front_row.set(i+1,front_row.get(i+1)+robot-1);
						if(front_row.get(i+1) == robot)
							zero_cnt++;
						if(i+1 == N-1) {
							if(front_row.get(i+1) >= robot)
								front_row.set(i+1, front_row.get(i+1)-robot);
						}
					}
				}
			}
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(front_row.get(0) > 0) {
				front_row.set(0, front_row.get(0)+robot-1);
				if(front_row.get(0)==robot)
					zero_cnt++;
			}
			// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			if(zero_cnt >= K)
				break;
		}
		
		System.out.println(stage);

	}

}
