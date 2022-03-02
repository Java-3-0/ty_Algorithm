package algo_ex;

import java.util.Scanner;

//메모리 : 17472kb
//시간 : 172ms
public class Main_13300_방_배정_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[2][6];
		
		for(int i = 0; i<N; i++) {
			arr[sc.nextInt()][sc.nextInt()-1]++;
		}
		
		int sum = 0;
		for(int i = 0; i<2; i++) {
			for(int j =0; j<6; j++) {
				sum += arr[i][j]/K;
				if(arr[i][j]%K != 0)
					sum++;
			}
		} 
		
		System.out.println(sum);
	}

}
