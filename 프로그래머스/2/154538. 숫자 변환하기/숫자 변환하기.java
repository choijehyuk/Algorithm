import java.util.*;

class Solution {
    static class Point{
        int num, cnt;
        public Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    static int answer = -1;
    public int solution(int x, int y, int n) {

        bfs(x,y,n);
        return answer;
    }
    
    private static void bfs(int x, int y, int n){
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[y+1];
        //Arrays.fill(v,Integer.MAX_VALUE);
        q.add(new Point(x,0));
        v[x] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.num == y){
                answer = p.cnt;
                return;
            }
            
            int cal = p.num + n; 
            if(cal <= y && !v[cal]){
                v[cal] = true;
                q.add(new Point(cal, p.cnt+1));
            }
            
            cal = p.num * 2;
            if(cal <= y && !v[cal]){
                v[cal] = true;
                q.add(new Point(cal, p.cnt+1));
            }
            
            cal = p.num * 3;
            if(cal <= y && !v[cal]){
                v[cal] = true;
                q.add(new Point(cal, p.cnt+1));
            }
        }
    }
}