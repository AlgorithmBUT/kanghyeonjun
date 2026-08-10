package 프로그래머스.Lv2.연속부분수열합의개수;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> nums = new HashSet<>();
        int[] circle = new int[elements.length * 2];
        int index=0;
        for (int k=0; k<=1; k++){
          for (int i : elements){
            circle[index++] = i;
          }
        }
        for (int i=1; i<=elements.length; i++){
          for (int j=0; j<elements.length; j++){
            int tmp = 0;
            for (int k=j; k<j+i; k++){
              tmp+=circle[k];
            }
            nums.add(tmp);
          }
        }
        return nums.size();
    }
}