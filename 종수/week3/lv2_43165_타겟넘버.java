package 종수.week3;

class Solution {
    static int count;
    static int[] number;
    static int t;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        number = numbers.clone();
        t = target;
        

        dfs(0, 0);

        return count;
    }

    void dfs(int index, int sum){

        if(index == number.length){
            if( sum == t){
                count++;
            }
            return;
        }
        
        dfs( index + 1, sum + (-number[index]));
        dfs( index + 1, sum + number[index]);
    }
}






// DFS 풀이법
// class Solution {

//     static int arr[];
//     static int tg = 0;
//     static int count = 0;
//     // 숫자 배열의 조합으로 타겟넘버를 만들어라
//     public int solution(int[] numbers, int target) {
//         int answer = 0;

//         arr = numbers.clone();
//         tg = target;

//         dfs(0, 0);

//         answer = count;

//         return answer;
//     }
    
//     void dfs(int idx, int sum){
//         if( idx == arr.length){
//             if (sum == tg){
//                 count++;
//             }
//             return;
//         }

//         dfs(idx + 1, sum + arr[idx]);
//         dfs(idx + 1, sum - arr[idx]);
//     }
// }

// BFS 풀이법
// class Solution{
//     public int solution(int[] numbers, int target) {
//         int answer = 0;

//         Queue<int[]> queue = new ArrayDeque<>();
//         queue.offer(new int[]{0,0});

//         while(!queue.isEmpty()){
//             int[] now = queue.poll();
//             int sum = now[0];
//             int idx = now[1];

//             if ( idx == numbers.length){
//                 if( sum == target) answer++;
//                 continue;
//             }

//             queue.offer(new int[]{sum + numbers[idx], idx + 1});
//             queue.offer(new int[]{sum - numbers[idx], idx + 1});
//         }


//         return answer;
//     }

//     void bfs(){

//     }
// }