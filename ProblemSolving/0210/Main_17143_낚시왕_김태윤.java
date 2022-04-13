package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 48276kb
//시간 : 584ms

public class Main_17143_낚시왕_김태윤 {
	static int R, C, M;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Shark {
		int s = 0; // 속력
		int d = 0; // 이동방향 (0123 : 상하우좌)
		int z = 0; // 크기

		public Shark() {
			super();
		}

		public Shark(int s, int d, int z) {
			super();
			this.d = d;
			this.z = z;
			
			//속력이 너무 크면 방해만 되므로 사전에 차단하기 위해 모듈러 연산
			if(d<2) { //상하
				s%=(R-1)*2;
			}else { //좌우
				s%=(C-1)*2;
			}
			
			this.s = s;
		}

		//벽에 부딪쳤을 때 바뀌는 방향
		void changeDir() {
			if (d == 0)
				d = 1;
			else if (d == 1)
				d = 0;
			else if (d == 2)
				d = 3;
			else if (d == 3)
				d = 2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//상어가 들어갈 초기 board 생성 및 초기화
		Shark[][] board = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = new Shark();
			}
		}

		//board에 상어 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new Shark(
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		for (int t = 0; t < C; t++) {
			
			//낚시
			for (int i = 0; i < R; i++) {
				if (board[i][t].z != 0) {
					answer += board[i][t].z;
					board[i][t] = new Shark();
					break;
				}
			}
			
			//새로운 newboard 생성(상어들의 이동 후에 저장할 공간)
			Shark[][] newboard = new Shark[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					newboard[i][j] = new Shark();
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					//기존 board에 상어 존재한다면
					if (board[i][j].z != 0) {
						moveShark(newboard, i, j, board[i][j]);
					}
				}
			}
			
			//다음 계산을 위해 newboard의 값을 board에 건내줌
			board = newboard;
		}
		
		//정답 도출
		System.out.println(answer);

	}

	static void moveShark(Shark[][] newboard, int r, int c, Shark shark) {

		/**
		 * 1. 움직인다
		 * 2. 벽이 부딛치면 방향 전환 
		 * 3. 만일 최종 지점에 이미 상어 있다면 크기 비교 후 덮어 씌우거나 씌우지 않음
		 */
		
		int speed = shark.s;
		while (speed-- > 0) {
			int x = r + dx[shark.d];
			int y = c + dy[shark.d];

			//벽에 부딪치면? 방향 전환하라
			if (x < 0 || y < 0 || x >= R || y >= C) {
				shark.changeDir();
				x = r + dx[shark.d];
				y = c + dy[shark.d];
			}
			
			r = x;
			c = y;
		}
		
		//이동 된 위치 계산 완료 되어 r,c 에 저장됨
		
		
		//newboard에 상어 업데이트
		if(newboard[r][c].z == 0) 
			newboard[r][c] = shark;
		else if(newboard[r][c].z < shark.z)
				newboard[r][c] = shark;
		
	}

}
