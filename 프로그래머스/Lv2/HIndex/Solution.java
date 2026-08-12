package 프로그래머스.Lv2.HIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);

        int left = 0;
        int right = citations[citations.length-1];
        int result = 0;

        while (left<=right){
          int mid = (left+right)/2;
          if (check(mid, citations)){
            result=mid;
            left=mid+1;
          } else {
            right=mid-1;
          }
        }
        
        return result;
    }
    
    boolean check(int h, int [] arr){
      int cnt = 0;
      for (int a : arr){
        if (a>=h){
          cnt++;
        }
      }
      return cnt>=h;
    }
}
