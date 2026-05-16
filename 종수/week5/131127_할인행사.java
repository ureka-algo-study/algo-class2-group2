package 종수.week5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        } //map에 필요한 음식, 갯수 입력

        

        for(int i = 0; i <= discount.length - 10; i++){
            Map<String, Integer> temp = new HashMap<>(map);
            for(int j = i; j < i + 10; j++){    
                String item = discount[j];

                if(temp.containsKey(item) && temp.get(item) != 0)
                    temp.put(item, temp.get(item) - 1);

            }//for   

            boolean check = true; // 모든 갯수가 0인지 확인하는 변수
            for(int x : temp.values()){
                if (x != 0){ // 0이 아닌게 하나라도 있으면
                    check = false; //check에 false
                    break;
                }
            }

            if(check) //check 가 true라면 모든값이 0이었단 말이니까
                answer++; //인덱스와 일수 간의 차이 보정

        }

        
        return answer;
    } //solution
}// class