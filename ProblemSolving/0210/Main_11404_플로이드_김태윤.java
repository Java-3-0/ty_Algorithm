package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 : 42916kb
//시간 : 364ms

public class Main_11404_플로이드_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		for(int i = 0; i<n; i++) {
			Arrays.fill(board[i], 10000000);
			board[i][i] = 0;
		}
		
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int len = Integer.parseInt(st.nextToken());
			board[start][end] = Math.min(board[start][end], len);
		}
		
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(board[i][j] == 10000000)
					sb.append("0 ");
				else
					sb.append(board[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
