package algo_ex;

import java.util.Scanner;
//메모리 : 12892kb
//시간 : 112ms
public class Main_10158_개미_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); //6
		int h = sc.nextInt(); //4
		
		int p = sc.nextInt(); //4
		int q = sc.nextInt(); //1
		
		int t = sc.nextInt(); //8
		
		p += t;
		q += t;
		
		p%=(w*2);
		q%=(h*2);
		
		if(p<=w && q<=h) { //3사분면(오리지널)
			
		}else if(p<=w && q>h) { //2사분면
			q = h-(q-h);
		}else if(p>w && q<=h) { //4사분면
			p = w-(p-w);
		}else { //1사분면
			q = h-(q-h);
			p = w-(p-w);
		}
		
		System.out.println(p+" "+q);
	}

}
