import java.util.*;
import java.io.*;

class Solution {
    static class Node implements Comparable<Node> {
        int e,c;
        
        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }
    
    static ArrayList<Node>[] adj;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 0; i < road.length; i ++) {
            int start = road[i][0];
            int end = road[i][1];
            int cost = road[i][2];
            
            adj[start].add(new Node(end, cost));
            adj[end].add(new Node(start,cost));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            int nextIdx = cur.e;
            
            if(cur.c > dist[nextIdx]) continue;
            
            
            for(Node next: adj[nextIdx]) {
                int nextCost = cur.c + next.c;
                if(nextCost < dist[next.e]) {
                    dist[next.e] = nextCost;
                    pq.add(new Node(next.e, nextCost));
                }
            }
        }
        
        for(int i = 0; i < dist.length; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}