import java.util.*;

class Solution {
    static int n;
    static int[][] edge;
    static ArrayList<Integer>[] list;
    static int answer = 0;
    static int max = Integer.MIN_VALUE;
    static int[] dist;
    public int solution(int n, int[][] edge) {
        this.n = n;
        this.edge = edge;
        
        list = new ArrayList[n + 1];
        
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0 ; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            
            list[start].add(end);
            list[end].add(start);
        }
        
        dist[1] = 0;
        solve();
        
        for(int i = 1; i < dist.length; i++) {
            if(max < dist[i]) {
                answer = 1;
                max = dist[i];
            }
            else if(max == dist[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                if (dist[next] != Integer.MAX_VALUE) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
    }
}