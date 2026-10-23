import java.util.*;

class Solution {
    static class Node {
        int s,e,idx;
        public Node(int s, int e, int idx) {
            this.s = s;
            this.e = e;
            this.idx = idx;
        }
    }
    static int[] info;
    static int[][] edges;
    static ArrayList<Node> list;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        
        
        list = new ArrayList<>();
        
        for(int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            list.add(new Node(start,end,i));
        }
        
        solve(1,0, new ArrayList<>(), new boolean[info.length]);
        
        int answer = max;
        return answer;
        
    }
    
    public static void solve(int sheep, int wolf, ArrayList<Integer> animals, boolean[] v) {
        
        if(animals.isEmpty()) {
            animals.add(0);
            v[0] = true;
        }
        
        if(sheep > max) max = sheep;
        
        ArrayList<Integer> next = new ArrayList<>();
        
        for (int i : animals) {
            for (Node n : list) {
                if (n.s == i && !v[n.e]) {
                    next.add(n.e);
                }
            }
        }
        
        for (int x : next) {
            int ns = sheep, nw = wolf;         
            if (info[x] == 0) ns++;
            else nw++;

            if (ns <= nw) continue;             

            animals.add(x);                    
            v[x] = true;

            solve(ns, nw, animals, v);

            animals.remove(animals.size() - 1); 
            v[x] = false;
        }
        
    }
}