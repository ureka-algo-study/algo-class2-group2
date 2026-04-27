import java.util.*;
import java.io.*;


public class Main_BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		String str = br.readLine();
		br.close();
		int idx = 0;
		while(idx < str.length()) {
			switch(str.charAt(idx)) {
				case 'c':
					if(idx+1 < str.length() 
							&& ((str.charAt(idx+1) == '=') 
							|| (str.charAt(idx+1) == '-') ) ) {
						idx ++;
					}
					idx++;
					answer++;
					break;
				case 'd':
					if(idx+2 < str.length()
							&& ((str.charAt(idx+1) == 'z') 
							&& (str.charAt(idx+2) == '='))) {
						idx+=2;
					}
					else if(idx+1 < str.length() 
							&& (str.charAt(idx+1) == '-')) {
						idx++;
					}
					idx++;
					answer++;
					break;
				case 'l':
					if(idx+1 < str.length() 
							&& (str.charAt(idx+1) == 'j')){
						idx++;
					}
					idx++;
					answer++;
					break;
				case 'n':
					if(idx+1 < str.length() 
							&& (str.charAt(idx+1) == 'j')){
						idx++;
					}
					idx++;
					answer++;
					break;
				case 's':
					if(idx+1 < str.length() 
							&& (str.charAt(idx+1) == '=')){
						idx++;
					}
					idx++;
					answer++;
					break;
				case 'z':
					if(idx+1 < str.length() 
							&& (str.charAt(idx+1) == '=')){
						idx++;
					}
					idx++;
					answer++;
					break;
				default:
					answer++;
					idx++;
					break;
			} //switch
		}//while
		System.out.println(answer);
	}

}
