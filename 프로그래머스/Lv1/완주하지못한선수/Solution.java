package 프로그래머스.Lv1.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder ans = new StringBuilder();

        //map 만들기
        Map<String, Integer> compl = new HashMap<>();
        for (String name : completion){
          compl.put(name, compl.getOrDefault(name, 0)+1);
        }

        //찾기
        for (String person : participant){
          if (compl.containsKey(person)){
            if (compl.get(person)>0){
            compl.put(person,compl.get(person)-1);
            } else {
              ans.append(person);
              break;
            }
          } else{
            ans.append(person);
            break;
          }
        }
      return ans.toString();
    }
}
