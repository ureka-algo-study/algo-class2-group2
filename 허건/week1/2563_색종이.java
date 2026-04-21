import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int board[][] = new int[100][100];
        int answer = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j = x; j < (x + 10); j++){
                for(int t = y; t < (y + 10); t++){
                    if(board[j][t] == 0){
                        board[j][t] = 1;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}

