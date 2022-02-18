package algo_ex;

import java.util.Scanner;

//메모리 : 12908kb
//시간 : 108ms

public class Main_15650_N과_M_2_김태윤 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		find(N,1,0,M,0);
		
		System.out.println(sb);
	}
	
	static void find(int N, int idx, int flag, int M, int cnt) {
		int num = 1<<N; //1000
		
		if(cnt == M) {
			for(int i = 1; i<=N; i++) {
				if((flag & num>>i) != 0)
					sb.append(i+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i<=N; i++) {
			if((flag & num>>i) == 0)
				find(N,i+1,flag|num>>i,M,cnt+1);
		}
	}

}
