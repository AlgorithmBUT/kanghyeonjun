package 재귀;

//주어진 2차원 배열을 사각형 형태로 출력

public class practice7 {
  public static void main(String[] args) {
    int[][] arr2 = { { 11, 12, 13 }, { 20, 30, 40 } };
    System.out.println(rec(arr2,0,0));
  }

  static StringBuilder sb = new StringBuilder();

  static String rec (int[][] arr, int y, int x){
    if (y==arr.length){
      return sb.toString();
    }

    if (x==arr[y].length){
      sb.append("\n");
      return rec(arr, y+1, 0);
    }

    sb.append(arr[y][x]).append(" ");

    return rec(arr, y, x+1);
  }
}