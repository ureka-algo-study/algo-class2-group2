import java.util.*;

public class Solution {

    static int curU = 0; // 현재 유저
    static int curS = 0; // 현재 서버
    static int countS = 0; // 증설된 서버의 수
    static Deque<int[]> dServer = new ArrayDeque<>();
    // [사라지는 시간, 수]

    public int solution(int[] players, int m, int k) {

        for(int i = 0; i < players.length; i ++) {
            curU = players[i];
            int need =  players[i] / m;

            // 사라지는 서버 확인 먼저 없애기
            if(!dServer.isEmpty() && dServer.peek()[0] == i) {
                int[] dis = dServer.poll();
                curS -= dis[1];
            }

            // 서버 증설이 필요한 경우
            if(curS < need) { // 현재 서버 < 필요한 서버
                dServer.offer(new int[] {i + k , need - curS});
                countS += need - curS;
                curS += need - curS;
            }

        } //for
        return countS;
    }

}
