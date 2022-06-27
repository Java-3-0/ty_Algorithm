package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 15696kb
//시간 : 276ms

public class Main_10973_이전_순열_김태윤 {
	static int[] input;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(prevPermutation()) {
			for(int i = 0; i<N; i++) {
				System.out.print(input[i]+" ");
			}
		}else
			System.out.println(-1);
	}

	private static boolean prevPermutation() {

//		교환위치 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] <= input[i])
			--i;

		if (i == 0)
			return false;

//		교환위치에 교환할 값 찾기
		int j = N - 1;
		while (input[i - 1] <= input[j])
			--j;

//		교환위치와 교환할 값 교환하기
		swap(i - 1, j);

//		교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순생성)
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
