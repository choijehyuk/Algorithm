import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sum = (K * (K + 1)) / 2;

        if (sum > N) {
            System.out.println("-1");
            System.exit(0);
        }

        int ans = (N - sum) % K > 0 ? K : K - 1;

        System.out.println(ans);

    }
}