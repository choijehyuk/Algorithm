import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, T;
    static ArrayList<Integer>[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        stone = new ArrayList[200001];
        for (int i = 0; i < 200001; i++) {
            stone[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stone[y].add(x);
        }

        for (int i = 0; i < stone.length; i++) {
            Collections.sort(stone[i]);
        }

        bfs();
        System.out.println("-1");

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Node cur = q.poll();

                if (cur.c == T) {
                    System.out.println(cnt);
                    System.exit(0);
                }
                for (int c = cur.c - 2; c <= cur.c + 2; c++) {
                    if (c < 0 || c >= 200001) continue;

                    for (int j = 0; j < stone[c].size(); j++) {
                        int r = stone[c].get(j);
                        if (cur.r + 2 < r) break;
                        else if (cur.r - 2 > r) continue;

                        stone[c].remove(j);
                        q.add(new Node(r, c));
                        j--;
                    }
                }
            }
            cnt++;
        }
    }
}