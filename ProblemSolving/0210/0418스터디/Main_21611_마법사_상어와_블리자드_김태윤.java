package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//메모리 : 47352kb
//시간 : 396ms

public class Main_21611_마법사_상어와_블리자드_김태윤 {

	static int dx[] = { 0, -1, 1, 0, 0 }; // 상하좌우
	static int dy[] = { 0, 0, 0, -1, 1 };
	static int snail_dir[] = { 3, 2, 4, 1 }; // 좌하우상

	static int shark_x, shark_y;

	static class Skill {
		int d; // 방향(direction)
		int s; // 거리(space)

		public Skill(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N = 격자 사이즈
		int N = Integer.parseInt(st.nextToken());

		shark_x = shark_y = N / 2;

		// M = 시전한 마법 갯수
		int M = Integer.parseInt(st.nextToken());

		int grid[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Skill[] skill = new Skill[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			skill[i] = new Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		
		int x, y;
		int snail_cnt = (N / 2) * 4 + 1;
		for (int m = 0; m < M; m++) {
			/*
			 * 1. 마법 시전
			 * 2. 달팽이모양으로 땡기기
			 * 3. 폭발 -> 땡기기 (while로 반복)
			 * 4. 달팽이모양으로 원소 저장
			 * 5. 그룹 나눠서 grid 재배치
			 */
			
			
			// 1. 마법 시전
			for (int i = 1; i <= skill[m].s; i++) {
				x = shark_x + dx[skill[m].d]*i;
				y = shark_y + dy[skill[m].d]*i;

				grid[x][y] = 0;
			}
			
			
			// 2. 달팽이 모양으로 땡기기
			x = shark_x;
			y = shark_y;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int len = 0;
			for (int i = 0; i < snail_cnt; i++) {
				if (i % 2 == 0 && i + 1 < snail_cnt) {
					len++;
				}
				for (int j = 0; j < len; j++) {
					x += dx[snail_dir[i % 4]];
					y += dy[snail_dir[i % 4]];

					if (grid[x][y] != 0) {
						arr.add(grid[x][y]);
						grid[x][y] = 0;
					}
				}
			}

			len = 0;
			int arrSize = arr.size();
			int cnt = 0;
			x = shark_x;
			y = shark_y;
			for (int i = 0; i < snail_cnt; i++) {
				if (i % 2 == 0 && i + 1 < snail_cnt) {
					len++;
				}
				for (int j = 0; j < len; j++) {
					x += dx[snail_dir[i % 4]];
					y += dy[snail_dir[i % 4]];

					if (cnt < arrSize) {
//						System.out.println(x+" "+y);
						grid[x][y] = arr.get(cnt++);
					}
				}
			}
			
			
			// 3. 폭발 -> 땡기기 (while로 반복)
			while (true) {
				boolean isBomb = false;
				x = shark_x;
				y = shark_y;
				ArrayList<int[]> coord = new ArrayList<int[]>();
				len = 0;
				int cur_color = -1;
				int cur_cnt = -1;
				for (int i = 0; i < snail_cnt; i++) {
					if (i % 2 == 0 && i + 1 < snail_cnt) {
						len++;
					}
					for (int j = 0; j < len; j++) {
						x += dx[snail_dir[i % 4]];
						y += dy[snail_dir[i % 4]];
						
						if(cur_color != grid[x][y]) {
							if(cur_cnt >= 4) {
								answer += cur_color * cur_cnt;
								
								//폭발
								for(int k = 0; k<cur_cnt; k++) 
									grid[coord.get(k)[0]][coord.get(k)[1]] = 0;
								isBomb = true;
							}
							coord.clear();
							
							cur_color = grid[x][y];
							cur_cnt = 1;
							coord.add(new int[] {x,y});
						}else {
							cur_cnt++;
							coord.add(new int[] {x,y});
						}
					}
				}
				
				if (!isBomb)
					break;
				else {
					x = shark_x;
					y = shark_y;
					arr = new ArrayList<Integer>();
					len = 0;
					for (int i = 0; i < snail_cnt; i++) {
						if (i % 2 == 0 && i + 1 < snail_cnt) {
							len++;
						}
						for (int j = 0; j < len; j++) {
							x += dx[snail_dir[i % 4]];
							y += dy[snail_dir[i % 4]];

							if (grid[x][y] != 0) {
								arr.add(grid[x][y]);
								grid[x][y] = 0;
							}
						}
					}

					len = 0;
					arrSize = arr.size();
					cnt = 0;
					x = shark_x;
					y = shark_y;
					for (int i = 0; i < snail_cnt; i++) {
						if (i % 2 == 0 && i + 1 < snail_cnt) {
							len++;
						}
						for (int j = 0; j < len; j++) {
							x += dx[snail_dir[i % 4]];
							y += dy[snail_dir[i % 4]];

							if (cnt < arrSize)
								grid[x][y] = arr.get(cnt++);
						}
					}
				}
			}

			
			// 4. 달팽이모양으로 원소 저장
			x = shark_x;
			y = shark_y;
			arr = new ArrayList<Integer>();
			len = 0;
			int cur_color = -1;
			int cur_cnt = -1;
			loop: for (int i = 0; i < snail_cnt; i++) {
				if (i % 2 == 0 && i + 1 < snail_cnt) {
					len++;
				}
				for (int j = 0; j < len; j++) {
					x += dx[snail_dir[i % 4]];
					y += dy[snail_dir[i % 4]];

					if (grid[x][y] == 0)
						break loop;
					
					if (grid[x][y] != cur_color) {
						if (cur_color != -1) {
							arr.add(cur_cnt);
							arr.add(cur_color);
						}
						cur_color = grid[x][y];
						cur_cnt = 1;
					} else {
						cur_cnt++;
					}
					
					grid[x][y] = 0;
				}
			}
			
			if(cur_color != -1) {
				arr.add(cur_cnt);
				arr.add(cur_color);
			}

			
			// 5. 그룹 나눠서 grid 재배치
			len = 0;
			arrSize = arr.size();
			cnt = 0;
			x = shark_x;
			y = shark_y;
			for (int i = 0; i < snail_cnt; i++) {
				if (i % 2 == 0 && i + 1 < snail_cnt) {
					len++;
				}
				for (int j = 0; j < len; j++) {
					x += dx[snail_dir[i % 4]];
					y += dy[snail_dir[i % 4]];

					if (cnt < arrSize)
						grid[x][y] = arr.get(cnt++);
				}
			}
		}
		
		System.out.println(answer);
	}

}
