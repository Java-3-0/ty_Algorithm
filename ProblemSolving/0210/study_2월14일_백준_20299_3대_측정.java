import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_9반_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//입력받을 BufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//빈칸마다 끊어주기 위해 StringTokenizer 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//답안을 한 줄로 만들기 위해 StringBuilder 생성
		StringBuilder sb = new StringBuilder();
		
		//N에 입력받은 값 삽입
		int N = Integer.parseInt(st.nextToken());
		//S에 입력받은 값 삽입
		int S = Integer.parseInt(st.nextToken());
		//M에 입력받은 값 삽입
		int M = Integer.parseInt(st.nextToken());
		
		//답안 출력시 쓰일 변수인 cnt 생성
		int cnt = 0;
		
		//N회 반복
		for(int i = 0; i<N; i++) {
			//한 줄 입력
			st = new StringTokenizer(br.readLine());
			
			//3칸짜리 int배열 생성
			int[] person = new int[3];
			
			//모든 SSAFY생들의 값을 더할 sum변수 생성
			int sum = 0;
			
			//개인별로 최소 능력치를 확인하기 위한 flag라는 boolean변수 생성
			boolean flag = false;
			//3회 반복
			for(int j = 0; j<3; j++) {
				//토큰을 받아 person[j]에 입력
				person[j] = Integer.parseInt(st.nextToken());
				
				//SSAFY생 능력치 합산
				sum += person[j];
				
				//만일 개인 최소 능력치가 M보다 작다면
				if(person[j] < M)
					//flag변수 true로 바꿈
					flag = true;
			}
			
			//만일 단 한 명이라도 최소 능력치 미달이라면 
			if(flag)
				//무효
				continue;
			
			
			//만일 합계가 S보다 작다면
			if(sum < S)
				//무효
				continue;
			
			//모든 조건을 통과했으니 cnt변수 1 증가시키면서 동아리 하나가 통과됐음을 알림
			cnt++;
			
			//3회 반복
			for(int j = 0; j<3; j++)
				//StringBuilder에 출력할 값 append
				sb.append(person[j]+" ");
		}
		
		//몇 개의 동아리가 통과했는지 출력
		System.out.println(cnt);
		
		//그 동아리에 누가 있는지 출력
		System.out.println(sb);
	}

}
