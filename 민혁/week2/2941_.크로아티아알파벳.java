package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    /*
    알파벳이 8개밖에 없으니 하나씩 비교하면서 다른 알파벳으로 초기화(크로아티아 알파벳과 안겹치는 알파벳으로)
    출력결과의 알파벳 수를 세면 해결

    시간복잡도 O(n) : replace 할 때 문자열 전체를 스캔하기 때문에 전체 문자열 길이만큼의 시간복잡도
    문자열의길이는 최대 100글자이기 때문에 문제 X

     */

    public static void main(String[] args) throws IOException {

        //비교할 문자열 리스트에 담아서 보관
        List<String> croatian = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i = 0; i < 8; i++) { // c= 부터 z= 까지 있는지 확인하고 a로 바꿔버림
            s = s.replace(croatian.get(i),"a");
        }

        System.out.println(s.length());


    }
}
