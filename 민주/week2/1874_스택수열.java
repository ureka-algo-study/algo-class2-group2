import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int target = 0;
        for(int i=1; i<=N; i++){
            stk.push(i);
            sb.append("+\n");
            if(stk.peek() == arr[target]){
                while(!stk.isEmpty() && stk.peek() == arr[target]){
                    sb.append("-\n");
                    stk.pop();
                    target++;
                }
            }
        }
        
        System.out.println(stk.isEmpty()? sb.toString() : "NO");
    }
}