package 프로그래머스.Lv2.올바른괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++){
            if (stack.size()==0){
                stack.offerLast(s.charAt(i));
            } else{
                if (s.charAt(i)==')'){
                    if (stack.peekLast()=='('){
                        stack.pollLast();
                    }
                } else{
                    stack.offerLast(s.charAt(i));
                }
            }
            System.out.println(stack);
        }
        return stack.size()==0? true : false;
    }
}