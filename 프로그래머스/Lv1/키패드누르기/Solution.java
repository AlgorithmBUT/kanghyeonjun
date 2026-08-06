package 프로그래머스.Lv1.키패드누르기;

import java.util.*;

class Solution {

    //손가락 위치
    static int[] left = {0,3};
    static int[] right = {2,3};

    public String solution(int[] numbers, String hand) {
        
        //스마트폰 버튼 위치
        Map<Integer, int[]> phone = new HashMap<>();
        phone.put(1, new int[]{0,0});
        phone.put(2, new int[]{1,0});
        phone.put(3, new int[]{2,0});
        phone.put(4, new int[]{0,1});
        phone.put(5, new int[]{1,1});
        phone.put(6, new int[]{2,1});
        phone.put(7, new int[]{0,2});
        phone.put(8, new int[]{1,2});
        phone.put(9, new int[]{2,2});
        phone.put(0, new int[]{1,3});

        
        //numbers 탐색
        StringBuilder ans = new StringBuilder();
        for (int num : numbers){
          if (num==1 || num==4 || num==7){
            ans.append('L');
            change_l(num, phone);
          } else if (num==3 || num==6 ||num==9){
            ans.append('R');
            change_r(num, phone);
          } else{
            int ty = phone.get(num)[1];
            int tx = phone.get(num)[0];
            int leftlen = Math.abs(ty-left[1]) + Math.abs(tx-left[0]);
            int rightlen = Math.abs(ty-right[1]) + Math.abs(tx-right[0]);
            if (leftlen < rightlen){
              ans.append('L');
              change_l(num, phone);
            } else if (rightlen < leftlen){
              ans.append('R');
              change_r(num, phone);
            } else{
              if (hand.equals("right")){
                ans.append('R');
                change_r(num, phone);
              } else{
                ans.append('L');
                change_l(num, phone);
              }
            }
          }
        }
        return ans.toString();
    }
    //왼손가락 옮기기
    void change_l(int num, Map<Integer, int[]> phone){
      left[0]=phone.get(num)[0];
      left[1]=phone.get(num)[1];
    }
    //오른손가락 옮기기
    void change_r(int num, Map<Integer, int[]> phone){
      right[0]=phone.get(num)[0];
      right[1]=phone.get(num)[1];
    }
}