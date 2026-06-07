import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (i1,i2) -> i2 - i1);



        for(int i = 0; i < enemy.length; i ++) {

            pq.offer(enemy[i]); // 매 라운드 적군의 수를 저장(큰 순서대로)

            n -= enemy[i]; // 라운드 시작 시마다 병사의 숫자를 줄임

            if(n < 0 && k == 0) { // 이번 라운드 실패 && 남은 무적권도 없음
                return i ;
            }

            if(n < 0 && k != 0) { // 이번 라운드 실패 && 무적권은 남음
                n += pq.poll();
                k--;
            }


        }

        return enemy.length;

    }
}