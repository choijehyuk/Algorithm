import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(st.nextToken());
        }

        int[] grow = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grow);

        for (int i = 0; i < N; i++) {
            answer += grow[i] * i;
        }

        System.out.println(answer);


    }
}