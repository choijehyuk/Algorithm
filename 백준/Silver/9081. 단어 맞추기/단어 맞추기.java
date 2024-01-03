import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            char[] word = new char[s.length()];

            ArrayList<Character> list = new ArrayList<>();

            for (int i = 0; i < word.length; i++) {
                list.add(s.charAt(i));
            }

            for (int i = word.length - 1; i > 0; i--) {
                char now = list.get(i);
                char prev = list.get(i - 1);

                if (now > prev) {
                    char min = now;
                    int idx = i;

                    for (int j = i + 1; j < word.length; j++) {
                        char c = list.get(j);
                        if (c > prev && min > c) {
                            min = c;
                            idx = j;
                        }
                    }

                    list.remove(idx);
                    list.remove(i - 1);
                    list.add(i - 1, min);
                    list.add(prev);

                    Collections.sort(list.subList(i, word.length));

                    break;
                }
            }

            for (Character c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}