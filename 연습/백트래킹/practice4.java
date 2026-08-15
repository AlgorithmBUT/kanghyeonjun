package 백트래킹;

import java.util.*;

// 중복 조합

public class practice4 {

  static int[] arr = {1,2,3,4,5,6};
  static List<Integer> lst = new ArrayList<>();
  public static void main(String[] args) {
    bt(0,0);
  }

  static void bt (int d, int start){
    if (d==3){
      System.out.println(lst);
      return;
    }

    for (int i=start; i<arr.length; i++){
      lst.add(arr[i]);
      bt(d+1, i);
      lst.remove(lst.size()-1);
    }

  }
}
