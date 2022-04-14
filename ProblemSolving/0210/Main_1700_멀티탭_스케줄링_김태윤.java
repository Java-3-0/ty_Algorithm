package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1700_멀티탭_스케줄링_김태윤 {

	//미완
	
	/*
	 * 27% 틀림
	 * 
	 * 2 15
	 * 3 2 1 2 1 2 1 2 1 3 3 3 3 3 3
	 * 답: 2
	 * 
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N,K;
		N = Integer.parseInt(st.nextToken()); //멀티탭 구멍 개수
		K = Integer.parseInt(st.nextToken()); //전기용품 총 사용횟수
		
		int arr[] = new int[K];
		
		boolean multitap[] = new boolean[K+1];
		int elec_machine[] = new int[K+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			elec_machine[arr[i]]++;
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int count = 0;
		int answer = 0;
		for(int i = 0; i<K; i++) {

			elec_machine[arr[i]]--;

			if(multitap[arr[i]])
				continue;
			
			if(count<N) {
				
				count++;
				multitap[arr[i]] = true;
				
				al.add(arr[i]);
				
			}else {
				
				int myMax = Integer.MAX_VALUE;
				int index = -1;
				int al_index = -1;
				for(int j = 0; j<al.size(); j++) {
					int temp = al.get(j);
					if(elec_machine[temp] < myMax) {
						myMax = elec_machine[temp];
						index = temp;
						al_index = j;
					}
				}
				
				multitap[index] = false;
				multitap[arr[i]] = true;
				al.remove(al_index);
				al.add(arr[i]);
				
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}

}
