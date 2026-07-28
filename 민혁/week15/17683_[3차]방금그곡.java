import java.util.*;
import java.util.stream.*;

class Solution {
    
    class music {
        int playTime;
        String title;
        String melody;
        
        music(int playTime, String title, String melody) {
            this.playTime = playTime;
            this.title = title;
            this.melody = melody;
        }
    }
    public String solution(String m, String[] musicinfos) {
        
        /* 재생된 시간, 제목, 재생멜로디 
        
        1. 재생멜로디를 어떻게 구할까?
        
        재생멜로디가 m 을 포함하고 있는것만 남김
        size가 1일경우 그대로 정답반환
        size가 0일 경우 none 반환
        size가 >= 2 일 경우 재생된 시간순으로 정렬
        list.get 0 list.get1이 같을 경우 get0을 반환
        */
        
        final String target = m
            .replace("C#","c")
            .replace("D#","d")
            .replace("F#","f")
            .replace("G#","g")
            .replace("A#","a");
        
        List<music> list = new ArrayList<>();
        for(int i = 0; i < musicinfos.length; i ++) {
            String thisMusic = musicinfos[i];
            String[] parsing = thisMusic.split(",");
            
            String[] parsed1 = parsing[0].split(":");
            int start = Integer.parseInt(parsed1[0]) * 60 + Integer.parseInt(parsed1[1]);
            String[] parsed2 = parsing[1].split(":");
            int end = Integer.parseInt(parsed2[0])* 60 + Integer.parseInt(parsed2[1]);
            
            int playTime = end - start;
            String title = parsing[2];
            String melody = parsing[3];
            melody = melody.replace("C#","c");
            melody = melody.replace("D#","d");
            melody = melody.replace("F#","f");
            melody = melody.replace("G#","g");
            melody = melody.replace("A#","a");
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < playTime; j ++) {
                sb.append(melody.charAt(j % melody.length()));
            }
            String realMelody = sb.toString();
            
            list.add(new music(playTime,title,realMelody));
        }
        
        list = list.stream().filter(i -> i.melody.contains(target)).collect(Collectors.toList());
        
        if(list.size() == 1) {
            return list.get(0).title;
        }
        
        if(list.size() >= 2) {
            list.sort( (i1, i2) -> i2.playTime - i1.playTime);
            return list.get(0).title;
        }
        
         return "(None)";
        
        
            
        
    }
}
