import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int len = String.valueOf(n).length();
        int t = Math.max(0, n - (9 * len));     // n의 1의 자리수일때 방지
        int answer = 0;
        for (int i = t; i < n; i++){
            int sum = 0;
            int temp = i;
            while (temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            if(i + sum == n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}