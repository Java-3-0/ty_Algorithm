package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//메모리 : 12004kb
//시간 : 96ms

public class Main_1713_후보_추천하기_김태윤 {

	static class Student implements Comparable<Student> {
		int num; // 학생 번호
		int cnt; // 추천 수
		int idx; // 들어온 순서(time역할)

		public Student(int num, int cnt, int idx) {
			super();
			this.num = num;
			this.cnt = cnt;
			this.idx = idx;
		}

		@Override
		public int compareTo(Student o) {
			if (this.cnt == o.cnt)
				return this.idx - o.idx;
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 사진 틀 갯수
		int M = Integer.parseInt(br.readLine()); // 추천 수

		ArrayList<Student> frame = new ArrayList<Student>(); // 액자

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int student = Integer.parseInt(st.nextToken());
			if (frame.size() < N) {
				int j = 0;
				for (; j < frame.size(); j++) {
					if (frame.get(j).num == student) {
						frame.get(j).cnt++;
						break;
					}
				}

				if (j == frame.size())
					frame.add(new Student(student, 1, i));
			} else {
				Collections.sort(frame); // comparable로 정렬
				int j = 0;
				for (; j < frame.size(); j++) {
					if (frame.get(j).num == student) {
						frame.get(j).cnt++;
						break;
					}
				}

				if (j == frame.size()) {
					frame.remove(0);
					frame.add(new Student(student, 1, i));
				}
			}
		}
		
		Collections.sort(frame, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.num - o2.num;
			}
		});
		
		for(int i = 0; i<frame.size(); i++) {
			System.out.println(frame.get(i).num+" ");
		}
		
		
	}
}
