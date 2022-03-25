package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2508_사탕_박사_고창영_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int r,c;
		char[][] arr;
		char[] ch;
		int answer;
		
		
		for(int t = 0; t<testcase; t++) {
			
			br.readLine();
			
			st = new StringTokenizer(br.readLine());
			r =  Integer.parseInt(st.nextToken());
			c =  Integer.parseInt(st.nextToken());
			arr = new char[r][c];
			for(int i = 0; i<r; i++) {
				ch = br.readLine().toCharArray();
				for(int j = 0; j<c; j++) {
					arr[i][j] = ch[j];
				}
			}
			
			
			
			answer = 0;
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++) {
					if(arr[i][j] == 'o') {
						if(j-1>=0 && j+1<c) {
							if(arr[i][j-1] == '>' && arr[i][j+1]=='<') {
								answer++;
								continue;
							}
						}
						
						if(i-1>=0 && i+1<r) {
							if(arr[i-1][j] == 'v' && arr[i+1][j]=='^') {
								answer++;
								continue;
							}
						}
					}
				}
			}
			
			
			System.out.println(answer);
		}
	}

}
