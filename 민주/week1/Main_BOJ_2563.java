import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        boolean[][] visited = new boolean[100][100];


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        StringTokenizer token;
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<10; k++){
                    visited[arr[i][0] + j] [arr[i][1] + k] = true;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(!visited[i][j]) continue;
                ans++;
                
            }
        }
        System.out.println(ans);
    }
}