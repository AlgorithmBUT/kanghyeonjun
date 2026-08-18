package 프로그래머스.Lv2.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize==0){
          return 5*cities.length;
        }
        for (String city : cities){
          city=city.toLowerCase();
          
          if (cache.size()<cacheSize){
            if (!cache.contains(city)){
              cache.add(city);
              answer+=5;
            } else {
              cache.remove(city);
              cache.add(city);
              answer+=1;
            }
          } else{
            if (!cache.contains(city)){
              cache.remove(0);
              cache.add(city);
              answer+=5;
            } else {
              cache.remove(city);
              cache.add(city);
              answer+=1;
            }
          }
        }
        return answer;
    }
}

