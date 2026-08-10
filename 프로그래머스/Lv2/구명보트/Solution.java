package 프로그래머스.Lv2.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left=0, right=people.length-1;

        while (left<=right){
          if (people[right]+people[left]<=limit){
            left++;
            right--;
          } else {
            right--;
          }
          answer++;
        }
        return answer;
    }
}