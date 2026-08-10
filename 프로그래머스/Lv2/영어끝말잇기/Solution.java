package 프로그래머스.Lv2.영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int [] ans = new int[2];
        Deque <String> dq = new ArrayDeque<>();
        Set<String> word = new HashSet<>();
        int num = 0;
        for (int i=0; i<words.length; i++){
          if( word.contains(words[i])){
            num++;
            break;
          } else{
            if (dq.size()==0){
            dq.offer(words[i]);
            num++;
            } else{
              if (dq.peekLast().charAt(dq.peekLast().length()-1)==words[i].charAt(0)){
                dq.offer(words[i]);
                num++;
              } else{
                num++;
                break;
              }
            }
            word.add(words[i]);
          }
        }
        System.out.println(dq.peekLast());
        if (dq.peekLast()==words[words.length-1]){
          ans[0]=0;
          ans[1]=0;
        } else{
          ans[0] = num%n==0? n:num%n;
          ans[1] = (num-1)/n + 1;
        }
        return ans;
    }
}