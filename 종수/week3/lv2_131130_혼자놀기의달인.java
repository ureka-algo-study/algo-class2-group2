package 종수.week3;
class Solution {

    static boolean visited[];
    static int arr[];
    public int solution(int[] cards) {
        int answer = 0;
        arr = cards.clone();
        visited = new boolean[cards.length];

        int max = 0, max2 = 0;
        int tmp = 0;
        for(int i = 0; i < cards.length; i++){ // 한번씩 다 돌아야 하니까
            int size = dfs(i);
            if(size >= max2){ // 결과 중 가장 큰 값을 찾기위해 큰값 2개를 선별
                max2 = size;
                if(max2 > max){
                    tmp = max;
                    max = max2;
                    max2 = tmp;
                }
            }
        }

        answer = max * max2;
        return answer;
    }

    int dfs(int n){
        int count = 0;
        
        while(!visited[n]){
            visited[n] =true;
            n = arr[n] - 1;
            count++;
        }

        return count;

    }
}


// 1부터 100까지 숫자가 적힌 카드 준비
// 2이상 100 이하의 자연수 하나를 정해 그 수보다 작거나 같은 카드들을 추출
// 추출한 카드의 숫자와 같은 갯수의 상자 준비

// 상자에 카드를 한장씩 넣고 무작위로 섞어 일렬로 나열
// 나열된 상자에 1번부터 순서대로 번호를 부여
// 


// 중략

// 최고점수 2개를 구해라
// 큰 수 2개 구해서 곱하기
