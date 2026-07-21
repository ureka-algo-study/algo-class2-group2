import java.util.*;

class Solution {

    class Song {
        String genre;
        int play;
        int idx;

        Song(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        List<Song> songs = new ArrayList<>();
        Map<String, Integer> totalPlay = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(genres[i], plays[i], i));
            totalPlay.put(genres[i],
                    totalPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        songs.sort((a, b) -> {

            if (!a.genre.equals(b.genre)) {
                return totalPlay.get(b.genre) - totalPlay.get(a.genre);
            }

            if (a.play != b.play) {
                return b.play - a.play;
            }

            return a.idx - b.idx;
        });

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for (Song song : songs) {

            int cnt = count.getOrDefault(song.genre, 0);

            if (cnt < 2) {
                answer.add(song.idx);
                count.put(song.genre, cnt + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
