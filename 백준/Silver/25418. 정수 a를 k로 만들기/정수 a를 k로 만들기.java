import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int r, cnt;

        public Point(int r, int cnt) {
            this.r = r;
            this.cnt = cnt;
        }
    }

    static int A, K;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        v = new boolean[1000001];
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(A,0);

    }

    private static void bfs(int r, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,cnt));
        v[r] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.r == K){
                System.out.println(p.cnt);
                System.exit(0);
            }

            int addr = p.r +1;
            if(addr <= K && ! v[addr]){
                q.add(new Point(addr,p.cnt+1));
                v[addr] = true;
            }

            int mulr = p.r * 2;
            if(mulr <= K && !v[mulr]){
                q.add(new Point(mulr,p.cnt+1));
                v[mulr] = true;
            }

        }
    }


}
