package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] visit;
    static int[][] table;
    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        visit = new int[row][col];
        table = new int[row][col];

        // 북 동 남 서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 초기화
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> pictures = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // bfs
                int size = 0;

                if (visit[i][j] == 0 && table[i][j] == 1)
                    q.add(new Integer[]{i,j});

                while (!q.isEmpty()) {
                    Integer[] coordinate = q.poll();
                    int y = coordinate[0];
                    int x = coordinate[1];

                    if (visit[y][x] != 1) {
                        visit[y][x] = 1; size++;
//                        System.out.printf("{%d, %d}", x, y);
                    }

                    for (int direction = 0; direction < 4; direction++) {

                        int nextX = x + dx[direction];
                        int nextY = y + dy[direction];

                        if (!isInBoundary(nextX, col, nextY, row)) continue;
                        if ( (visit[nextY][nextX] == 0) && (table[nextY][nextX] == 1) ) {
                            q.add(new Integer[]{nextY, nextX});
                        }
                    }

                }
//                System.out.println(size);
                if (size > 0) {
                    pictures.add(size);
                }

            }

        }

        Integer MAX_SIZE = pictures.stream().max(Integer::compare).get();
        System.out.println(MAX_SIZE);



    }

    static public boolean isInBoundary(int x, int col, int y, int row) {
        if (( x >= 0 && x < col ) && ( y >= 0 && y < row )) {
            return true;
        } else {
            return false;
        }
    }

}
