import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            int keys[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String key = st.nextToken();
                map.put(key, i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String key = st.nextToken();
                keys[i] = map.get(key);
            }
            st = new StringTokenizer(br.readLine());
            String answer[] = new String[N];
            for (int i = 0; i < N; i++) {
                answer[keys[i]] = st.nextToken();
            }
            for (int i = 0; i < N; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}