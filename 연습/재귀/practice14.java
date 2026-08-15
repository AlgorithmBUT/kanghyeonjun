package 재귀;

// 배열 뒤집기

import java.util.*;

public class practice14 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rec(0,arr.length-1, arr);
    System.out.println(Arrays.toString(arr));
  }

  static void rec (int left, int right, int[] arr){
    if (left>right){
      return;
    }
    int tmp=arr[left];
    arr[left]=arr[right];
    arr[right]=tmp;

    rec(left+1, right-1, arr);
  }
}
