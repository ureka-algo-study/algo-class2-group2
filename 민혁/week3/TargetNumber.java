package week3;

public class TargetNumber {
	
	/*
	 * 주어지는 숫자는 20개 이하 -> 2^20(백만) -> 완전탐색(다 더해도보고 빼기도 해보고)
	 * DFS로 탐색
	 */
	
	static int count = 0; 
	
	public static void main(String[] args) {
		int[] numbers = new int[] {4,1,2,1};
		int target = 4;

		dfs(0,target,0,numbers);
		System.out.println(count);
	}

	private static void dfs(int depth, int target, int sum, int[]numbers) {
		if(depth == numbers.length) {
			if(sum == target) {
				count++;
			}
			return;
		}

		dfs(depth + 1 , target, sum + numbers[depth], numbers);
		dfs(depth + 1 , target, sum - numbers[depth], numbers);
		
		
		
	}
}
