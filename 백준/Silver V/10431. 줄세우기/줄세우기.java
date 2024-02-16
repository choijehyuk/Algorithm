import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();

            int answer = 0;
            for (int j = 0; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());
                int idx = Collections.binarySearch(list, num);
                if (idx < 0) idx = -(idx + 1);
                list.add(num);

                answer += list.size() - idx;
                Collections.sort(list);
            }
            answer -= 20;
            sb.append(T).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}