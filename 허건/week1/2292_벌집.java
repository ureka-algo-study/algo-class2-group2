import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 1;
        int i = 1;


        while(answer < n){
            answer += 6*i;
            i++;
        }
        if(n == 1){
            System.out.println("1");
        }else{
            System.out.println(i);
        }

    }
}
