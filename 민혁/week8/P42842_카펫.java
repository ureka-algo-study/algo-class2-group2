
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {

        // 노란색의 모양을 먼저 잡음
        // brown24 yellow24 에서 yellow 는 (24 1) (12 2) (8 3) (6 4)
        // 각각의 배열이 맞는지 검증 수행 brown으로 감쌀 수 있을지
        // 1. 26 + 26 + 1 + 1 / 14 + 14 + 2 + 2 / 10 + 10 + 3 + 3 / 8 + 8 + 4 + 4
        // 위 조건에 맞는 값 return

        int[] answer = {};
        List<int[]>yellows = new ArrayList<>(); // yellow 타일 모양이 될 수 있는 후보들
        // 1. yellow 경우의 수 구하기
        for(int i = 1; i * i <= yellow; i++) { //가로가 세로의 길이보다 같거나 크니 제곱근만큼만 시행

            if(yellow % i == 0 ) { // 나누어 떨어지면 가능후보에 추가
                yellows.add(new int[]{yellow / i, i});
            }
        }

        //2.각각의 배열 검증
        for (int[] y : yellows) {
            if((y[0] + 2) * 2 + y[1] * 2 == brown) {
                return  new int[] {(y[0] + 2),y[1]+2};
            }
        }

        return answer;


    }
}