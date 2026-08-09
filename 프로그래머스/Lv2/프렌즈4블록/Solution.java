package 프로그래머스.Lv2.프렌즈4블록;

import java.util.*;

class Solution {

    static final int[] dy = {0, 1, 1};
    static final int[] dx = {1, 1, 0};

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // boardd 초기화
        char[][] boardd = new char[m][n];
        for (int i = 0; i < m; i++) {
            boardd[i] = board[i].toCharArray();
        }

        // 블록 실행
        boolean flag = true;
        while (flag) {
            // 지워질 블록들 찾기
            Set<List<Integer>> del = new HashSet<>();
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    char cur = boardd[y][x];
                    // 이미 지워진 블록은 검사하지 않기
                    if (cur == ' ') {
                        continue;
                    }
                    int same = 0;
                    for (int d = 0; d < 3; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (ny >= m || nx >= n) {
                            break;
                        }
                        if (boardd[ny][nx] == cur) {
                            same++;
                        }
                    }
                    if (same == 3) {
                        del.add(Arrays.asList(y, x));
                        del.add(Arrays.asList(y + 1, x));
                        del.add(Arrays.asList(y + 1, x + 1));
                        del.add(Arrays.asList(y, x + 1));
                    }
                }
            }
            answer += del.size();
            // 종료조건
            if (del.size() == 0) {
                flag = false;
            }

            if (!flag) {
                break;
            }
            // 블록 지우기
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (del.contains(Arrays.asList(y, x))) {
                        boardd[y][x] = ' ';
                    }
                }
            }
            // 블록 당기기
            for (int x = 0; x < n; x++) {
                int down = m - 1;
                for (int y = m - 1; y >= 0; y--) {
                    if (boardd[y][x] != ' ') {
                        boardd[down][x] = boardd[y][x];
                        down--;
                    }
                }
                // 남은 위쪽 공간 비우기
                for (int y = down; y >= 0; y--) {
                    boardd[y][x] = ' ';
                }
            }
        }
        return answer;
    }
}