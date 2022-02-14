import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_9반_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//입력받을 BufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//T에 입력받은 값 삽입
		int T = Integer.parseInt(br.readLine());
		
		//T회 반복
		for(int i = 1; i<=T; i++) {
			//빈칸마다 끊어주기 위해 StringTokenizer 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//N은 사용하지 않으므로 따로 정의하지 않음. 토큰만 패스
			st.nextToken();
			
			//X에 입력받은 값 삽입
			int X = Integer.parseInt(st.nextToken());
			
			//K에 입력받은 값 삽입
			int K = Integer.parseInt(st.nextToken());
			
			//K회 반복
			for(int j = 0; j<K; j++) {
				//다시 두 칸을 끊기위해 StringTokenizer 사용
				st = new StringTokenizer(br.readLine());
				
				//첫 번째 값
				int temp1 = Integer.parseInt(st.nextToken());
				
				//두 번째 값
				int temp2 = Integer.parseInt(st.nextToken());
				
				//만일 첫 번째 값이 바꿀 대상이라면
				if(temp1 == X) {
					//두 번째 값과 스위칭
					X = temp2;
				//아니고, 만일 두 번째 값이 바꿀 대상이라면
				}else if(temp2 == X) {
					//첫 번째 값과 스위칭
					X = temp1;
				}
			}
			
			//답안 한 줄 씩 출력
			System.out.println("#"+i+" "+X);
	
		}
	}

}
