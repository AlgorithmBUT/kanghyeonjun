package 재귀;

// 재귀로 이진 탐색 구현

public class practice16 {
  public static void main(String[] args) {
    int[] arr = {1, 4, 7, 10, 15, 19, 25};
    int target1 = 15;
    int target2 = 38;
    System.out.println(rec(0, arr.length-1, arr, target1));
    System.out.println(rec(0, arr.length-1, arr, target2));
  }

  static int rec (int start, int end, int[] arr, int target){

    if (start>end){
      return -1;
    }

    int mid = (start+end)/2;
    if (arr[mid]==target){
      return mid;
    } else if (arr[mid]>target){
      return rec(start,mid-1, arr, target);
    } else {
      return rec(mid+1, end, arr, target);
    }

  }
}
