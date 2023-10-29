import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int idx, input;

        public Point(int idx, int input) {
            this.idx = idx;
            this.input = input;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            LinkedList<Point> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                q.add(new Point(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Point poll = q.poll();

                boolean isMax = true;

                for (int i = 0; i < q.size(); i++) {
                    if(poll.input < q.get(i).input){
                        q.add(poll);

                        for (int j = 0; j < i; j++) {
                            q.add(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax){
                    continue;
                }

                cnt++;
                if(poll.idx == M){
                    break;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);

    }


}