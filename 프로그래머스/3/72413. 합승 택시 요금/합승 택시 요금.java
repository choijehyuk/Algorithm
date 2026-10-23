import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int start, end, cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = 100_000_000;
    static int n, s, a, b;
    static int[][] fares;
    static ArrayList<Node>[] list;
    static int[] dist;
    static int[] distA;
    static int[] distB;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        Solution.n = n;
        Solution.s = s;
        Solution.a = a;
        Solution.b = b;
        Solution.fares = fares;

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int ss = fares[i][0];
            int ee = fares[i][1];
            int cc = fares[i][2];

            list[ss].add(new Node(ss, ee, cc));
            list[ee].add(new Node(ee, ss, cc));
        }

        dist = new int[n + 1];
        distA = new int[n + 1];
        distB = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.end]) continue;

            for (Node nn : list[cur.end]) {
                if (dist[cur.end] + nn.cost < dist[nn.end]) {
                    dist[nn.end] = dist[cur.end] + nn.cost;
                    pq.add(new Node(cur.end, nn.end, dist[nn.end]));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.add(new Node(a, a, 0));
        distA[a] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > distA[cur.end]) continue;

            for (Node nn : list[cur.end]) {
                if (distA[cur.end] + nn.cost < distA[nn.end]) {
                    distA[nn.end] = distA[cur.end] + nn.cost;
                    pq.add(new Node(cur.end, nn.end, distA[nn.end]));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.add(new Node(b, b, 0));
        distB[b] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > distB[cur.end]) continue;

            for (Node nn : list[cur.end]) {
                if (distB[cur.end] + nn.cost < distB[nn.end]) {
                    distB[nn.end] = distB[cur.end] + nn.cost;
                    pq.add(new Node(cur.end, nn.end, distB[nn.end]));
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= n; i++) {
            int sum = dist[i] + distA[i] + distB[i];
            answer = Math.min(answer, sum);
        }

        return answer;
    }
}