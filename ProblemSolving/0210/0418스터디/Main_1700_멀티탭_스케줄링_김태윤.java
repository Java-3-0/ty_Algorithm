package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//메모리 : 11604kb
//시간 : 80ms

public class Main_1700_멀티탭_스케줄링_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N,K;
		N = Integer.parseInt(st.nextToken()); //멀티탭 구멍 개수
		K = Integer.parseInt(st.nextToken()); //전기용품 총 사용횟수
		
		int arr[] = new int[K];
		
		st = new StringTokenizer(br.readLine());
		
		// 1 2 3 1 3 1 2 2 2 2 
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		int cnt = 0;
		for(int i = 0; i<K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int i = 0; i<K; i++) {
			if(set.contains(arr[i])) continue;
			else if(cnt < N) {
				set.add(arr[i]);
				cnt++;
			}else {
				HashSet<Integer> temp = new HashSet<Integer>();
				for(int s : set) {
					temp.add(s);
				}
				
				for(int j = i+1; j<K; j++) {
					if(temp.size() == 1)
						break;
					
					if(temp.contains(arr[j])) {
						temp.remove(arr[j]);
					}
				}
				
				for(int s : temp) {
					set.remove(s);
					set.add(arr[i]);
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}

}
