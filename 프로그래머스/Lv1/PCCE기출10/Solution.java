package 프로그래머스.Lv1.PCCE기출10;

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        //ext Map
        Map<String, Integer> mext = new HashMap<>();
        mext.put("code", 0);
        mext.put("date", 1);
        mext.put("maximum", 2);
        mext.put("remain", 3);

        //기준에 맞는 데이터 넣기
        List <int[]> ans = new ArrayList<>();
        for (int [] day : data){
            if (day[mext.get(ext)]<val_ext){
              ans.add(day);
            }
        }

        //정렬하기
        ans.sort((a,b) -> {
          return Integer.compare(a[mext.get(sort_by)], b[mext.get(sort_by)]);
        });

        //정답 배열
        int[][] res = new int[ans.size()][];
        for (int i=0; i<ans.size(); i++){
          res[i] = ans.get(i);
        }
        return res;
    }
}
