import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo3_서울_9반_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//답안으로 출력할 보안성이 가장 높은 패스워드의 보안성
		int security_index = 0;
		
		//입력받을 BufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N값 입력
		int N = Integer.parseInt(br.readLine());
		
		//N을 2진수로 변환시킬 ArrayList생성
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		//N의 변형을 위해 t라는 임시 값에 넣음
		int t = N;
		//t가 0이 될때까지
		while(t != 0) {
			//al에 값 추가
			al.add(t%2);
			//2진법 계산을 위한 나누기2
			t/=2;
		}
		
		//최대 값인 N이 최대 몇 자리인지 알 수 있게 됨
		int max_len = al.size();
		
		//M값 입력
		int M = Integer.parseInt(br.readLine());
		
		//M개 암호를 2진법으로 변환할 배열 생성
		int[][] arr_M = new int[M][max_len];		
		
		//빈칸마다 끊어주기 위해 StringTokenizer 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//M회 반복
		for(int i = 0; i<M; i++) {
			//암호를 temp에 넣음
			int temp = Integer.parseInt(st.nextToken());
			
			//새로운 ArrayList 생성
			al = new ArrayList<Integer>();
			
			//계산을 위해 가능했던 최대 길이로 idx 생성
			int idx = max_len - 1;
			
			//아까와 같은 2진법 계산
			while(temp!=0) {
				//아까와 같은 2진법 계산
				arr_M[i][idx--] = temp%2;
				//아까와 같은 2진법 계산
				temp/=2;
			}
		}
		
		//0부터 N까지 확인하기위해 N+1회 반복
		for(int i = 0; i<=N; i++) {
			//임시값인 temp에 차례대로 값 삽입
			int temp = i;
			
			//비교를 위한 새로운 int배열 생성
			int[] arr_temp = new int[max_len];
			
			//계산을 위해 가능했던 최대 길이로 idx 생성
			int idx = max_len - 1;
			
			//아까와 같은 2진법 계산
			while(temp!=0) {
				//아까와 같은 2진법 계산
				arr_temp[idx--] = temp%2;
				//아까와 같은 2진법 계산
				temp/=2;
			}
			
			
			//가장 낮은 보안성을 찾기 위해 min_cnt를 매우 높은 값으로 책정
			int min_cnt = 987654321;
			
			//기존에 만들어 둔 M개의 배열과 비교 시작, M회 반복
			for(int j = 0; j<M; j++) {
				//보안성 측정을 위한 cnt변수 생성
				int cnt = 0;
				//최대 길이만큼 반복
				for(int k = 0; k<max_len; k++) {
					//만일 둘의 값이 다르다면 (예를 들어, 0과 1)
					if(arr_M[j][k] != arr_temp[k]) {
						//cnt변수 1 증가
						cnt++;
					}
				}
				//보안성 측정했을때 더 낮은 값이라면
				if(min_cnt > cnt)
					//min_cnt값 갱신
					min_cnt = cnt;
			}
			
			//만일 min_cnt가 현재 정답인 security_index보다 크다면, 보안성이 더 높은거니까
			if(min_cnt > security_index)
				//security_index 갱신
				security_index = min_cnt;
			
		}
		
		//정답인 security_index 출력
		System.out.println(security_index);
		
	}
}
