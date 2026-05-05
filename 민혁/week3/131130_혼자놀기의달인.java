import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    /*
   각각의 사이클 길이를 구하고
   가장 큰 사이클 두개를 곱한것이 최고 점수
   */
    static boolean[] visited;
    public int solution(int[] cards) {

        List<Integer> cycles = new ArrayList<>(); //사이클의 길이를 담을 배열
        visited = new boolean[cards.length]; // 카드 검사 유무

        for(int i = 0 ; i < cards.length; i ++) {
            if(visited[i]) continue; // 이미 방문했으면 continue;

            int cnt = 0; // 사이클의 길이 변수

            int cur = i; // 인덱스가 현재 위치


            while(!visited[cur]) {
                visited[cur] = true;
                cnt++;
                cur = cards[cur] - 1;
            }
            cycles.add(cnt);
        } //for i

        Collections.sort(cycles,Collections.reverseOrder());



        if(cycles.size() < 2) {
            return 0;
        }

        return cycles.get(0) * cycles.get(1);
    } //solution
}
