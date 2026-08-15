package 재귀;

//n^m 구하기

import java.io.*;

public class practice1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    int target = Integer.parseInt(br.readLine());
    System.out.println(res(input ,target));
  }

  static int res (int n, int m){
    if (m==1){
      return n;
    }
    return n*res(n,m-1);
  }
}
