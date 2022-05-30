package algo_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//메모리 : 27300kb
//시간 : 204ms

public class Main_1644_소수의_연속합_김태윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();

		boolean[] isNotPrime = new boolean[N + 1]; // 2,3,5 같은 소수가 false임
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!isNotPrime[i]) {
				for (int j = 2; i * j <= N; j++) {
					isNotPrime[i * j] = true;
				}
			}
		}
		
		for(int i = 2; i<=N; i++) {
			if(!isNotPrime[i]) {
				list.add(i);
			}
		}
		
		
		Integer[] temp = list.toArray(new Integer[list.size()]);
		
		int value = 0;
		int cnt = 0;
		int j = 0;  // 시작...j.....i..끝 -> 투포인터 방식
		for(int i = 0; i<temp.length; i++) {
			value += temp[i];
			while(true) {
				if(value == N) {
					cnt++;
					break;
				}
				
				if(i==j)
					break;
				
				if(value > N) { //
					value-=temp[j];
					j++;
				}else if(value < N) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
