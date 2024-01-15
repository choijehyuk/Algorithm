import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static char[][] map;
    static boolean[][] v;
    static ArrayList<Point>[] door;
    static int h, w;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[] keys;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            keys = new boolean[26];
            v = new boolean[h + 2][w + 2];
            door = new ArrayList[26];
            answer = 0;

            for (int i = 0; i < door.length; i++) {
                door[i] = new ArrayList<>();
            }

            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= s.length(); j++) {
                    map[i][j] = s.charAt(j - 1);
                }
            }

            String key = br.readLine();

            if (!key.equals("0")) {

                for (int i = 0; i < key.length(); i++) {
                    keys[key.charAt(i) - 'a'] = true;
                }
            }
            bfs();
            sb.append(answer + "\n");
            //print(map);
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= h + 2 || nc >= w + 2) continue;
                if (map[nr][nc] == '*' || v[nr][nc]) continue;

                char now = map[nr][nc];
                // 문
                if (now - 'A' >= 0 && now - 'A' < 26) {
                    // 문 찾고 열쇠 있을 때
                    if (keys[now - 'A']) {
                        map[nr][nc] = '.';
                        v[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    }
                    // 문은 찾았는데 열쇠 없을 때
                    else {
                        door[now - 'A'].add(new Point(nr, nc));
                    }
                }

                // 열쇠
                if (now - 'a' >= 0 && now - 'a' < 26) {
                    keys[now - 'a'] = true;
                    v[nr][nc] = true;
                    q.add(new Point(nr, nc));

                    // 아까 못열은 문 다시 열기
                    for (int i = 0; i < 26; i++) {
                        if (keys[i]) {
                            for (int j = 0; j < door[i].size(); j++) {
                                Point pp = door[i].get(j);
                                v[pp.r][pp.c] = true;
                                map[pp.r][pp.c] = '.';
                                q.add(new Point(pp.r, pp.c));
                            }
                        }
                    }
                }

                // 문서
                if (now == '$') {
                    answer++;
                    v[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }

                // 빈공간
                if (now == '.') {
                    v[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }

            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}