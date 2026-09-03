package swea.D3.규영이와인영이의카드게임;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;

    static List<Integer> gyCard; // 규영이 카드 목록
    static List<Integer> iyCard; // 인영이 카드 목록
    static int gyCnt;            // 규영이가 이긴 경우
    static int iyCnt;            // 인영이가 이긴 경우

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            gyCard = new ArrayList<>();
            iyCard = new ArrayList<>();

            for (int i = 0; i < 9; i++) {
                gyCard.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= 18; i++) {
                if (!gyCard.contains(i)) {
                    iyCard.add(i);
                }
            }

            gyCnt = 0;
            iyCnt = 0;

            dfs(0, 0, 0, new boolean[9]);

            System.out.println("#" + tc + " " + gyCnt + " " + iyCnt);
        }
    }

    // d = 현재 라운드, gySum = 현재 규영이 점수, iySum = 현재 인영이 점수 
    // visited[i] = 인영이의 i번째 카드 사용 여부
    static void dfs(int d, int gySum, int iySum, boolean[] visited) {
        if (d == 9) {
            if (gySum > iySum) {
                gyCnt++;
            } else if (iySum > gySum) {
                iyCnt++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;

                // 규영이가 이기는 경우
                if (gyCard.get(d) > iyCard.get(i)) {
                    dfs(d + 1, gySum + gyCard.get(d) + iyCard.get(i), iySum, visited);
                }
                // 인영이가 이기는 경우
                else {
                    dfs(d + 1, gySum, iySum + gyCard.get(d) + iyCard.get(i), visited);
                }

                visited[i] = false;
            }
        }
    }
}
