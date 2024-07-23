import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        int[] cnt = new int[4];
        for (int i = 0; i < str.length(); i += 3) {
            String cur = str.substring(i, i + 3);
            if (set.contains(cur)) {
                System.out.println("GRESKA");
                return;
            }
            set.add(cur);

            switch (cur.charAt(0)) {
                case 'P':
                    cnt[0]++;
                    break;
                case 'K':
                    cnt[1]++;
                    break;
                case 'H':
                    cnt[2]++;
                    break;
                case 'T':
                    cnt[3]++;
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {
            sb.append(13 - cnt[i]).append(' ');
        }
        System.out.println(sb);
    }
}