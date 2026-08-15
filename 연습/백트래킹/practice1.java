package 백트래킹;

//중복 순열

import java.util.*;

public class practice1 {
  public static void main(String[] args) {
    bt(0, new int[]{1,2,3,4,5}, new ArrayList<>());
  }

  static void bt(int d, int[] arr, List<Integer> lst){
    if (d==3){
      System.out.println(lst.toString());
      return;
    }
    for (int i=0; i<arr.length; i++){
      lst.add(arr[i]);
      bt(d+1, arr, lst);
      lst.remove(lst.size()-1);
    }
    
  }
}
