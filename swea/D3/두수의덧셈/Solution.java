package swea.D3.두수의덧셈;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            BigInteger sum = a.add(b);

            sb.append("#").append(tc).append(" ").append(sum);
            System.out.println(sb);
        }
    }
}