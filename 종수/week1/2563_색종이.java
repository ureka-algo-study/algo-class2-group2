package 종수.week1;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//--------------------------- 입력
		Scanner sc = new Scanner(System.in);
		
		int n, x[], y[];
		int count = 0;
		n = sc.nextInt();
		x = new int[n];
		y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			 
		}//for 
		
		int arr[][] = new int[100][100];
		//---------------------------- 구현

		for (int i = 0; i < n; i++) {
			for (int a = x[i]; a < x[i]+10; a++) {
				for(int b = y[i]; b < y[i]+10; b++) {
					
					if (arr[a][b] == 0) {
						count++;
					}
					arr[a][b] = 1;

					
				}
			}
		}
		//출력
		System.out.println(count);
		
	}//psvm
	
	
	

}//class
