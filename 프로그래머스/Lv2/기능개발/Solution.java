package 프로그래머스.Lv2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List <Integer> ans = new ArrayList<>();
        int idx = 0;
        while (true){
          //각 작업들 하루 진행
          for (int i=idx; i<progresses.length; i++){
            progresses[i]+=speeds[i];
          }
          //100이상 찾기
          int tmp=0;
          while (idx+tmp < progresses.length){
            if (progresses[idx+tmp]>=100){
              tmp++;
            } else{
              break;
            }
          }
          if (tmp!=0){
            ans.add(tmp);
            idx+=tmp;
          }
          if (idx ==progresses.length) break;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
