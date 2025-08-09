import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int ans = bfs(n, adj);
        System.out.println(ans);
    }

    private static int bfs(int n, ArrayList<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int dist = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : adj.get(cur)) {
                    if (visited[next]) continue;

                    q.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }

            dist++;
            if (dist == 2) break;
        }

        return cnt;
    }
}
