import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int start, cnt;

        public Node(int start, int cnt) {
            this.start = start;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    static int a, b, N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        int answer = solve();
        System.out.println(answer);

    }

    private static int solve() {
        boolean[] v = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[a] = 0;
        v[a] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a,0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.start == b) break;

            for (int i = 1; i <= N; i++) {
                if(arr[cur.start][i] == 1 && !v[i]){
                    dist[i] = cur.cnt+1;
                    v[i] = true;
                    q.add(new Node(i, cur.cnt+1));
                }
            }
        }

        return dist[b] == Integer.MAX_VALUE? -1 : dist[b];

    }
}