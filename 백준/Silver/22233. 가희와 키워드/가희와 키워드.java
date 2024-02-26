import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {

            String[] str = br.readLine().split(",");

            for (int j = 0; j < str.length; j++) {
                if (set.contains(str[j])) set.remove(str[j]);
            }
            sb.append(set.size()).append("\n");

        }
        System.out.println(sb);
    }
}