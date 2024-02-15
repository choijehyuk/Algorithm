import java.util.*;
import java.io.*;

public class Main {
    static class Point{
        int prefer, alcohol;
        public Point(int prefer, int alcohol){
            this.prefer = prefer;
            this.alcohol = alcohol;
        }
    }
    static int N,M,K;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Point(v,c));
        }

        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.alcohol == o2.alcohol){
                    return Integer.compare(o1.prefer , o2.prefer);
                }

                return Integer.compare(o1.alcohol,o2.alcohol);
            }
        });

        int sum = 0;
        for (Point point : list) {
            q.add(point.prefer);
            sum += point.prefer;

            if(q.size() > N) sum -= q.poll();
            if(q.size() == N && sum >= M){
                answer = point.alcohol;
                break;
            }
        }
        System.out.println(answer);
    }
}