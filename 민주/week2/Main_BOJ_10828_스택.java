import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stk = new Stack<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String oper = token.nextToken();
			if(oper.equals("push")) {
				String num = token.nextToken();
				stk.push(num);
			}
			else if(oper.equals("pop")) {
				System.out.println(stk.isEmpty()? -1 : stk.pop());
			}
			else if(oper.equals("size")) {
				System.out.println(stk.size());
			}
			else if(oper.equals("empty")) {
				System.out.println(stk.isEmpty()? 1 : 0);
			}
			else {
				System.out.println(stk.isEmpty()? -1 : stk.peek());
			}
		}
	}
}