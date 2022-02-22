package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 21208kb
//시간 : 200ms

public class Main_2491_수열_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int prior = Integer.parseInt(str.nextToken());
		
		
		//1오름차순 , -1내림차순, 0디폴트
		int flag = 0;
		
		int equalval_cnt = 2;
		int cnt = 1;
		
		int answer = 1;
		for(int i = 1; i<N; i++) {
			int curr = Integer.parseInt(str.nextToken());
			
			if(prior == curr) {
				cnt++;
				equalval_cnt++;
			}else {
				if(flag != -1 && curr > prior) {
					flag = 1;
					cnt++;
				}else if(flag == 1 &&  curr<prior) {
					flag = -1;
					cnt = equalval_cnt;
				}else if(flag != 1 && curr<prior) {
					flag = -1;
					cnt++;
				}else if(flag == -1 && curr>prior) {
					flag = 1;
					cnt = equalval_cnt;
				}
				equalval_cnt=2;
			}
			
			answer = Math.max(answer, cnt);
			
			prior = curr;
		}
		System.out.println(answer);
		
	}

}
