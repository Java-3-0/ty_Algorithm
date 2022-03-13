package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 :
//시간 :

//미완
public class Main_17281_야구이모지_김태윤 {

	static int N;
	static int[] order = {-1,-1,-1,0,-1,-1,-1,-1,-1};
	static int answer = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] isChecked;
	static int[][] result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		result = new int[N][9];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		isChecked = new boolean[9];
		//친구들 순서 지정하기
		dfs(0);

		System.out.println(answer);
	}
	
	static void dfs(int cnt) {
		if(cnt == 9) {
			baseball();
			return;
		}
		
		if(cnt == 3) {
			dfs(4);
			return;
		}
	
		for(int i = 1; i<9; i++) {
			if(!isChecked[i]) {
//				System.out.println(cnt +" "+i);
				isChecked[i] = true;
				order[cnt] = i;
				dfs(cnt+1);
				isChecked[i] = false;
			}
		}
	}
	
	static void baseball() {
		int sum = 0;

		int j = 0;
		
		for(int i = 0; i<N; i++) {
			int out_count = 0;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);q.add(0);q.add(0);
			
			while(out_count < 3) {
//				System.out.println("HI");
				if(result[i][order[j]] == 0) {
					out_count++;
				}else if(result[i][order[j]] == 1) {
					q.add(1);
					while(q.size() > 3) {
						if(q.poll()==1)
							sum++;
					}
				}else if(result[i][order[j]] == 2) {
					q.add(1);q.add(0);
					while(q.size() > 3) {
						if(q.poll()==1)
							sum++;
					}
				}else if(result[i][order[j]] == 3) {
					q.add(1);q.add(0);q.add(0);
					while(q.size() > 3) {
						if(q.poll()==1)
							sum++;
					}
				}else if(result[i][order[j]] == 4) {
					q.add(1);q.add(0);q.add(0);q.add(0);
					while(q.size() > 3) {
						if(q.poll()==1)
							sum++;
					}
				}
				j++;
				j%=9;
			}
		}
		
		answer = Math.max(answer, sum);
	}
}
