import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            list = new ArrayList<>();
            list.add(n);
            list.add(i);

            int prev = n;
            int now = i;

            while (true) {
                int num = prev - now;
                if (num >= 0) {
                    list.add(num);
                    prev = now;
                    now = num;
                } else {
                    break;
                }
            }

            if (max < list.size()) {
                ans = list;
            }
            max = Math.max(max, list.size());
        }

        System.out.println(max);
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }

}
