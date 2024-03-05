import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        long answer = (X + Y) * W;

        if ((X + Y) % 2 == 0) answer = Math.min(answer, Math.max(X, Y) * S);
        else answer = Math.min(answer, (Math.max(X, Y) - 1) * S + W);

        answer = Math.min(answer, (Math.min(X, Y)) * S + (Math.abs(X - Y)) * W);

        System.out.println(answer);
    }
}