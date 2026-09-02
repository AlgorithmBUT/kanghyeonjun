package swea.D4.사칙연산유효성검사;

import java.util.*;
import java.io.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    for (int tc=1; tc<=10; tc++){
      int N = Integer.parseInt(br.readLine());

      int answer=1;

      for (int i=0; i<N; i++){
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        st.nextToken();

        String second = st.nextToken();

        int remain = st.countTokens();

        if (remain==2){

          if (!isOperator(second)){
            answer=0;
          }
        } else if (remain==0){

          if(isOperator(second)){
            answer=0;
          }
        }
      }
      System.out.println("#" + tc + " " + answer);
    }  
  }

  static boolean isOperator(String second){
    return second.equals("+") || second.equals("-") || second.equals("*") || second.equals("/");
  }
}
