import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Point sangen, festival;
    static Point[] store;
    static final int DISTANCE = 20 * 50;
    static boolean flag = false;
    static boolean[] v;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            flag = false;
            int n = Integer.parseInt(br.readLine()); 
            store = new Point[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sangen = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); 
            for(int j = 0; j < n; j++) {
            	st = new StringTokenizer(br.readLine());
                store[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            v = new boolean[n];
            solution(sangen.x, sangen.y);

            if(flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static void solution(int curX, int curY) {
        if(flag) return;

        if(Math.abs(curX - festival.x) + Math.abs(curY - festival.y) <= DISTANCE) {
            flag = true;
            return;
        }

        for(int i = 0; i < store.length; i++) {
            if(v[i]) continue;

            if(Math.abs(curX - store[i].x) + Math.abs(curY - store[i].y) > DISTANCE) continue;

            v[i] = true;
            solution(store[i].x, store[i].y);
        }
    }
}