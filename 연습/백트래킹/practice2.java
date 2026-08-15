package 백트래킹;

//순열

import java.util.*;

public class practice2 {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    bt(0, arr, new ArrayList<>(), new boolean[arr.length]);
  }

  static void bt(int d, int[] arr, List<Integer> lst, boolean[] visited){
    if (d==3){
      System.out.println(lst.toString());
      return;
    }

    for (int i=0; i<arr.length; i++){
      if (!visited[i]){
        lst.add(arr[i]);
        visited[i] = true;

        bt(d+1, arr, lst, visited);

        lst.remove(lst.size()-1);
        visited[i] = false;
      }
    }
  }
}