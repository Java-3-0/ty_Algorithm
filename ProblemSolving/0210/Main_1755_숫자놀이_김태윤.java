import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1755_숫자놀이_김태윤 {

	// 클래스 MyWord 생성
	static class MyWord implements Comparable<MyWord> {
		// 원래 숫자
		int num;
		// 숫자를 영어로 변환한 string
		String eng = "";

		// 생성자(이 안에서 eng 생성)
		public MyWord(int num) {
			// 상위 생성자 호출
			super();
			// num 입력
			this.num = num;
			// 만일 원래 숫자가 두 자리라면?
			if (num >= 10)
				// 십의 자리를 영어로 변환
				this.eng = Num2String(num / 10);
			// 일의 자리를 영어로 변환
			this.eng += Num2String(num % 10);
		}

		// 인터페이스를 구현하는 과정
		@Override
		public int compareTo(MyWord o) {
			// String인 eng을 사전순으로 배열하기 위한 계산
			return this.eng.compareTo(o.eng);
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		 * 8 5 4 9 1 7 6 3 2 0
		 */

		// 입력 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 쪼갤 준비
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 숫자
		int N = Integer.parseInt(st.nextToken());
		// 끝 숫자
		int M = Integer.parseInt(st.nextToken());

		// M-N+1개의 배열 크기 확보
		MyWord myWord[] = new MyWord[M - N + 1];
		// myWord의 각 자리에
		for (int i = 0; i < M - N + 1; i++) {
			// 단어 생성
			myWord[i] = new MyWord(N + i);
		}

		// 사전 순 배열하는 과정
		Arrays.sort(myWord);

		// 정답 도출을 위한 스트링버퍼 생성 및 초기화
		StringBuffer sb = new StringBuffer();
		// 모든 숫자를 돈다
		for (int i = 0; i < M - N + 1; i++) {
			// 만일 0이 아닌 10의 배수라면
			if (i != 0 && i % 10 == 0) {
				// 끝에 빈칸 삭제
				sb.setLength(sb.length() - 1);
				// 한 줄 띄기
				sb.append("\n");
			}
			// 숫자+빈칸 연결
			System.out.println(myWord[i].eng);
			sb.append(myWord[i].num).append(" ");
		}

		// 정답 도출
		System.out.println(sb);
	}

	//숫자를 영어로 바꾸는 메서드
	static String Num2String(int num) {
		//스위치 문을 이용하여 변환(이하 주석은 뻔하니 생략)
		switch (num) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return "zero";
		}
	}

}
