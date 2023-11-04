import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String clothes = st.nextToken();

                if (map.containsKey(clothes)) {
                    int val = map.get(clothes).intValue();

                    map.put(clothes, (val + 1));
                } else {
                    map.put(clothes, 1);
                }
            }

            int answer = 1;

            for (Integer value : map.values()) {
                answer *= (value + 1);
            }
            answer -= 1;
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}