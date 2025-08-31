import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static class Node {
        int r, c, size;

        public Node(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][M];
        List<Node> list = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                for (int k = 1; k <= 100; k++) {
                    if (i - k < 0 || j + k >= M || i + k >= N || j - k < 0) break;


                    if (map[i][j] == '*' && map[i - k][j] == '*' && map[i][j + k] == '*' && map[i + k][j] == '*' && map[i][j - k] == '*') {
                        visited[i][j] = true;
                        visited[i - k][j] = true;
                        visited[i][j + k] = true;
                        visited[i + k][j] = true;
                        visited[i][j - k] = true;
                        list.add(new Node(i + 1, j + 1, k));
                    } else {
                        break;
                    }
                }

            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).r + " " + list.get(i).c + " " + list.get(i).size);
        }

//        print(map, N, M);
    }

    private static void print(char[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
