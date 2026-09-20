package swea.D5.현주가좋아하는제곱근놀이;

import java.io.*;

public class Solution {

    static BufferedReader br;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            long cnt = 0;

            while (N != 2) {
                long nn = (long) Math.sqrt(N);

                if (nn * nn == N) {
                    N = nn;
                    cnt++;
                } else {
                    long nxt = nn + 1;
                    long nxtPow = nxt * nxt;

                    cnt += nxtPow - N;
                    N = nxtPow;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}