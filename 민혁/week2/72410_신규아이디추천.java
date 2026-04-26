package week2;

public class Solution {
    /*
    문자열의 길이가 1000밖에 안되고 하나밖에 주지 않으니 단계 순서대로 풀어도 된다고 생각
    시간복잡도가 O(n^3) 가 되지 않는 이상 제출조건을 못말출 일은 없을 것이라 생각 (1000^3 = 10억)
    아스키코드를 활용하면 좀 더 수월하게 해결할 수 있을 것같지만 어차피 암기 못할테니 하나씩 잡아서 처리하기로 결정
    사용할 수 없는 특수문자(~!@#$%^&*()=+[{]}:?,<>/) 목록을 이용하면 좀 더 수월해지지 않을까 생각

    * 수정할 것 replaceAll 이라는 메서드를 알게됌 더 간편하게 문자열을 조작할 수 있음

    기본적인 정규식을 알아두면 좋을것같다고 생각
    String 관련 기본적인 메서드들 공부해둬야겠다고 생각

    시간복잡도 O(n) : replace로 인해 문자열 길이만큼 탐색하는데 걸리는 시간복잡도
     */
    public String solution(String s) {

        // 1단계
        s = s.toLowerCase();

        // 2단계
//        String[] special = new String[] {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(" ,"'" ,")", "=" ,"+" ,"[" ,"{", "]", "}", ",", ":", "?", "<", ">", "/"};
//        for(int i = 0; i < special.length; i ++) {
//            s = s.replace(special[i],"");
//        }

//        s = s.replaceAll("[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>/]", "");  둘 중하나 정규표현식
        s = s.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
//        1. s = s.replace("..", ".");  마침표가 세 개 이상인 경우 조건 탈락...  500번 돌려야하나? 나중에 수정하기
//        for(int i = 0; i < 500; i++) {
//            s = s.replace("..", ".");
//        }
//        2. while(s.contains("..")) {
//            s = s.replace("..", ".");
//        }
        // 3.
        s = s.replaceAll("\\.{2,}",".");

        // 4단계 여기서부터는 문자열이 비는 경우를 체크 charAt쓸 때 터질 수 있음
//        if(!s.isEmpty()) {
//            if (s.charAt(0) == '.') {
//                s = s.substring(1);
//            }
//        }
//        if(!s.isEmpty()) {
//            if(s.charAt(s.length() - 1) == '.' ) {
//                s = s.substring(0,s.length() - 1);
//            }
//        }

        if(s.startsWith(".")) {
            s = s.substring(1);
        }

        if(s.endsWith(".")) {
            s = s.substring(0,s.length() - 1);
        }


        // 5단계
        if(s.isEmpty()) {
            s = "a";
        }

        // 6단계

        if(s.length() >= 16) {
            s = s.substring(0,15);

            if(s.endsWith(".")) {
                s = s.substring(0,s.length() - 1);
            }
        }




        // 7단계
        if(s.length() == 1) {
//          s = s + s.charAt(0) + s.charAt(0);
            s = s.repeat(3);
        }

        if(s.length() == 2) {
            s = s + s.charAt(1);
        }

        return s;

    }
}
