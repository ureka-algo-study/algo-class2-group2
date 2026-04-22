import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		int area = 0;
        int n = scan.nextInt();
        boolean[][] paper = new boolean[100][100];   

        for (int t = 0; t < n; t++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if(!paper[i][j]) {
                    paper[i][j] = true;
					area++;
					}
                }
            }
        }
         System.out.println(area);
    }
}
/*

(색종이 개수 x 100 - 겹치는 부분)으로 구하려했으나
3개이상 겹칠경우 처리가 불가능해져 칸을 직접 칠하며 넓이를 계산하는 방식으로 구현

초기 색종이를 칠한뒤 다시 전체 배열을 돌며 넓이를 계산했는데,
방문하지 않은 칸을 true로 바꾸는 동시에 area를 바로 증가하는 방법으로 변경

두 방식 모두 O(n)이지만 조금 더 간결해짐


======================초기코드======================
for (int i = x; i < x + 10; i++) {
    for (int j = y; j < y + 10; j++) {
        paper[i][j] = 1;
    }
}

int area = 0;

for (int i = 0; i < 100; i++) {
    for (int j = 0; j < 100; j++) {
        if (paper[i][j]) {
            area++;
	...

*/