package swea.D3.암호생성기;

import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        for (int tc = 1; tc <= 10; tc++) {

            int T = Integer.parseInt(br.readLine());
            StringBuilder ans = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.countTokens() != 0) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            ans.append('#').append(T).append(" ");

            int cnt = 1;

            while (true) {

                int num = dq.pollFirst() - cnt;

                if (num <= 0) {
                    dq.offerLast(0);
                    break;
                }

                dq.offerLast(num);

                cnt++;

                if (cnt > 5) {
                    cnt = 1;
                }
            }

            while (dq.size() != 0) {
                ans.append(dq.pollFirst());
                ans.append(" ");
            }

            System.out.println(ans);
        }
    }
}
