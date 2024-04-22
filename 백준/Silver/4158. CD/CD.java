import java.util.*;
import java.io.*;

public class Main {
    static int n,m,answer;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            set = new HashSet<>();
            answer = 0;

            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for (int j = 0; j < n; j++) {
                int cd = Integer.parseInt(br.readLine());

                if (set.contains(cd)) answer++;
            }

            System.out.println(answer);
        }

    }
}