package week3;

public class GameMap {
	
	/*
	 * 0은 벽 1은 길
	 * 제한조건 100 * 100 지도, 최대 1만
	 * 
	 */
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static int count = 0;
	
	public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        dfs(new int[] {0,0}, new int[] {maps.length,maps[0].length});
        return answer;
    }

	private int dfs(int[] position, int[] target) {
		if(position == target) {
			return count;
		}
		
		visited[position[0]][position[1]] = true;
		
		for(int i = 0; i < dx.length; i++) {
			int[] newPosition = {position[0] + dx[i],position[1] + dy[i]};
			if(newPosition[0] >= 0 && newPosition[0] < visited.length && newPosition[1] >= 0 && newPosition[1] < visited[0].length) {
				if(!visited[newPosition[0]][newPosition[1]]) {
					count++;
					dfs(newPosition,target);
				}
			}
		}
		
		// 만약 끝까지 못찾았다?
		return -1;
	}
	

}
