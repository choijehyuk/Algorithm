import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        char[] c = new char[]{'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < c.length; i++) {
            set.add(c[i]);
        }

        while (true) {
            String s = br.readLine();
            boolean flag = true;
            boolean hasOne = false;
            boolean three = false;

            if (s.equals("end")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char cc = s.charAt(i);
                for (int j = 0; j < c.length; j++) {
                    if (cc == c[j]) {
                        hasOne = true;
                    }
                }
            }

            for (int i = 0; i < s.length() - 2; i++) {
                if (set.contains(s.charAt(i))) {
                    if (set.contains(s.charAt(i + 1))) {
                        if (set.contains(s.charAt(i + 2))) {
                            three = true;
                            break;
                        }
                    }
                }

                if (!set.contains(s.charAt(i))) {
                    if (!set.contains(s.charAt(i + 1))) {
                        if (!set.contains(s.charAt(i + 2))) {
                            three = true;
                            break;
                        }
                    }
                }
            }

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    if (s.charAt(i) == 'e' || s.charAt(i) == 'o') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!hasOne || !flag || three) {
                sb.append("<" + s + "> is not acceptable.\n");
            } else {
                sb.append("<" + s + "> is acceptable.\n");
            }
        }
        System.out.println(sb);
    }
}