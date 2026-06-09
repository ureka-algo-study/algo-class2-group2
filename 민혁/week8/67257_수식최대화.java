import java.util.*;
class Solution {
    public long solution(String expression) {


        String[][] opers = {{"*","+","-"},{"*","-","+"},{"+","*","-"},{"+","-","*"},{"-","*","+"},{"-","+","*"}};


        int nFlag = 0; //자르기 시작할 위치
        List<String> list = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                list.add(expression.substring(nFlag,i)); //숫자 자르기
                list.add(expression.substring(i,i + 1)); //연산자 자르기
                nFlag = i + 1; //자르기 시작할 위치 업데이트
            }
        } //for
        list.add(expression.substring(nFlag)); //마지막 남은 숫자까지

        long max = 0L;

        //모든 경우의 우선순위 케이스 탐색
        for(int a = 0; a < opers.length; a ++) {
            //원본배열은 그대로 두고 임시로 쓸 리스트 생성
            List<String> temp = new ArrayList<>(list);
            String[] oper = opers[a]; //이번턴에 적용할 우선순위 {"*","+","-"}



            for(int i = 0; i < 3; i ++) {
                for(int j = 0; j < temp.size(); j++) {
                    if(temp.get(j).equals(oper[i])) { // 우선순위 연산자라면
                        long left = Long.parseLong(temp.get(j - 1));
                        long right = Long.parseLong(temp.get(j + 1));

                        long result = calculate(left,right,oper[i]);

                        temp.remove(j+1);
                        temp.remove(j);
                        temp.remove(j-1);

                        temp.add(j - 1, String.valueOf(result)); //계산된 결과를 다시 넣어주기
                        j -=2; // 리스트 요소수가 줄어들어 j를 보정(3->1)
                    }
                }//j
            }//i

            max = Math.max(max, Math.abs(Long.parseLong(temp.get(0))));
        } //a


        return max;
    }

    public long calculate(long left, long right, String oper) {
        if (oper.equals("*")) {
            return left * right;
        } else if (oper.equals("+")) {
            return left + right;
        } else {
            return left - right;
        }

    }
}