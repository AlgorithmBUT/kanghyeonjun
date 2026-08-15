package 재귀;

// 배열에서 두 번째로 큰 값 구하기

public class practice12 {
  public static void main(String[] args) {
    int [] arr = {15,12,2134,1421,13,2,31,231,421};

    int result = rec(0, arr, Integer.MIN_VALUE, Integer.MIN_VALUE);

    if (result==Integer.MIN_VALUE){
      System.out.println(-1);
    } else{
      System.out.println(result);
    }
  }

  static int rec (int idx, int[] arr, int max2, int max){
    if (arr.length==0){
      return Integer.MIN_VALUE;
    }
    if (idx==arr.length){
      return max2;
    }
    if (arr[idx]>max){
      max2=max;
      max=arr[idx];
    } else if (arr[idx]<max && arr[idx]>max2) {
        max2=arr[idx];
    }
    return rec (idx+1, arr, max2, max);
  }
}
