import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int R = H / 2;
        int[] point = new int[2];
        double dist = 0;
        int answer = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            point[0] = Integer.parseInt(st.nextToken()) - X;
            point[1] = Integer.parseInt(st.nextToken()) - Y;

            if (point[0] >= 0 && point[0] <= W && point[1] >= 0 && point[1] <= H) {
                answer++;
                continue;
            }

            dist = Math.pow(Math.abs(point[0]), 2) + Math.pow(Math.abs(point[1] - R), 2);
            if (R * R >= dist) {
                answer++;
                continue;
            }

            dist = Math.pow(Math.abs(point[0] - W), 2) + Math.pow(Math.abs(point[1] - R), 2);
            if (R * R >= dist) {
                answer++;
                continue;
            }
        }
        System.out.println(answer);
    }
}