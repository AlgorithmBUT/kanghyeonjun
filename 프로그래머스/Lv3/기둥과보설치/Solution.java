package 프로그래머스.Lv3.기둥과보설치;

import java.util.*;

class Solution {
    //기둥과 보 목록
    static Set<List<Integer>> wall = new HashSet<>();
    static Set<List<Integer>> bo = new HashSet<>();

    public int[][] solution(int n, int[][] build_frame) {
        
        for (int i=0; i<build_frame.length; i++){
          int x = build_frame[i][0]; // x 좌표
          int y = build_frame[i][1]; // y 좌표
          int a = build_frame[i][2]; // 0: 기둥, 1: 보 
          int b = build_frame[i][3]; // 0: 제거, 1: 설치
          // 설치
          if (b==1){
            if (a==0){
              if (canwall(x,y)){
                wall.add(Arrays.asList(x,y,0));
              }
            } else{
              if (canbo(x,y)){
                bo.add(Arrays.asList(x,y,1));
              }
            }
          } else { // 제거
            // 일단 제거하고
            if (a==0){
              wall.remove(Arrays.asList(x,y,0));
            } else {
              bo.remove(Arrays.asList(x,y,1));
            }
            // 나머지를 전부 다 설치할 수 있는지 check함수로 확인하고, 
            // 설치를 못 한다면 다시 추가
            if (!check()){
              if (a==0){
                wall.add(Arrays.asList(x,y,0));
              } else {
                bo.add(Arrays.asList(x,y,1));
              }
            }
          }
        }

        // 모든 구조물 목록
        int[][] res = new int[wall.size()+bo.size()][3];
        int i=0;
        for (List<Integer> lst : wall){
          res[i][0]=lst.get(0);
          res[i][1]=lst.get(1);
          res[i][2]=lst.get(2);
          i++;
        }
        for (List<Integer> lst : bo){
          res[i][0]=lst.get(0);
          res[i][1]=lst.get(1);
          res[i][2]=lst.get(2);
          i++;
        }

        // 정렬
        Arrays.sort(res, (a,b) -> {
          if (a[0]==b[0]){
            if (a[1]==b[1]){
              return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
          }
          return Integer.compare(a[0], b[0]);
        });
        return res;
  }

  //기둥 설치 가능?
  boolean canwall(int x, int y){
    //바닥
    if (y==0){
      return true;
    }
    //기둥 위
    if (wall.contains(Arrays.asList(x,y-1,0))){
      return true;
    }
    //보 위
    if (bo.contains(Arrays.asList(x,y,1)) || bo.contains(Arrays.asList(x-1,y,1))){
      return true;
    }
    return false;
  }

  //보 설치 가능?
  boolean canbo(int x, int y){
    //기둥 위
    if(wall.contains(Arrays.asList(x,y-1,0))){
      return true;
    }
    //오른쪽에 기둥
    if(wall.contains(Arrays.asList(x+1,y-1,0))){
      return true;
    }
    //양쪽에 보
    if(bo.contains(Arrays.asList(x-1,y,1)) && bo.contains(Arrays.asList(x+1,y,1))){
      return true;
    }
    return false;
  }

  //모두 설치 가능한지 체크
  boolean check(){
    //기둥
    for (List<Integer> lst : wall){
      int x=lst.get(0);
      int y=lst.get(1);
      if (!canwall(x,y)){
        return false;
      }
    }
    //보
    for (List<Integer> lst : bo){
      int x=lst.get(0);
      int y=lst.get(1);
      if (!canbo(x,y)){
        return false;
      }
    }
    return true;
  }
}