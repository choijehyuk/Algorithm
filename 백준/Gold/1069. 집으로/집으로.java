import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double dist = Math.sqrt(X * X + Y * Y);
        double answer = Integer.MAX_VALUE;

        if (T > D) {
            System.out.println(dist);
            System.exit(0);
        }
        int jump = (int) (dist / D);

        double time = dist - D * jump;

        answer = Math.min(answer, time + T * jump);

        answer = Math.min(answer, D * (jump + 1) - dist + T * (jump + 1));

        if (jump > 0) answer = Math.min(answer, (jump + 1) * T);
        else if (dist < D) answer = Math.min(answer, T * 2);

        System.out.println(answer);
    }

}