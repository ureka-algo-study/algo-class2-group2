package 종수.week3;

class Solution {

    static int arr[];
    static int tg = 0;
    static int count = 0;
    // 숫자 배열의 조합으로 타겟넘버를 만들어라 -> 순열문제
    public int solution(int[] numbers, int target) {
        int answer = 0;

        arr = numbers.clone();
        tg = target;

        dfs(0, 0);

        answer = count;

        return answer;
    }
    
    void dfs(int idx, int sum){
        if( idx == arr.length){
            if (sum == tg){
                count++;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum - arr[idx]);
    }
}