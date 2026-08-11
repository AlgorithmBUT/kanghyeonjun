package 프로그래머스.Lv2.괄호회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()){
          dq.offer(c);
        }

        for (int i=0; i<s.length(); i++){
          dq.offerLast(dq.pollFirst());
          List<Character> lst = new ArrayList<>(dq);
          Deque<Character> stack = new ArrayDeque<>();
          boolean flag = true;

          for (int j=0; j<lst.size(); j++){
            char c = lst.get(j);

            if (c=='(' || c=='{' || c=='['){
              stack.offerLast(c);
            } else{
              if (stack.size()==0){
                flag=false;
                break;
              }

              char top = stack.pollLast();

              if (c==')' && top!='('){
                flag=false;
                break;
              } else if (c=='}' && top!='{'){
                flag=false;
                break;
              } else if (c==']' && top!='['){
                flag=false;
                break;
              }
            }
          }

          if (flag && stack.size()==0){
            answer++;
          }
        }
        return answer;
    }
}