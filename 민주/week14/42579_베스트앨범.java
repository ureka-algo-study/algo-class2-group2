import java.util.*;

class Solution {
    
    class Song{
        int num;
        int play;
        
        Song(int num, int play){
            this.num = num;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genreOrder = new ArrayList<>(map.keySet());
        
        genreOrder.sort((a,b) -> map.get(b) - map.get(a));
        
        HashMap<String, List<Song>> songMap = new HashMap<>();
        
        
        for(String genre : genreOrder){
            songMap.put(genre, new ArrayList<Song>());
        }
        
        for(int i=0; i<genres.length; i++){
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        for(String genre : genreOrder){
            songMap.get(genre).sort((a,b) -> b.play - a.play);
            
            int i = 0;
            
            while(i<2 && i <songMap.get(genre).size()){
                ans.add(songMap.get(genre).get(i++).num);
            }
        }
        
        int[] answer = ans.stream().mapToInt(i->i).toArray();
         
        
        return answer;
    }
}