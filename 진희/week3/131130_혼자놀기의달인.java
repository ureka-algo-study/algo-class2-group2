import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	
	static int N, cnt;
    static boolean[] visited;

	public int solution(int[] cards) {
        int answer = 0;
        
        N = cards.length;
        visited = new boolean[N];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int cur = 0; cur < N; cur++) {
        	if (!visited[cur]) {
        		cnt = 0;
        		pq.offer(dfs(cur, cards));
        	}
        } //for - 카드 그룹 수 세기
        
        if (pq.size() < 2) return 0;
        
        answer = pq.poll() * pq.poll();       
        return answer;
    } //solution

	private Integer dfs(int cur, int[] cards) {
		visited[cur] = true;
		cnt++;
		
		int next = cards[cur] - 1;
		if (visited[next]) return cnt;
		
		return dfs(next, cards);
	} //dfs

}
