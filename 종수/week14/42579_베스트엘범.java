package 종수.week14;
import java.util.*;

//1. 장르로 묶어서 플레이수 덧셈 하고 그 결과로 정렬

//2. 장르별로 2개씩 뽑고 다음으로 장르로 넘어감
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생 수
        Map<String, Integer> totalPlays = new HashMap<>();

        // 장르별 재생 수 합산
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            totalPlays.put(
                    genre,
                    totalPlays.getOrDefault(genre, 0) + plays[i]);
        }

        // Map의 장르 이름들을 List로 변환
        List<String> genreOrder = new ArrayList<>(totalPlays.keySet());

        // 총 재생 수가 많은 장르부터 정렬
        genreOrder.sort((genre1, genre2) -> Integer.compare(
                totalPlays.get(genre2),
                totalPlays.get(genre1)));

        System.out.println(totalPlays);
        System.out.println(genreOrder);

        return new int[] {};
    }
}