package 프로그래머스.Lv4.징검다리;

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {

        // 바위 사이의 거리
        List<Integer> dist = new ArrayList<>();
        
        Arrays.sort(rocks);
        dist.add(rocks[0]-0);
        for (int i=0; i< rocks.length-1; i++){
          dist.add(rocks[i+1]-rocks[i]);
        }
        dist.add(distance-rocks[rocks.length-1]);

        // 이분 탐색
        int left = 0;
        int right = distance;

        while (left<=right){
          int mid = (left+right)/2;
          
          int removeRocks = 0;

          int curDist = 0;

          for (int i=0; i<dist.size(); i++){
            curDist+=dist.get(i);
            if (curDist<mid){
              removeRocks++;
            } else {
              curDist=0;
            }
          }

          if (removeRocks<=n){
            left=mid+1;
          }

          if (removeRocks>n){
            right=mid-1;
          }
        }
        
        return right;
    }
}
