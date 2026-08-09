package 프로그래머스.Lv2.귤고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> gb = new HashMap<>();
        for (int s : tangerine){
          gb.put(s, gb.getOrDefault(s, 0)+1);
        }
        //map에서 갯수만 빼오기
        List<Integer> cnt = new ArrayList<>();
        for (int i : gb.values()){
          cnt.add(i);
        }
        //내림차순
        cnt.sort(Comparator.reverseOrder());
        //최솟값 구하기
        int answer = 0;
        int tmp=0;
        for (int i : cnt){
          tmp+=i;
          answer++;
          if (tmp>=k){
            break;
          }
        }
        return answer;
    }
}