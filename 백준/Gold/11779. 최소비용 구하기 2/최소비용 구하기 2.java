import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        route = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(end, dist));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        route[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.end] < cur.dist) continue;

            for (Node next : adj[cur.end]) {
                int ndist = dist[cur.end] + next.dist;
                if (ndist < dist[next.end]) {
                    dist[next.end] = ndist;
                    route[next.end] = cur.end;
                    pq.add(new Node(next.end, ndist));
                }
            }
        }

        sb.append(dist[end]).append("\n");

        ArrayList<Integer> way = new ArrayList<>();

        int f = end;

        while (f != 0) {
            way.add(f);
            f = route[f];
        }

        sb.append(way.size()).append("\n");

        for (int i = way.size() - 1; i >= 0; i--) {
            sb.append(way.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}