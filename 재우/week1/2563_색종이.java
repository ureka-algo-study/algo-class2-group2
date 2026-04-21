package boj;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int n;
	
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		int arr[][] = new int[n][2];
		for(int i = 0; i<n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		Arrays.sort(arr,(a,b)->a[0]-b[0]); //람다식 (a[0]과 b[0]을 비교해서 정렬
		
		for(int i = 0; i < n; i++) {
		    System.out.println(arr[i][0] + " " + arr[i][1]);
		}		
	}
}
