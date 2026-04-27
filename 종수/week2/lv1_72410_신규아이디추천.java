package 종수.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 3 <= 아이디길이 < 15
// 소문자,숫자, - , _ , . 만 사용가능
// 단 . 은 처음과 끝에, 연속적으로 사용 불가능

class Solution {
    public String solution(String new_id) {
        String answer = "";

        answer = ChangeID(new_id);

        return answer;
    }//solution

    public static String ChangeID(String id) {

        String changed;
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        changed = id.toLowerCase();
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        changed = changed.replaceAll("[^a-z0-9-_.]", "");
        //문자열에서 제거 함수를 찾아 보았고 replaceAll을 사용하여 여러개의 문자를 한번에 바꿀수 있다고 함.
        // 보통은 대괄호 안에 있는 함수를 제외하지만 "^"를 붙이게 되면 반대의 의미가 됨.

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        
        // changed = changed.replaceAll("..", ".");//초기 작성 코드. ".." 은 아무 문자 2개를 의미해 문자열이 전부 바뀜
        changed = changed.replaceAll("\\.{2,}", ".");
        // \\. -> "."
        // {2,} -> 2개 이상

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        changed = changed.replaceAll("^\\.+|\\.+$", "");


        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.

        if(changed.isEmpty())
            changed = "a";

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        if(changed.length() >= 16){
            changed = changed.substring(0, 15);
            if(changed.charAt(changed.length() - 1) == '.')
                changed = changed.substring(0, changed.length() - 1);
                
        }

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
         
        while (changed.length() < 3 ) {
            
            changed += changed.charAt(changed.length() - 1);
            
        }

        return id = changed;
    }// ChangeID

    public static void main(String[] args) throws Exception{ //테스트 코드
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = new String[n];
        String s[] = new String[n];
        for (int i = 0; i < n; i++){
            input[i] = br.readLine();
            s[i] = ChangeID(input[i]);
        }
        for (int i = 0; i < n; i++){
         
            System.out.println( i + "번째 " + input[i] + " -> " + s[i]);
        }

    }//psvm
}// class

// 아래서 4번째 위에서 6번째 부터 8번째 사이