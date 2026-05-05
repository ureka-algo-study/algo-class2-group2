public class Solution{
	
	/*
	 * 주어지는 숫자는 20개 이하 -> 2^20(백만) -> 완전탐색(다 더해도보고 빼기도 해보고)
	 * DFS로 탐색
	 */

	static int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(0,0,target,numbers); // dfs(합,깊이,목표숫자,배열)
		return answer;
	}
	public static void dfs(int sum, int depth, int target, int[]numbers) {
		if(depth == numbers.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		dfs(sum + numbers[depth], depth + 1, target, numbers);
		dfs(sum - numbers[depth], depth + 1, target, numbers);
	}
}
