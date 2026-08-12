package 프로그래머스.Lv2.의상;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> category = new HashMap<>();
        for (String [] tmp : clothes){
          category.putIfAbsent(tmp[1], new ArrayList<>());
          category.get(tmp[1]).add(tmp[0]);
        }

        for (String str : category.keySet()){
          answer*=(category.get(str).size()+1);
        }
        return answer-1;
    }
}
