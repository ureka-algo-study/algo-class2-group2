package 종수.week2;

import java.util.Scanner;

//2941 크로아티아 알파벳
//패턴이 정해져있고 입력을 받아서 알파벳 갯수를 구해라
//패턴과 일치하면 하나의 문자로 변경 후 문자의 갯수 세기
class Main {
    static int count = 0;

    public static void main(String[] args) {
        
        String pattern[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        Scanner sc = new Scanner(System.in);

        String arr = sc.next();

        

        for (String croatia : pattern) {
            arr = arr.replace(croatia, "*");
        }
        sc.close();
        System.out.println(arr.length());

    }// psvmddz=z=


}// class
