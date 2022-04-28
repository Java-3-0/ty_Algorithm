import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//미완

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		int l = 0;
		int r = N-1;
		
		int ans_l = 0;
		int ans_r = N-1;
		int myMin = Math.abs(arr[l] + arr[r]);
		
		while(l<r-1) {
			
			while(l<r-1) {
				int temp = Math.abs(arr[l] + arr[r-1]);
				
				if(temp<myMin) {
					myMin = temp;
					r--;
					ans_l = l;
					ans_r = r;
				}else {
					break;
				}
			}
			
			l++;
		}
		
		System.out.println(arr[ans_l]+" "+arr[ans_r]);
	}

}





//
//
//
//
//package algo_ex;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main_2467_용액_김태윤 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int arr[] = new int[N];
//
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
////		10
////		-5 -5 -5 1 1 10 10 10 10 10
//		
//		int l = 0;
//		int r = N-1;
//		
//		int ans_l = 0;
//		int ans_r = N-1;
////		int myMin = Math.abs(arr[l] + arr[r]);
//		int myMin = Integer.MAX_VALUE;
//		
//		while(l<r-1) {
//			
//			System.out.println(l+" "+r+" "+myMin);
//			int temp2 = Math.abs(arr[l+1] + arr[r]);
//			if(temp2==myMin) {
//				myMin = temp2;
//				l++;
//				ans_l = l;
//				ans_r = r;
//				continue;
//			}else if(temp2<myMin) {
//				myMin = temp2;
//				l++;
//				ans_l = l;
//				ans_r = r;
//			}
//			while(l<r-1) {
//				System.out.println("   "+l+" "+r+" "+myMin);
//				int temp = Math.abs(arr[l] + arr[r-1]);
//				
//				if(temp==myMin) {
//					myMin = temp;
//					r--;
//					ans_l = l;
//					ans_r = r;
//				}else if(temp<myMin){
//					myMin = temp;
//					r--;
//					ans_l = l;
//					ans_r = r;
//					break;
//				}
//			}
//			
//			l++;
//		}
//		
//		System.out.println(arr[ans_l]+" "+arr[ans_r]);
//	}
//}